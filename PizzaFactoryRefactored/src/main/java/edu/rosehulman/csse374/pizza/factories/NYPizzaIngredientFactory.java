package edu.rosehulman.csse374.pizza.factories;

import edu.rosehulman.csse374.pizza.ingredients.Cheese;
import edu.rosehulman.csse374.pizza.ingredients.Clams;
import edu.rosehulman.csse374.pizza.ingredients.Dough;
import edu.rosehulman.csse374.pizza.ingredients.FreshClams;
import edu.rosehulman.csse374.pizza.ingredients.Garlic;
import edu.rosehulman.csse374.pizza.ingredients.MarinaraSauce;
import edu.rosehulman.csse374.pizza.ingredients.Mushroom;
import edu.rosehulman.csse374.pizza.ingredients.Onion;
import edu.rosehulman.csse374.pizza.ingredients.Pepperoni;
import edu.rosehulman.csse374.pizza.ingredients.RedPepper;
import edu.rosehulman.csse374.pizza.ingredients.ReggianoCheese;
import edu.rosehulman.csse374.pizza.ingredients.Sauce;
import edu.rosehulman.csse374.pizza.ingredients.SlicedPepperoni;
import edu.rosehulman.csse374.pizza.ingredients.ThinCrustDough;
import edu.rosehulman.csse374.pizza.ingredients.Veggies;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
 
	public Dough createDough() {
		return new ThinCrustDough();
	}
 
	public Sauce createSauce() {
		return new MarinaraSauce();
	}
 
	public Cheese createCheese() {
		return new ReggianoCheese();
	}
 
	public Veggies[] createVeggies() {
		Veggies veggies[] = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
		return veggies;
	}
 
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FreshClams();
	}
}
