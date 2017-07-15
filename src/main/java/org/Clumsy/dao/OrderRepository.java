package org.Clumsy.dao;

import org.Clumsy.dao.operations.OrderOperations;
import org.Clumsy.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by slow_time on 2017/7/15.
 */
public interface OrderRepository extends MongoRepository<Order, String>, OrderOperations {
    List<Order> findByCustomer(String c);

    List<Order> findByCustomerLike(String c);

    List<Order> findByCustomerAndType(String c, String t);

    @Query("{'customer': 'Chunk Wagon', 'type': ?0}")
    List<Order> findChuncksOrders(String t);
}
