package test;
import java.util.ArrayList;
import java.util.List;

import PatternParser.AbstractPatternDetector;
import PatternParser.BadInheritancePattern;
import umlentities.IUMLDependency;
import umlentities.IUMLNode;

public class BidirectionalArrowDetector extends AbstractPatternDetector{

	@Override
	public void detectPattern() {
		List<IUMLNode> newPatterns = new ArrayList<>();
		
		for (IUMLNode node : this.getNodes()){
			List<IUMLDependency> deps = node.getDependencies();
			for(int i = 0; i < deps.size(); i++){
				IUMLDependency singleDep = deps.get(i);
				if(singleDep.getIsBiDirectional()){
					
					IUMLDependency pattern = new BidirectionalPattern(singleDep);
					node.removeDependency(singleDep);
					node.addDependency(pattern);
					break;
				}
			}
		}
		
	}

}
