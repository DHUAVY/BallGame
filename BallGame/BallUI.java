package BallGame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class BallUI extends JFrame{

	ArrayList<Ball> balls = new ArrayList<Ball> ();
	DrawThread drawThread;
	public  BallUI(){
		setTitle ("Ball Game");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// 初始化线程 并启动
		drawThread = new DrawThread (this);
		drawThread.start ();

		// 分段处理
		DrawThread drawThread = new DrawThread (this);
		drawThread.start ();

		GameListener gameListener = new GameListener (balls);
		addMouseListener (gameListener);

//		CollisionThread collisionThread = new CollisionThread (balls);
//		collisionThread.start ();

		MoveThread moveThread = new MoveThread (balls);
		moveThread.start ();

	}

	public static void main(String[] args){
		new BallUI ();
	}



}
