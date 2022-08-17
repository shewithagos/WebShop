package webshop.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import webshop.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, Long> {
    Order findById(long orderNumber);

    @Query("{'customer.customerNumber'::#{#customerNumber}}")
    Order findOrderByCustomerNumber(@Param("customerNumber") long customerNumber);

    @Query("{'products':{$elemMatch:{'productNumber'::#{#productNumber}}}}")
    Order findOrderByProductNumber(@Param("productNumber") long productNumber);

    @Query("{'payment.paymentNumber'::#{#paymentNumber}}")
    Order findOrderByPaymentNumber(@Param("paymentNumber") long paymentNumber);
}
