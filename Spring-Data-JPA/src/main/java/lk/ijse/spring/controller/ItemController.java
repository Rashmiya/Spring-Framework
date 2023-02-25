package lk.ijse.spring.controller;

import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.service.impl.ItemServiceImpl;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/item")
@CrossOrigin
public class ItemController {
    /*@Autowired
    ItemRepo repo;

    @Autowired
    ModelMapper mapper;*/

    @Autowired
    ItemServiceImpl service;

    @PostMapping
    public ResponseUtil saveItem(@ModelAttribute ItemDTO dto){
       /* System.out.println(dto.toString());
        Item item = new Item(dto.getCode(), dto.getDescription(),dto.getQtyOnHand(),dto.getUnitPrice());*/

      /*  Item itemEntity = mapper.map(dto, Item.class);   //replaced by using modelMapper
        repo.save(itemEntity);*/
        service.addItem(dto);
        return new ResponseUtil(200,dto.toString()+"Successfully Added Item",null);
    }

    @PutMapping
    public ResponseUtil updateItem(@RequestBody ItemDTO dto){
        /*System.out.println(dto.toString());
        Item updateItem = new Item(dto.getCode(), dto.getDescription(),dto.getQtyOnHand(),dto.getUnitPrice());*/

       /* Item updateItem = mapper.map(dto, Item.class);  //replaced by using modelMapper
        repo.save(updateItem);*/
        service.updateItem(dto);
        return new ResponseUtil(200,dto.toString()+"Item Updated",null);
    }

    @DeleteMapping(params = "code")
    public ResponseUtil deleteItem(String code){
       /* System.out.println(code);
        repo.deleteById(code);*/
        service.deleteItem(code);
        return new ResponseUtil(200,code+"Item Deleted",null);
    }

    @GetMapping
    public ResponseUtil getAllItems(){
        /*ArrayList<ItemDTO> allItems = new ArrayList<>();
        allItems.add(new ItemDTO("I001","Noodles",50,455));
        allItems.add(new ItemDTO("I002","Shampo",120,320));
        allItems.add(new ItemDTO("I003","Samba 5kg",200,879));
        allItems.add(new ItemDTO("I004","Samon Tin small",76,350));
        allItems.add(new ItemDTO("I005","Sugar 5kg",12,540));
        */
//        return new ResponseUtil(200,"Succesfull",allItems);
       /* List<Item> all = repo.findAll();*/

        ArrayList<ItemDTO> allItems = service.getAllItems();
        return new ResponseUtil(200,"Successfull",allItems);
    }
}
