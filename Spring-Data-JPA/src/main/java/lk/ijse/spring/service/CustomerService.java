package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerService {
    public void addCustomer(CustomerDTO dto);

    public void deleteCustomer(String id);

    public void updateCustomer(CustomerDTO dto);

    public ArrayList<CustomerDTO> getAllCustomers();
}
