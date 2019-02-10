package test;
import PatternParser.AbstractPatternNode;
import PatternParser.UMLDependencyDecorator;
import umlentities.IUMLDependency;
import umlentities.IUMLNode;

public class BidirectionalPattern extends UMLDependencyDecorator{
	
	private String arrowColor;
	public static final String TYPE = "BidirectionalArrowPattern";

	public BidirectionalPattern(IUMLDependency dep) {
		super(dep);
		this.arrowColor = "red";
	}
	
	public BidirectionalPattern() {
		// for classLoader
	}

	@Override
	public String getType() {
		return TYPE;
	}
	
	public String getArrowColor() {
		return this.arrowColor;
	}

}
