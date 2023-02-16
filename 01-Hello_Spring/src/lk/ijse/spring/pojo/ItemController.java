package lk.ijse.spring.pojo;

import org.springframework.stereotype.Component;

@Component("item")  // change bean ID
public class ItemController {
    public ItemController(){
        System.out.println("Item Controller : instantiated !");
    }
}
