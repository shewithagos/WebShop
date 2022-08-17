package webshop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
    private long paymentNumber;
    private LocalDate date;
    private double amount;
    private long orderNumber;
    private long customerNumber;
}
