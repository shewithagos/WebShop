package webshop.service;


import webshop.DTO.OrderDTO;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    public OrderDTO getOrder(long orderNumber);
}
