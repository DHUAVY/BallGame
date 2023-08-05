package BallGame;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class GameListener extends MouseAdapter{
	ArrayList<Ball> balls;

	public GameListener(ArrayList<Ball> balls){
		this.balls = balls;
	}

	Random random = new Random ();

	@Override
	public void mousePressed(MouseEvent e){
		for(int i = 0; i < 2; i++){
			int x = e.getX ()+random.nextInt (500) - 200;
			int y = e.getY ()+random.nextInt (500) - 300;

			double speedx = random.nextDouble () * 3 + 1;
			double speedy = random.nextDouble () * 3 + 1;
			if(random.nextInt(2) == 0){
				speedx = -speedx;
				speedy = -speedy;
			}

			int size = random.nextInt (50) + 10;

			int randomIndex = random.nextInt(Ball.colorList.length);
			Color color = Ball.colorList[randomIndex];

			Ball ball = new Ball (x, y, speedx, speedy, size, color);
			balls.add (ball);
		}
	}
}
