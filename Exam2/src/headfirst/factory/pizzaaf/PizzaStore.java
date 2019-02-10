package headfirst.factory.pizzaaf;

public abstract class PizzaStore {
	
	PizzaIngredientFactory factory;
	
	public PizzaStore(PizzaIngredientFactory fact) {
		this.factory = fact;
	}
	
	public PizzaIngredientFactory getFactory() {
		return this.factory;
	}
 
	protected abstract Pizza createPizza(String item);
 
	public Pizza orderPizza(String type) {
		Pizza pizza = createPizza(type);
		System.out.println("--- Making a " + pizza.getName() + " ---");
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}
