package problem.factories;

import edu.rosehulman.csse374.wired.annotations.Factory;
import edu.rosehulman.csse374.wired.core.AbstractFactory;
import problem.components.Label;
import problem.components.TextBox;
import problem.components.Window;
import problem.renderers.LinuxLabelRenderer;
import problem.renderers.LinuxTextBoxRenderer;
import problem.renderers.LinuxWindowRenderer;
import problem.renderers.WindowsLabelRenderer;
import problem.renderers.WindowsTextBoxRenderer;
import problem.renderers.WindowsWindowRenderer;

@Factory(provides={WindowsLabelRenderer.class, WindowsTextBoxRenderer.class, WindowsWindowRenderer.class})
public class WindowsRendererFactory extends AbstractFactory  {

	public WindowsRendererFactory() {
		super();
		this.map("Window", WindowsWindowRenderer.class);
		this.map("Label", WindowsLabelRenderer.class);
		this.map("TextBox", WindowsTextBoxRenderer.class);
	}

}
