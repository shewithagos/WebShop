package webshop.service;


import webshop.DTO.OrderAdapter;
import webshop.DTO.OrderDTO;
import webshop.domain.Order;
import webshop.repository.OrderQueriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    private OrderQueriesRepository orderQueriesRepository;


    @Override
    public OrderDTO getOrder(long orderNumber) {
        Order order = orderQueriesRepository.findById(orderNumber);
        return OrderAdapter.getOrderDTOFromOrder(order);
    }
}
