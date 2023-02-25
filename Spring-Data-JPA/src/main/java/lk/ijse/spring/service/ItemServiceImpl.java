package lk.ijse.spring.service;

import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.repo.ItemRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{

    @Autowired
    ItemRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void addItem(ItemDTO dto) {
        Item itemEntity = mapper.map(dto, Item.class);   //replaced by using modelMapper
        repo.save(itemEntity);
    }

    @Override
    public void updateItem(ItemDTO dto) {
        Item updateItem = mapper.map(dto, Item.class);  //replaced by using modelMapper
        repo.save(updateItem);
    }

    @Override
    public void deleteItem(String code) {
        repo.deleteById(code);
    }

    @Override
    public ArrayList<ItemDTO> getAllItems() {
        List<Item> all = repo.findAll();
        return mapper.map(all,new TypeToken<ArrayList<ItemDTO>>(){}.getType());
    }
}
