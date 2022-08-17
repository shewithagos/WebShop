package webshop.kafka;

import webshop.DTO.PaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {

    @Autowired
    private KafkaTemplate<String, PaymentDTO> kafkaTemplate;

    public void send(String topic, PaymentDTO paymentDTO) {
        kafkaTemplate.send(topic, paymentDTO);
    }
}
