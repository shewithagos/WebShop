package webshop.service;

import webshop.DTO.CustomerAdapter;
import webshop.DTO.CustomerDTO;
import webshop.domain.Customer;
import webshop.kafka.Sender;
import webshop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    Sender sender;
    @Override
    public CustomerDTO getCustomer(long customerNumber) {
        Customer customer = customerRepository.findById(customerNumber);
        return CustomerAdapter.getCustomerDTOFromCustomer(customer);
    }
    @Override
    public void addCustomer(CustomerDTO customerDTO) {
        Customer customer = CustomerAdapter.getCustomerFromCustomerDTO(customerDTO);
        customerRepository.save(customer);
    }
    @Override
    public void deleteCustomer(long customerNumber) {
        Customer customer = customerRepository.findById(customerNumber);
        customerRepository.delete(customer);
    }
    @Override
    public void updateCustomer(long customerNumber, CustomerDTO customerDTO) {
        Customer customer = customerRepository.findById(customerNumber);
        customer.setCustomerNumber(customerNumber);
        customer.setName(customerDTO.getName());
        customer.setContact(customerDTO.getContact());
        customer.setAddress(customerDTO.getAddress());
        sender.send("customer_topic", customerDTO);

        customerRepository.save(customer);

    }



}
