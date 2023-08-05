package BallGame;
import java.awt.*;
import java.util.ArrayList;

public class Ball{
	private int x;
	private int y;
	private double speedx;
	private double speedy;
	private int size;	// 直径
	private Color color;

	public static Color[] colorList = {Color.GREEN, Color.ORANGE, Color.BLACK, Color.CYAN, Color.RED};

	private boolean isLive;

	public Ball(int x, int y, double speedx, double speedy, int size, Color color){
		this.x = x;
		this.y = y;
		this.speedx = speedx;
		this.speedy = speedy;
		this.size = size;
		this.color = color;
	}

	public int getX(){
		return x;
	}

	public void setX(int x){
		this.x = x;
	}

	public int getY(){
		return y;
	}

	public void setY(int y){
		this.y = y;
	}

	public double getSpeedx(){
		return speedx;
	}

	public void setSpeedx(double speedx){
		this.speedx = speedx;
	}

	public double getSpeedy(){
		return speedy;
	}

	public void setSpeedy(double speedy){
		this.speedy = speedy;
	}

	public int getSize(){
		return size;
	}

	public void setSize(int size){
		this.size = size;
	}

	public Color getColor(){
		return color;
	}

	public void setColor(Color color){
		this.color = color;
	}

	public boolean isLive(){
		return isLive;
	}

	public void setLive(boolean live){
		isLive = live;
	}

	// 功能方法
	public void moveBall(){
		if(x <= 0 || x >= 800 - size){
			speedx = -speedx;
		}
		if(y <= 0 || y >= 600 - size){
			speedy = -speedy;
		}
		x += speedx;
		y += speedy;
	}

	public void drawBall(Graphics g){
		g.setColor (color);
		g.fillOval (x, y, size, size);
	}

	// 碰撞方法
	public void isCollision(ArrayList<Ball> balls){
		for(int i = 0; i < balls.size (); i++){
			Ball ball = balls.get (i);
			if(ball == this){
				continue;
			}
			double distance = Math.sqrt (Math.pow (ball.getX () - x, 2) + Math.pow (ball.getY () - y, 2));
			if(distance <= ((double)size + (double)ball.getSize ())/2 && ball.color != this.color ){
				if(size >= ball.getSize()){
					size += ball.getSize() / 2 + 1;
					balls.remove(ball);
				}
				else{
					ball.size += size / 2 + 1;
					balls.remove(this);
				}
			}
		}
	}
}
