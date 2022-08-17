package webshop.DTO;


import webshop.domain.Customer;
import webshop.domain.Payment;
import webshop.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private long orderNumber;
    private LocalDate date;
    private double totalPrice;
    private List<Product> products;
    private Customer customer;
    private Payment payment;
}
