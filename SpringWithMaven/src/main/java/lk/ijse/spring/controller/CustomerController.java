package lk.ijse.spring.controller;

import lk.ijse.spring.dto.customerDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@CrossOrigin  /*handle all the cross policy errors*/
public class CustomerController {

    @PostMapping
    public String saveCustomer(customerDTO dto){
        System.out.println(dto.toString());
        return "Customer Added";
    }

    public String updateCustomer(){}
}
