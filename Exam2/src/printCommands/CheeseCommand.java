package printCommands;

import problem.PizzaPrepCommand;

public class CheeseCommand<Cheese> implements PizzaPrepCommand<Cheese> {

	@Override
	public Cheese prepareIngredient(Cheese ingredient) {
		System.out.println("ROBO: preparing Cheese");
		return ingredient;
	}

}
