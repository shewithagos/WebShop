package webshop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Order {
    @Id
    private long orderNumber;
    private LocalDate date;
    private double totalPrice;
    private List<Product> products;
    private Customer customer;
    private Payment payment;

    public void addProduct(Product product) {
        products.add(product);
    }
}
