package BallGame;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class DrawThread extends Thread{
	ArrayList<Ball> balls;
	Graphics g;

	public DrawThread(BallUI ui){
		balls = ui.balls;
		g = ui.getGraphics ();
		tNum++;
	}

	// 分段处理
	int tid;
	static int tNum;

	public void setTid(int tid){
		this.tid = tid;
	}


	@Override
	public void run(){
		while(true){
			try {
				Thread.sleep (30);
			} catch (InterruptedException e) {
				throw new RuntimeException (e);
			}
			BufferedImage image = new BufferedImage (800, 600, BufferedImage.TYPE_INT_RGB);
			Graphics bg = image.getGraphics ();
			bg.setColor (Color.WHITE);
			bg.fillRect (0, 0, 800, 600);
			for(int i = 0; i < balls.size (); i++){
				Ball ball = balls.get (i);
				ball.drawBall (bg);
			}
			g.drawImage (image, 0, 0, null);
		}

	}
}
