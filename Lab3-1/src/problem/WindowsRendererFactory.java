package problem;

import windowsRenderers.WindowsLabelRenderer;
import windowsRenderers.WindowsTextBoxRenderer;
import windowsRenderers.WindowsWindowRenderer;

public class WindowsRendererFactory extends AbstractRendererFactory {

	public WindowsRendererFactory() {
		populate();
	}

	@Override
	protected void populate() {
		this.addRenderer(Window.class, WindowsWindowRenderer.class);
		this.addRenderer(TextBox.class, WindowsTextBoxRenderer.class);
		this.addRenderer(Label.class, WindowsLabelRenderer.class);

	}

}
