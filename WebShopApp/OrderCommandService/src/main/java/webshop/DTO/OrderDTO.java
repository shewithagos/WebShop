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

    public OrderDTO(long orderNumber, LocalDate date , List<Product> products, Customer customer) {
        this.orderNumber = orderNumber;
        this.date = date;
        this.products = products;
        this.customer = customer;
    }

    public void addPayment(Payment payment) {
        this.payment = payment;
    }
    public void addProduct(Product product) {
        products.add(product);
    }

    public Product getProduct(long productNumber) {
        for(Product p : products) {
            if(p.getProductNumber()==productNumber) return p;
        }
        return null;
    }

    public double getTotalPrice(List<Product> products) {
        double sum=0;
        for(Product d : products) {
            sum+=d.getPrice();
        }
        return sum;
    }
}
