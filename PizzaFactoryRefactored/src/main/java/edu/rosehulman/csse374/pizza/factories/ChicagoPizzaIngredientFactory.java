package edu.rosehulman.csse374.pizza.factories;

import edu.rosehulman.csse374.pizza.ingredients.BlackOlives;
import edu.rosehulman.csse374.pizza.ingredients.Cheese;
import edu.rosehulman.csse374.pizza.ingredients.Clams;
import edu.rosehulman.csse374.pizza.ingredients.Dough;
import edu.rosehulman.csse374.pizza.ingredients.Eggplant;
import edu.rosehulman.csse374.pizza.ingredients.FrozenClams;
import edu.rosehulman.csse374.pizza.ingredients.MozzarellaCheese;
import edu.rosehulman.csse374.pizza.ingredients.Pepperoni;
import edu.rosehulman.csse374.pizza.ingredients.PlumTomatoSauce;
import edu.rosehulman.csse374.pizza.ingredients.Sauce;
import edu.rosehulman.csse374.pizza.ingredients.SlicedPepperoni;
import edu.rosehulman.csse374.pizza.ingredients.Spinach;
import edu.rosehulman.csse374.pizza.ingredients.ThickCrustDough;
import edu.rosehulman.csse374.pizza.ingredients.Veggies;

public class ChicagoPizzaIngredientFactory 
	implements PizzaIngredientFactory 
{

	public Dough createDough() {
		return new ThickCrustDough();
	}

	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}

	public Cheese createCheese() {
		return new MozzarellaCheese();
	}

	public Veggies[] createVeggies() {
		Veggies veggies[] = { new BlackOlives(), 
		                      new Spinach(), 
		                      new Eggplant() };
		return veggies;
	}

	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FrozenClams();
	}
}
