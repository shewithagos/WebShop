package webshop.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import webshop.DTO.CustomerDTO;
import webshop.DTO.OrderDTO;
import webshop.DTO.PaymentDTO;
import webshop.DTO.ProductDTO;
import webshop.domain.Customer;
import webshop.domain.Order;
import webshop.domain.Product;
import webshop.repository.OrderRepository;
import webshop.service.OrderService;

@Service
public class Receiver {

    @Autowired
    Sender sender;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @KafkaListener(topics = {"customer_topic"})
    public void receive(@Payload CustomerDTO customerDTO) {
        Customer c = new Customer(customerDTO.getCustomerNumber(),customerDTO.getName());
        Order o = orderRepository.findOrderByCustomerNumber(customerDTO.getCustomerNumber());
        o.getCustomer().setName(c.getName());
        orderRepository.save(o);
//        OrderDTO orderDTO = new OrderDTO(o.getOrderNumber(),o.getDate(),o.getProducts(),c);
//        sender.send("order_topic1",orderDTO);
    }

    @KafkaListener(topics = {"product_topic"})
    public void receive(@Payload ProductDTO productDTO) {
        Product p1 = new Product(productDTO.getProductNumber(),productDTO.getName(),productDTO.getPrice(),productDTO.getQuantity());
        Order o = orderRepository.findOrderByProductNumber(productDTO.getProductNumber());
        for(Product p : o.getProducts()) {
            if(p.getProductNumber() == p1.getProductNumber() ) {
                p.setName(p1.getName());
            }
        }
        orderRepository.save(o);
//        OrderDTO orderDTO = new OrderDTO(o.getOrderNumber(),o.getDate(),o.getProducts(),o.getCustomer());
//        sender.send("order_topic2",orderDTO);

    }
}
