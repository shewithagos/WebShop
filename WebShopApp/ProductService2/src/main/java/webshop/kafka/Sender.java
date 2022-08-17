package webshop.kafka;

import webshop.DTO.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {
    @Autowired
    private KafkaTemplate<String, ProductDTO> kafkaTemplate;

    public void send(String topic, ProductDTO productDTO) {
        kafkaTemplate.send(topic,productDTO);
    }
}
