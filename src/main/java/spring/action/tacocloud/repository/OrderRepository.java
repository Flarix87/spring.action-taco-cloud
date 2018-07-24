package spring.action.tacocloud.repository;

import org.springframework.data.repository.CrudRepository;
import spring.action.tacocloud.model.Order;

public interface OrderRepository extends CrudRepository<Order,Long>{
}
