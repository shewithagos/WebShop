package webshop.service;

import webshop.DTO.PaymentDTO;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    public PaymentDTO getPayment(long paymentNumber);
    public void addPayment(PaymentDTO paymentDTO);
    public void deletePayment(long paymentNumber);
    public void updatePayment(long paymentNumber, PaymentDTO paymentDTO);
}
