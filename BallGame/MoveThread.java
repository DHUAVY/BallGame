package BallGame;

import java.util.ArrayList;

public class MoveThread extends Thread{
	ArrayList<Ball> balls;
	public MoveThread(ArrayList<Ball> balls){
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
				ball.moveBall ();
				ball.isCollision(balls);
			}
		}
	}
}
