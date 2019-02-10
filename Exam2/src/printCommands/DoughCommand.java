package printCommands;

import problem.PizzaPrepCommand;

public class DoughCommand<Dough> implements PizzaPrepCommand<Dough> {

	@Override
	public Dough prepareIngredient(Dough ingredient) {
		System.out.println("ROBO: preparing Dough");
		return ingredient;
	}

}
