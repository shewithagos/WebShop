package webshop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Payment {
    @Id
    private long paymentNumber;
    private LocalDate date;
    private double amount;
    private long orderNumber;
    private long customerNumber;
}
