package ols2405.tacocloud;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

import ols2405.tacocloud.Ingredients.Type;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {
    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredients> ingredients = Arrays.asList(
                new Ingredients("FLTO", "Flour Tortilia", Type.WRAP),
                new Ingredients("COTO", "Corn Tortilia", Type.WRAP),
                new Ingredients("GRBF", "Ground", Type.PROTEIN),
                new Ingredients("CARN", "Carnitas", Type.PROTEIN),
                new Ingredients("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new Ingredients("LETC", "Lettuce", Type.VEGGIES),
                new Ingredients("CHED", "Cheddar", Type.CHEESE),
                new Ingredients("JACK", "Monterrey Jack", Type.CHEESE),
                new Ingredients("SLSA", "Salsa", Type.SAUCE),
                new Ingredients("SRCR", "Sour Cream", Type.SAUCE));

        Type[] types = Ingredients.Type.values();

        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
        return "design";
    }

    private List<Ingredients> filterByType(List<Ingredients> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
