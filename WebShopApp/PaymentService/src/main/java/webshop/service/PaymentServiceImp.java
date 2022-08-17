package webshop.service;

import webshop.DTO.PaymentAdapter;
import webshop.DTO.PaymentDTO;
import webshop.domain.Payment;
import webshop.kafka.Sender;
import webshop.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImp implements PaymentService{
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    Sender sender;

    @Override
    public PaymentDTO getPayment(long paymentNumber) {
         Payment payment = paymentRepository.findById(paymentNumber);
         return PaymentAdapter.getPaymentDTOFromPayment(payment);
    }

    @Override
    public void addPayment(PaymentDTO paymentDTO) {
        Payment payment = PaymentAdapter.getPaymentFromPaymentDTO(paymentDTO);
        paymentRepository.save(payment);

    }

    @Override
    public void deletePayment(long paymentNumber) {
        Payment payment = paymentRepository.findById(paymentNumber);
        paymentRepository.delete(payment);
    }

    @Override
    public void updatePayment(long paymentNumber, PaymentDTO paymentDTO) {
        Payment payment = paymentRepository.findById(paymentNumber);
        payment.setPaymentNumber(paymentDTO.getPaymentNumber());
        payment.setDate(paymentDTO.getDate());
        payment.setAmount(paymentDTO.getAmount());
        payment.setCustomerNumber(paymentDTO.getCustomerNumber());
        payment.setOrderNumber(paymentDTO.getOrderNumber());

        sender.send("payment_topic", paymentDTO);

        paymentRepository.save(payment);
    }
}
