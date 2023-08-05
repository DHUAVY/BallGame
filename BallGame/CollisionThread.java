package BallGame;
import java.util.ArrayList;

public class CollisionThread extends Thread{

	ArrayList<Ball> balls;

	public CollisionThread(ArrayList<Ball> balls){
		this.balls = balls;
	}

	@Override
	public void run(){
		while(true){
			try {
				Thread.sleep (30);
			} catch (InterruptedException e) {
				throw new RuntimeException (e);
			}
			for(int i = 0; i < balls.size (); i++){
				Ball ball = balls.get (i);
				ball.isCollision (balls);
			}
		}
	}
}
