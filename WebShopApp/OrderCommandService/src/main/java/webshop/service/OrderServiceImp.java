package webshop.service;

import webshop.DTO.OrderAdapter;
import webshop.DTO.OrderDTO;
import webshop.domain.Order;
import webshop.domain.Payment;
import webshop.kafka.Sender;
import webshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    Sender sender;


    @Override
    public OrderDTO getOrder(long orderNumber) {
         Order order = orderRepository.findById(orderNumber);
         return OrderAdapter.getOrderDTOFromOrder(order);
    }

    @Override
    public void placeOrder(OrderDTO orderDTO) {
        Order order = OrderAdapter.getOrderFromOrderDTO(orderDTO);
        order.setTotalPrice(order.getTotalPrice(orderDTO.getProducts()));
        sender.send("order_topic", orderDTO);
        orderRepository.save(order);
    }

    @Override
    public void addPayment(long orderNumber, Payment payment) {
        Order order = orderRepository.findById(orderNumber);
        order.addPayment(payment);
        orderRepository.save(order);
    }
}
