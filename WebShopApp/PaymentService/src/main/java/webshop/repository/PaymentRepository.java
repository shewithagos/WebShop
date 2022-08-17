package webshop.repository;

import webshop.domain.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends MongoRepository<Payment,Long> {
    Payment findById(long paymentNumber);
}
