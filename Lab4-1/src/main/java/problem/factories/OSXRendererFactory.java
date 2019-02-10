package problem.factories;

import edu.rosehulman.csse374.wired.annotations.Factory;
import edu.rosehulman.csse374.wired.core.AbstractFactory;
import problem.components.Label;
import problem.components.TextBox;
import problem.components.Window;
import problem.renderers.LinuxLabelRenderer;
import problem.renderers.LinuxTextBoxRenderer;
import problem.renderers.LinuxWindowRenderer;
import problem.renderers.OSXLabelRenderer;
import problem.renderers.OSXTextBoxRenderer;
import problem.renderers.OSXWindowRenderer;

@Factory(provides={OSXLabelRenderer.class, OSXTextBoxRenderer.class, OSXWindowRenderer.class})
public class OSXRendererFactory extends AbstractFactory {

	public OSXRendererFactory() {
		super();
		this.map("Window", OSXWindowRenderer.class);
		this.map("Label", OSXLabelRenderer.class);
		this.map("TextBox", OSXTextBoxRenderer.class);
	}

}
