package edu.rosehulman.csse374.pizza.factories;

import edu.rosehulman.csse374.pizza.ingredients.Cheese;
import edu.rosehulman.csse374.pizza.ingredients.Clams;
import edu.rosehulman.csse374.pizza.ingredients.Dough;
import edu.rosehulman.csse374.pizza.ingredients.Pepperoni;
import edu.rosehulman.csse374.pizza.ingredients.Sauce;
import edu.rosehulman.csse374.pizza.ingredients.Veggies;

public interface PizzaIngredientFactory {
 
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Veggies[] createVeggies();
	public Pepperoni createPepperoni();
	public Clams createClam();
 
}
