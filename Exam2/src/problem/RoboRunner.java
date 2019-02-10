package problem;

import headfirst.factory.pizzaaf.ChicagoPizzaIngredientFactory;
import headfirst.factory.pizzaaf.ChicagoPizzaStore;
import headfirst.factory.pizzaaf.NYPizzaIngredientFactory;
import headfirst.factory.pizzaaf.NYPizzaStore;
import headfirst.factory.pizzaaf.Pizza;
import headfirst.factory.pizzaaf.PizzaStore;

public class RoboRunner {

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
