package webshop.kafka;

import org.springframework.messaging.handler.annotation.Header;
import webshop.DTO.OrderAdapter;
import webshop.DTO.OrderDTO;
import webshop.repository.OrderQueriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Receiver {
    @Autowired
    OrderQueriesRepository orderQueriesRepository;

    @KafkaListener(topics={"order_topic"})
    public void receive(@Payload OrderDTO orderDTO ) {
        System.out.println("message received: " + orderDTO);
        orderQueriesRepository.save(OrderAdapter.getOrderFromOrderDTO(orderDTO));
    }
}
