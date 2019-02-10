package problem.factories;

import edu.rosehulman.csse374.wired.annotations.Autowired;
import edu.rosehulman.csse374.wired.core.AbstractFactory;

public class RendererMetaFactory extends AbstractFactory {

	public RendererMetaFactory() {
		super();
		this.map("windows", WindowsRendererFactory.class);
		this.map("linux", LinuxRendererFactory.class);
		this.map("osx", OSXRendererFactory.class);
	}

}
