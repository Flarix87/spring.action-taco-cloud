package spring.action.tacocloud.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;
import spring.action.tacocloud.model.Ingredient;
import spring.action.tacocloud.model.Taco;
import spring.action.tacocloud.repository.IngredientRepository;
import spring.action.tacocloud.repository.TacoRepository;

import javax.validation.Valid;


@Slf4j//Sirve para loguear
@Controller
@RequestMapping("/design")
@NoArgsConstructor
public class DesignTacoController {
    private TacoRepository tacoRepository;
    private IngredientRepository ingredientRepository;

    public DesignTacoController(TacoRepository tacoRepository, IngredientRepository ingredientRepository) {
        this.tacoRepository = tacoRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping
    public String showDesignForm(Model model) {
        /*List<Ingredient> ingredients = Arrays.asList(new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP), new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP), new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN), new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN), new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES), new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES), new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE), new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE), new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE), new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE));
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }*/
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(i -> ingredients.add(i));
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
        model.addAttribute("design", new Taco());
        return "design";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }

    @PostMapping
    private String proccesDesignTaco(@Valid Taco design, Errors errorTaco){
      /* if(errorTaco.hasErrors())
            return "design";*/
        return "redirect:/orders/current";
    }
}