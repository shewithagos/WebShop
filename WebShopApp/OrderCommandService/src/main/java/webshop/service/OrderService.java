package webshop.service;

import webshop.DTO.OrderDTO;
import webshop.domain.Payment;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    public OrderDTO getOrder(long orderNumber);
    public void placeOrder(OrderDTO orderDTO);

    public void addPayment(long orderNumber, Payment payment);
}
