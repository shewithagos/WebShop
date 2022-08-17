package webshop.DTO;

import webshop.domain.Customer;

public class CustomerAdapter {
    public static Customer getCustomerFromCustomerDTO(CustomerDTO customerdto) {
        Customer customer = new Customer(customerdto.getCustomerNumber(),
                customerdto.getName(), customerdto.getContact(),customerdto.getAddress());
        return customer;
    }

    public static CustomerDTO getCustomerDTOFromCustomer(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO(customer.getCustomerNumber(),
                customer.getName(), customer.getContact(),customer.getAddress());
        return customerDTO;
    }
}
