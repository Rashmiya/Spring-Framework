package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void addItem(ItemDTO dto) {
        if(repo.existsById(dto.getCode())){  /*Item ekak already innawanm*/
            throw new RuntimeException("Customer "+dto.getCode()+" already exist...");
        }
        Item itemEntity = mapper.map(dto, Item.class);   //replaced by using modelMapper
        repo.save(itemEntity);
    }

    @Override
    public void updateItem(ItemDTO dto) {
        if(!repo.existsById(dto.getCode())){
            throw new RuntimeException("Item "+dto.getCode()+" Not Available to update");
        }
        Item updateItem = mapper.map(dto, Item.class);  //replaced by using modelMapper
        repo.save(updateItem);
    }

    @Override
    public void deleteItem(String code) {
        if(repo.existsById(code)){
            repo.deleteById(code);  /*if item exist delete that item*/
        }else {
            throw new RuntimeException("Item "+code +" not available to delete");
        }
    }

    @Override
    public ArrayList<ItemDTO> getAllItems() {
        List<Item> all = repo.findAll();
        return mapper.map(all,new TypeToken<ArrayList<ItemDTO>>(){}.getType());
    }
}
