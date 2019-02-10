package problem.graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.StreamSupport;

import javax.swing.JPanel;

import com.sun.xml.internal.txw2.output.StreamSerializer;

import problem.sprites.AbstractSprite;
import problem.sprites.ISprite;
import problem.sprites.ISpriteIterator;
import problem.sprites.SpriteFactory;

public class AnimationPanel extends JPanel {
	private static final long serialVersionUID = -9141525646098105526L;
	
	private List<ISprite> sprites;
	private volatile boolean animating;
	private long sleepTime;
	private SpriteFactory factory;

	public AnimationPanel(long sleepTime) {
		super(true);
		animating = false;
		sprites = Collections.synchronizedList(new ArrayList<ISprite>());
		this.sleepTime = sleepTime;
		this.factory = SpriteFactory.getInstance();
	}
	
	public void add(ISprite s) {
		sprites.add(s);
		this.repaint();
	}	
	
	@Override
	public Dimension getSize() {
		Dimension d = super.getSize();
		d.width -= factory.getWidth();
		d.height -= factory.getHeight();
		return d;
	}
	
	public void animate() {
		if(animating)
			return;
		
		animating = true;
		
		Thread animator = new Thread() {
			@Override
			public void run() {
				while(animating) {
					long start = System.currentTimeMillis();

					synchronized(sprites) {
						for(ISprite s: sprites) {
							s.move(getSize());
						}
					}
					repaint();

					long end = System.currentTimeMillis();
					long delta = sleepTime - (end - start);
					delta = (delta > 0)? delta : 0;
					
					try {
						Thread.sleep(delta);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		animator.start();
	}
	
	public void reset() {
		animating = false;
		sprites.clear();
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);		
		
		Graphics2D graphics = (Graphics2D)g;
		synchronized(sprites) {
			Iterator<ISprite> iter = new ISpriteIterator(this.sprites.iterator());
			while (iter.hasNext()) {
				ISprite s = iter.next();
				if (s instanceof AbstractSprite) {
					Shape sh = ((AbstractSprite) s).getShape();
					graphics.draw(sh);
				}
			}
			
		}
	}
	
//	@Override
//	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		
//		Graphics2D g2 = (Graphics2D) g;
//		synchronized(sprites) {
//			Spliterator sIter = Spliterators.spliteratorUnknownSize(new ISpriteIterator(this.sprites.iterator()), 0);
//			java.util.stream.Stream<ISprite> stream = StreamSupport.stream(sIter, true);
//			stream.filter(s -> s instanceof AbstractSprite).map(ISprite::getShape).forEach(shape -> g2.draw(shape));
//		}
//	}
}
