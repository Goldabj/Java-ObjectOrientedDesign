package problem.factories;

import edu.rosehulman.csse374.wired.annotations.Factory;
import edu.rosehulman.csse374.wired.core.AbstractFactory;
import problem.components.Label;
import problem.components.TextBox;
import problem.components.Window;
import problem.renderers.LinuxLabelRenderer;
import problem.renderers.LinuxTextBoxRenderer;
import problem.renderers.LinuxWindowRenderer;

@Factory(provides={LinuxLabelRenderer.class, LinuxTextBoxRenderer.class, LinuxWindowRenderer.class})
public class LinuxRendererFactory extends AbstractRendererFactory {

	public LinuxRendererFactory() {
		super();
		this.map("Window", LinuxWindowRenderer.class);
		this.map("Label", LinuxLabelRenderer.class);
		this.map("TextBox", LinuxTextBoxRenderer.class);
	}


}
