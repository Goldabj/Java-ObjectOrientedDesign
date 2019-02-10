package edu.rosehulman.csse374.pizza.factories;

import edu.rosehulman.csse374.pizza.ingredients.BlackOlives;
import edu.rosehulman.csse374.pizza.ingredients.Eggplant;
import edu.rosehulman.csse374.pizza.ingredients.FrozenClams;
import edu.rosehulman.csse374.pizza.ingredients.MozzarellaCheese;
import edu.rosehulman.csse374.pizza.ingredients.PlumTomatoSauce;
import edu.rosehulman.csse374.pizza.ingredients.SlicedPepperoni;
import edu.rosehulman.csse374.pizza.ingredients.Spinach;
import edu.rosehulman.csse374.pizza.ingredients.ThickCrustDough;
import edu.rosehulman.csse374.pizza.ingredients.Veggies;
import edu.rosehulman.csse374.wired.annotations.Factory;

@Factory(provides = {
		ThickCrustDough.class,
		PlumTomatoSauce.class,
		MozzarellaCheese.class,
		SlicedPepperoni.class,
		FrozenClams.class
})
public class ChicagoPizzaFactory extends AbstractPizzaFactory {

	public ChicagoPizzaFactory() {
		// We have mapped pizza types using selector in AbstractPizzaFactory
		// See its constructor
		super();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected <T> T createSpecial(Class<T> clazz, String selector) throws Exception {
		if(Veggies[].class.isAssignableFrom(clazz)) {
			Veggies veggies[] = { new BlackOlives(), new Spinach(), new Eggplant() };
			return (T)veggies;
		}
		
		return null;
	}
}
