package printCommands;

import problem.PizzaPrepCommand;

public class PepperoniCommand<Pepperoni> implements PizzaPrepCommand<Pepperoni> {

	@Override
	public Pepperoni prepareIngredient(Pepperoni ingredient) {
		System.out.println("ROBO: preparing pepperoni");
		return ingredient;
	}

}
