package webshop.kafka;

import webshop.DTO.CustomerDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {

    @Autowired
    private KafkaTemplate<String, CustomerDTO> kafkaTemplate;

    public void send(String topic, CustomerDTO customer) {
        kafkaTemplate.send(topic,customer);
    }
}
