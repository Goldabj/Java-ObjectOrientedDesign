package printCommands;

import problem.PizzaPrepCommand;

public class ClamCommand<Clams> implements PizzaPrepCommand<Clams> {

	@Override
	public Clams prepareIngredient(Clams ingredient) {
		System.out.println("ROBO: preparing clams");
		return ingredient;
	}

}
