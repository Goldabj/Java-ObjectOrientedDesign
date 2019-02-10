package problem;

import headfirst.factory.pizzaaf.Cheese;
import headfirst.factory.pizzaaf.Clams;
import headfirst.factory.pizzaaf.Dough;
import headfirst.factory.pizzaaf.Pepperoni;
import headfirst.factory.pizzaaf.PizzaIngredientFactory;
import headfirst.factory.pizzaaf.Sauce;
import headfirst.factory.pizzaaf.Veggies;
import printCommands.CheeseCommand;
import printCommands.ClamCommand;
import printCommands.DoughCommand;
import printCommands.PepperoniCommand;
import printCommands.SauceCommand;
import printCommands.VeggieCommand;

public class PrintDecorator extends CommandIngredientFactoryDecorator {

	public PrintDecorator(PizzaIngredientFactory fact) {
		super(fact);
	}

	@Override
	public void populateCommands() {
		this.setCheeseCommand(new CheeseCommand<Cheese>());
		this.setClamsCommand(new ClamCommand<Clams>());
		this.setDoughCommand(new DoughCommand<Dough>());
		this.setPepperoniCommand(new PepperoniCommand<Pepperoni>());
		this.setSauceCommand(new SauceCommand<Sauce>());
		this.setVeggieCommand(new VeggieCommand<Veggies[]>());

	}

}
