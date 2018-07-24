package spring.action.tacocloud.repository;

import org.springframework.data.repository.CrudRepository;
import spring.action.tacocloud.model.Taco;

public interface TacoRepository extends CrudRepository<Taco,Long> {
}
