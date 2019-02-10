package problem;

import linuxRenderers.LinuxTextBoxRenderer;
import linuxRenderers.LinuxLabelRenderer;
import linuxRenderers.LinuxWindowRenderer;

public class LinuxRendererFactory extends AbstractRendererFactory {

	public LinuxRendererFactory() {
		populate();
	}

	@Override
	protected void populate() {
		this.addRenderer(Window.class, LinuxWindowRenderer.class);
		this.addRenderer(TextBox.class, LinuxTextBoxRenderer.class);
		this.addRenderer(Label.class, LinuxLabelRenderer.class);

	}

}
