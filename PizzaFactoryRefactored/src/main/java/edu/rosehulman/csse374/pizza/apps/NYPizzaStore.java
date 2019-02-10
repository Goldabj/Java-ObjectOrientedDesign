package edu.rosehulman.csse374.pizza.apps;

import edu.rosehulman.csse374.pizza.factories.NYPizzaIngredientFactory;
import edu.rosehulman.csse374.pizza.factories.PizzaIngredientFactory;
import edu.rosehulman.csse374.pizza.pizzas.CheesePizza;
import edu.rosehulman.csse374.pizza.pizzas.ClamPizza;
import edu.rosehulman.csse374.pizza.pizzas.PepperoniPizza;
import edu.rosehulman.csse374.pizza.pizzas.Pizza;
import edu.rosehulman.csse374.pizza.pizzas.VeggiePizza;

public class NYPizzaStore extends PizzaStore {
 
	protected Pizza createPizza(String item) {
		Pizza pizza = null;
		PizzaIngredientFactory ingredientFactory = 
			new NYPizzaIngredientFactory();
 
		if (item.equals("cheese")) {
  
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("New York Style Cheese Pizza");
  
		} else if (item.equals("veggie")) {
 
			pizza = new VeggiePizza(ingredientFactory);
			pizza.setName("New York Style Veggie Pizza");
 
		} else if (item.equals("clam")) {
 
			pizza = new ClamPizza(ingredientFactory);
			pizza.setName("New York Style Clam Pizza");
 
		} else if (item.equals("pepperoni")) {

			pizza = new PepperoniPizza(ingredientFactory);
			pizza.setName("New York Style Pepperoni Pizza");
 
		} 
		return pizza;
	}
}
