package lk.ijse.spring.pojo;

import org.springframework.stereotype.Component;

@Component
public class SpringBean {
    //create constructor
    public SpringBean(){
        System.out.println("SpringBean : Instantiated!");
    }
}
