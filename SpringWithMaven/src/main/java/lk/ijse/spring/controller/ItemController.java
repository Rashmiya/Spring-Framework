package lk.ijse.spring.controller;

import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/item")
@CrossOrigin
public class ItemController {
    @PostMapping
    public ResponseUtil saveItem(@ModelAttribute ItemDTO dto){
        System.out.println(dto.toString());
        return new ResponseUtil(200,dto.toString()+"Successfully Added Item",null);
    }

    @PutMapping
    public ResponseUtil updateItem(@RequestBody ItemDTO dto){
        System.out.println(dto.toString());
        return new ResponseUtil(200,dto.toString()+"Item Updated",null);
    }

    @DeleteMapping(params = "code")
    public ResponseUtil deleteItem(String code){
        System.out.println(code);
        return new ResponseUtil(200,code+"Item Deleted",null);
    }

    @GetMapping
    public ResponseUtil getAllItems(){
        ArrayList<ItemDTO> allItems = new ArrayList<>();
        allItems.add(new ItemDTO("I001","Noodles",50,455));
        allItems.add(new ItemDTO("I002","Shampo",120,320));
        allItems.add(new ItemDTO("I003","Samba 5kg",200,879));
        allItems.add(new ItemDTO("I004","Samon Tin small",76,350));
        allItems.add(new ItemDTO("I005","Sugar 5kg",12,540));
        return new ResponseUtil(200,"Succesfull",allItems);
    }
}
