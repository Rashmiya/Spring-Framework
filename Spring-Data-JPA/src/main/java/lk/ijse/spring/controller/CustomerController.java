package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin  /*handle all the cross policy errors*/
public class CustomerController {

    @Autowired
    CustomerRepo repo;

    @Autowired
    ModelMapper mapper;

    @PostMapping
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO dto){
//        System.out.println(dto.toString());

        /*create customer object and put dto objects into customerObject*/
       /* Customer customer = new Customer(dto.getId(), dto.getName(), dto.getAddress(), dto.getSalary());*/

        Customer customerEntity = mapper.map(dto, Customer.class);  // replaced by using modelMapper
        repo.save(customerEntity);
        
        return new ResponseUtil(200,dto.toString()+"Successfully Added",null);
    }

    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO dto){
      /*  System.out.println(dto.toString());
        Customer updateCustomer = new Customer(dto.getId(),dto.getName(), dto.getAddress(), dto.getSalary());*/

        Customer updateCustomer = mapper.map(dto, Customer.class);   // replaced by using modelMapper
        repo.save(updateCustomer);

        return new ResponseUtil(200,dto.toString()+"Customer Updated",null);
    }

    @DeleteMapping(params = "id")
    public ResponseUtil deleteCustomer(String id){
//        System.out.println(id);

        repo.deleteById(id);
        return new ResponseUtil(200,id+"Customer Deleted",null);
    }

    @GetMapping
    public ResponseUtil getAllCustomer(){
        /*ArrayList<CustomerDTO> allCustomers = new ArrayList<>();*/
        /* allCustomers.add(new CustomerDTO("C001","Rashmiya","Padukka",45000));
        allCustomers.add(new CustomerDTO("C002","Nipun","Colombo",34500));
        allCustomers.add(new CustomerDTO("C003","kamal","Nugegoda",54000));
        allCustomers.add(new CustomerDTO("C004","Sunil","Meepe",20000));
        allCustomers.add(new CustomerDTO("C005","Jayanthi","Waththala",30000));*/

        /*return new ResponseUtil(200,"Success",allCustomers);*/

        List<Customer> all = repo.findAll();
        return new ResponseUtil(200,"Success",all);
    }
}
