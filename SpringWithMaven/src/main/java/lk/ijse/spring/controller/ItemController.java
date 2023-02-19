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
        return new ResponseUtil(200,dto.toString()+"Item Added Successfully",null);
    }

    @PutMapping
    public ResponseUtil updateItem(@RequestBody ItemDTO dto){
        System.out.println(dto.toString());
        return new ResponseUtil(200,dto.toString()+"Item Updated",null);
    }

    @DeleteMapping(params = "id")
    public ResponseUtil deleteItem(String id){
        System.out.println(id);
        return new ResponseUtil(200,id+"Item deleted",null);
    }

    @GetMapping
    public ResponseUtil getAllItems(){
        ArrayList<ItemDTO> allItems = new ArrayList<>();
        allItems.add(new ItemDTO("I001","Smaba Rice 5kg",25,340.00));
        allItems.add(new ItemDTO("I002","Milkmaid",35,530.00));
        allItems.add(new ItemDTO("I003","Noodles 500g",22,498.00));
        allItems.add(new ItemDTO("I004","Semon Tin small",40,420.00));
        allItems.add(new ItemDTO("I005","Flour 10kg",12,5430.00));
        return new ResponseUtil(200,"Success",allItems);
    }
}
