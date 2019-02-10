package printCommands;

import headfirst.factory.pizzaaf.BlackOlives;
import headfirst.factory.pizzaaf.Eggplant;
import headfirst.factory.pizzaaf.Spinach;
import headfirst.factory.pizzaaf.Veggies;
import problem.PizzaPrepCommand;

public class VeggieCommand<T> implements PizzaPrepCommand<T[]> {

	@Override
	public T[] prepareIngredient(T[] ingredient) {
		System.out.println("ROBO: preparing Veggies");
		return ingredient;
	}

}
