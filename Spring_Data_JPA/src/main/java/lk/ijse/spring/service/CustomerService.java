package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;

import java.util.List;

public interface CustomerService {
    public void addCustomer(CustomerDTO dto);

    public void deleteCustomer(String id);

    public List<CustomerDTO> getAllCustomer();

    public CustomerDTO findCustomer(String id);

    public void updateCustomer(CustomerDTO c);
}
