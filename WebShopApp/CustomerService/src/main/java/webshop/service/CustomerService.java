package webshop.service;

import webshop.DTO.CustomerDTO;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    public  CustomerDTO getCustomer(long customerNumber);
    public void addCustomer(CustomerDTO customerDTO);
    public void deleteCustomer(long customerNumber);
    public void updateCustomer(long customerNumber, CustomerDTO customerDTO);
}
