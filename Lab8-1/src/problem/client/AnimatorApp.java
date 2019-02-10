package problem.client;

import problem.graphics.MainWindow;
import problem.sprites.CircleSprite;
import problem.sprites.FanSprite;
import problem.sprites.RectangleSprite;
import problem.sprites.SpriteFactory;
import problem.sprites.SuperFanSprite;

public class AnimatorApp {

	public static void main(String[] args) {
		SpriteFactory factory = SpriteFactory.getInstance();

		factory.load(RectangleSprite.class, CircleSprite.class, FanSprite.class, SuperFanSprite.class);
		
		MainWindow mainWindow = new MainWindow("Animator Application Window", 50);		
		mainWindow.show();
	}
}
