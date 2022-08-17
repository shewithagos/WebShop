package webshop.DTO;

import webshop.domain.Payment;

public class PaymentAdapter {
    public static Payment getPaymentFromPaymentDTO(PaymentDTO paymentDTO) {
        Payment payment = new Payment(paymentDTO.getPaymentNumber(), paymentDTO.getDate(),
                paymentDTO.getAmount(), paymentDTO.getOrderNumber(),paymentDTO.getCustomerNumber());
        return payment;
    }
    public static PaymentDTO getPaymentDTOFromPayment(Payment payment) {
        PaymentDTO paymentDTO = new PaymentDTO(payment.getPaymentNumber(),payment.getDate(),
                payment.getAmount(),payment.getOrderNumber(),payment.getCustomerNumber());
        return paymentDTO;
    }
}
