package problem;

import osxRenderers.OSXLabelRenderer;
import osxRenderers.OSXTextBoxRenderer;
import osxRenderers.OSXWindowRenderer;

public class OSXRendererFactory extends AbstractRendererFactory {

	public OSXRendererFactory() {
		populate();
	}

	@Override
	protected void populate() {

		this.addRenderer(Window.class, OSXWindowRenderer.class);
		this.addRenderer(TextBox.class, OSXTextBoxRenderer.class);
		this.addRenderer(Label.class, OSXLabelRenderer.class);

	}

}
