package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class customerServiceImpl {
    @Autowired
    CustomerRepo repo;

    @Autowired
    ModelMapper mapper;

    public void addCustomer(CustomerDTO dto){
        Customer customerEntity = mapper.map(dto, Customer.class);  // replaced by using modelMapper
        repo.save(customerEntity);
    }

    public void deleteCustomer(String id){
        repo.deleteById(id);
    }

    public void updateCustomer(CustomerDTO dto){
        Customer updateCustomer = mapper.map(dto, Customer.class);   // replaced by using modelMapper
        repo.save(updateCustomer);
    }

    public ArrayList<CustomerDTO> getAllCustomers(){
        List<Customer> all = repo.findAll();
        return mapper.map(all,new TypeToken<ArrayList<CustomerDTO>>(){}.getType());
    }
}
