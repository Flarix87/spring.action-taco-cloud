package spring.action.tacocloud.repository;

import org.springframework.data.repository.CrudRepository;
import spring.action.tacocloud.model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient,String> {
}
