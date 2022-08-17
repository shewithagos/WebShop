package webshop.repository;

import webshop.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderQueriesRepository extends MongoRepository<Order,Long> {
    Order findById(long orderNumber);
}
