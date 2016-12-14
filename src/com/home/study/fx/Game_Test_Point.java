package com.home.study.fx;

import javafx.scene.paint.Paint;

public class Game_Test_Point {

	private int x;
	private int y;
	private Paint paint;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setColor(Paint c) {
		this.paint = c;
	}
	public Paint getColor() {
		return paint;
	}
	
	/*
	public void move(int y, int x){
		this.y = this.y + y;
		this.x = this.x + x;
	}
	*/
	
}
