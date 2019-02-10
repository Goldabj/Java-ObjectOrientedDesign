package problem;

import java.util.HashMap;
import java.util.Map;

import headfirst.factory.pizzaaf.Cheese;
import headfirst.factory.pizzaaf.Clams;
import headfirst.factory.pizzaaf.Dough;
import headfirst.factory.pizzaaf.Pepperoni;
import headfirst.factory.pizzaaf.PizzaIngredientFactory;
import headfirst.factory.pizzaaf.Sauce;
import headfirst.factory.pizzaaf.Veggies;
import printCommands.VeggieCommand;

public abstract class CommandIngredientFactoryDecorator implements PizzaIngredientFactory {
	
	PizzaIngredientFactory underlying;
	@SuppressWarnings("rawtypes")
	Map<Class, PizzaPrepCommand> ingredientsToCommands;
	
	public CommandIngredientFactoryDecorator(PizzaIngredientFactory fact) {
		this.underlying = fact;
		this.ingredientsToCommands = new HashMap<>();
		populateCommands();
	}

	@Override
	public Dough createDough() {
		Dough d = this.underlying.createDough();
		PizzaPrepCommand<Dough> doughCommand = this.ingredientsToCommands.get(Dough.class);
		Dough prepedD = doughCommand.prepareIngredient(d);
		return prepedD;
	}

	@Override
	public Sauce createSauce() {
		Sauce s = this.underlying.createSauce();
		PizzaPrepCommand<Sauce> sCommand = this.ingredientsToCommands.get(Sauce.class);
		Sauce prepedS = sCommand.prepareIngredient(s);
		return prepedS;
	}

	@Override
	public Cheese createCheese() {
		Cheese c = this.underlying.createCheese();
		PizzaPrepCommand<Cheese> cCommand = this.ingredientsToCommands.get(Cheese.class);
		Cheese prepedC = cCommand.prepareIngredient(c);
		return prepedC;
	}

	@Override
	public Veggies[] createVeggies() {
		Veggies[] v = this.underlying.createVeggies();
		PizzaPrepCommand<Veggies[]> vCommand = this.ingredientsToCommands.get(Veggies.class);
		Veggies[] prepedV = vCommand.prepareIngredient(v);
		return prepedV;
	}

	@Override
	public Pepperoni createPepperoni() {
		Pepperoni p = this.underlying.createPepperoni();
		PizzaPrepCommand<Pepperoni> pCommand = this.ingredientsToCommands.get(Pepperoni.class);
		Pepperoni prepedP = pCommand.prepareIngredient(p);
		return prepedP;
	}

	@Override
	public Clams createClam() {
		Clams c = this.underlying.createClam();
		PizzaPrepCommand<Clams> cCommand = this.ingredientsToCommands.get(Clams.class);
		Clams prepedC = cCommand.prepareIngredient(c);
		return prepedC;
	}
	
	public void setVeggieCommand(VeggieCommand<Veggies[]> veggieCommand) {
		this.ingredientsToCommands.put(Veggies.class, veggieCommand);
	}
	
	public void setCheeseCommand(PizzaPrepCommand<Cheese> command) {
		this.ingredientsToCommands.put(Cheese.class, command);
	}
	
	public void setDoughCommand(PizzaPrepCommand<Dough> command) {
		this.ingredientsToCommands.put(Dough.class, command);
	}
	
	public void setSauceCommand(PizzaPrepCommand<Sauce> command) {
		this.ingredientsToCommands.put(Sauce.class, command);
	}
	
	public void setPepperoniCommand(PizzaPrepCommand<Pepperoni> command) {
		this.ingredientsToCommands.put(Pepperoni.class, command);
	}
	
	public void setClamsCommand(PizzaPrepCommand<Clams> command) {
		this.ingredientsToCommands.put(Clams.class, command);
	}
	
	public abstract void populateCommands();

}
