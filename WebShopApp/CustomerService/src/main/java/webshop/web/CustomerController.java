package webshop.web;

import webshop.DTO.CustomerDTO;
import webshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers/{customerNumber}")
    public ResponseEntity<?> getCustomer(@PathVariable long customerNumber) {
        CustomerDTO customerDTO = customerService.getCustomer(customerNumber);
        return new ResponseEntity<CustomerDTO>(customerDTO , HttpStatus.OK);
    }
    @PostMapping("/customers")
    public ResponseEntity<?> addCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.addCustomer(customerDTO);
        return  new ResponseEntity<CustomerDTO>(customerDTO, HttpStatus.OK);
    }
    @DeleteMapping("/customers/{customerNumber}")
    public ResponseEntity<?> deleteCustomer(@PathVariable long customerNumber) {
        customerService.deleteCustomer(customerNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/customers/{customerNumber}")
    public ResponseEntity<?> updateCustomer(@PathVariable long customerNumber, @RequestBody CustomerDTO customerDTO) {
        customerService.updateCustomer(customerNumber,customerDTO);
        return new ResponseEntity<CustomerDTO>(customerDTO, HttpStatus.OK);
    }
}
