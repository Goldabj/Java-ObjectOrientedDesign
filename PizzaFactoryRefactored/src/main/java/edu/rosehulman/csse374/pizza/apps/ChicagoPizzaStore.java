package edu.rosehulman.csse374.pizza.apps;

import edu.rosehulman.csse374.pizza.factories.ChicagoPizzaIngredientFactory;
import edu.rosehulman.csse374.pizza.factories.PizzaIngredientFactory;
import edu.rosehulman.csse374.pizza.pizzas.CheesePizza;
import edu.rosehulman.csse374.pizza.pizzas.ClamPizza;
import edu.rosehulman.csse374.pizza.pizzas.PepperoniPizza;
import edu.rosehulman.csse374.pizza.pizzas.Pizza;
import edu.rosehulman.csse374.pizza.pizzas.VeggiePizza;

public class ChicagoPizzaStore extends PizzaStore {

	protected Pizza createPizza(String item) {
		Pizza pizza = null;
		PizzaIngredientFactory ingredientFactory =
		new ChicagoPizzaIngredientFactory();

		if (item.equals("cheese")) {

			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("Chicago Style Cheese Pizza");

		} else if (item.equals("veggie")) {

			pizza = new VeggiePizza(ingredientFactory);
			pizza.setName("Chicago Style Veggie Pizza");

		} else if (item.equals("clam")) {

			pizza = new ClamPizza(ingredientFactory);
			pizza.setName("Chicago Style Clam Pizza");

		} else if (item.equals("pepperoni")) {

			pizza = new PepperoniPizza(ingredientFactory);
			pizza.setName("Chicago Style Pepperoni Pizza");

		}
		return pizza;
	}
}
