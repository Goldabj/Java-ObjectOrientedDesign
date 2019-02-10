package problem;

public interface PizzaPrepCommand<T> {
	
	public T prepareIngredient(T ingredient);

}
