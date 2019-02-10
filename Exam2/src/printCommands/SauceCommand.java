package printCommands;

import problem.PizzaPrepCommand;

public class SauceCommand<Sauce> implements PizzaPrepCommand<Sauce> {

	@Override
	public Sauce prepareIngredient(Sauce ingredient) {
		System.out.println("ROBO: preparing sauce");
		return ingredient;
	}

}
