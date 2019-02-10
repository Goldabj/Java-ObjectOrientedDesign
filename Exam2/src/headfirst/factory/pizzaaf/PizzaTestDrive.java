package headfirst.factory.pizzaaf;

import problem.PrintDecorator;

public class PizzaTestDrive {
 
	public static void main(String[] args) {
		
		NYPizzaIngredientFactory nyFact = new NYPizzaIngredientFactory();
		ChicagoPizzaIngredientFactory cFact = new ChicagoPizzaIngredientFactory();
		PrintDecorator nyDecorator = new PrintDecorator(nyFact);
		PrintDecorator cDecorator = new PrintDecorator(cFact);
		
		
		PizzaStore nyStore = new NYPizzaStore(nyDecorator);
		PizzaStore chicagoStore = new ChicagoPizzaStore(cDecorator);
 
		Pizza pizza = nyStore.orderPizza("cheese");
		System.out.println("Ethan ordered a " + pizza + "\n");
 
		pizza = chicagoStore.orderPizza("cheese");
		System.out.println("Joel ordered a " + pizza + "\n");

		pizza = nyStore.orderPizza("clam");
		System.out.println("Ethan ordered a " + pizza + "\n");
 
		pizza = chicagoStore.orderPizza("clam");
		System.out.println("Joel ordered a " + pizza + "\n");

		pizza = nyStore.orderPizza("pepperoni");
		System.out.println("Ethan ordered a " + pizza + "\n");
 
		pizza = chicagoStore.orderPizza("pepperoni");
		System.out.println("Joel ordered a " + pizza + "\n");

		pizza = nyStore.orderPizza("veggie");
		System.out.println("Ethan ordered a " + pizza + "\n");
 
		pizza = chicagoStore.orderPizza("veggie");
		System.out.println("Joel ordered a " + pizza + "\n");
	}
}
