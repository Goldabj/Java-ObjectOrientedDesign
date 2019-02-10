package test;
import PatternParser.AbstractPatternDetector;
import PatternParser.BadInheritanceDependencyPattern;
import graphvizcreator.AbstractPatternDrawer;
import umlentities.IDrawer;

public class BidirectionalDrawer extends AbstractPatternDrawer{

	public BidirectionalDrawer(IDrawer drawer) {
		super(drawer);
	}
	
	@Override
	public String draw(){
		
		String superString = super.draw();
		
		BidirectionalPattern depPat = (BidirectionalPattern) this.getEntity();
		
		String[] attributes = superString.split("\\[");
		String atts = attributes[1];
		
		atts = "[ color=" + depPat.getArrowColor() + ", " + atts;
		
		for(int i = 2; i < attributes.length; i++ ) {
			atts += "[ " + attributes[1] + " ";
		}
		
		String finalString = attributes[0] + " " + atts;
		
		return finalString;
	}

	

}
