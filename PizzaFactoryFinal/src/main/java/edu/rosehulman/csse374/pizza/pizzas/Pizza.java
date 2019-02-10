package edu.rosehulman.csse374.pizza.pizzas;

import edu.rosehulman.csse374.pizza.ingredients.Cheese;
import edu.rosehulman.csse374.pizza.ingredients.Dough;
import edu.rosehulman.csse374.pizza.ingredients.Sauce;
import edu.rosehulman.csse374.wired.annotations.Autowired;

public abstract class Pizza {
	String name;

	@Autowired Dough dough;
	@Autowired Sauce sauce;
	@Autowired Cheese cheese;

	// Some of the fields have been moved to subclasses

	// Changed from abstract to provide default implementation.
	// Pizzas are prepared by factories through dependency injection
	public void prepare() {
		System.out.println("Preparing " + name);
	}

	public void bake() {
		System.out.println("Bake for 25 minutes at 350");
	}

	public void cut() {
		System.out.println("Cutting the pizza into diagonal slices");
	}

	public void box() {
		System.out.println("Place pizza in official PizzaStore box");
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("---- " + name + " ----\n");
		if (dough != null) {
			result.append(dough);
			result.append("\n");
		}
		if (sauce != null) {
			result.append(sauce);
			result.append("\n");
		}
		if (cheese != null) {
			result.append(cheese);
			result.append("\n");
		}
		return result.toString();
	}
}
