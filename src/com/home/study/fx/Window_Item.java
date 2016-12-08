package com.home.study.fx;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

class Block {
	
	private int x;
	private int y;
	
	public Block(){
		
	}
	
	public Block(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void move(int xPlus, int yPlus) {
		this.x += xPlus;
		this.y += yPlus;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public Block getBlock() {
		return this;
	}
	
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}

public class Window_Item {
	
	JPanel[] panel;
	Block[] block;
	Block[][] block_info;
	Block currentXY;
	
	int cnt;
	int angle;
	int current_angle;
	int xCnt;
	
	Color color = Color.blue;
	int area;
	
	public Window_Item(int area, int angle, int cnt, int xCnt) {
		this.angle = angle;
		this.cnt = cnt;
		this.panel = new JPanel[cnt];
		this.block = new Block[cnt];
		this.block_info = new Block[angle][cnt];
		this.area = area;
		this.currentXY = new Block(0,0);
		this.xCnt = xCnt;
		
		for (int i = 0; i < cnt; i++) {
			this.panel[i] = new JPanel();
		}
	}
	
	public void setDefaultRandom() {
		this.current_angle = (int)(Math.random()*0);
		this.block = this.block_info[this.current_angle];
	}
	
	public void setItem(Container c) {
		for (int i = 0; i < panel.length; i++) {
			panel[i].setBackground(this.color);
			panel[i].setSize(area, area);
			panel[i].setLocation(((block[i].getX()) * area)-100, ((block[i].getY()) * area)-100);
			panel[i].setBorder(new SoftBevelBorder(BevelBorder.RAISED));
			c.add(panel[i]);
		}
	}
	
	public void setNextLocation() {
		for (int i = 0; i < panel.length; i++) {
			int x = block[i].getX() + 18;
			int y = block[i].getY() + 2;
			panel[i].setLocation(x * area, y * area);
		}
		this.currentXY.setXY((xCnt/2-1), 1);
	}
	
	public void setDefaultLocation() {
		for (int i = 0; i < panel.length; i++) {
			int x = block[i].getX() + (int)(xCnt/2-1);
			int y = block[i].getY() + 2;
			panel[i].setLocation(x * area, y * area);
		}
		this.currentXY.setXY((xCnt/2-1), 1);
	}
	
	public void setReadyLocation() {
		for (int i = 0; i < panel.length; i++) {
			panel[i].setLocation(((block[i].getX()) * area)-100, ((block[i].getY()) * area)-100);
		}
	}
	
	public void setCurruentXY(int x, int y) {
		this.currentXY.move(x, y);
	}
	
	public Block getCurrentXY() {
		return this.currentXY;
	}
	
	public Block[] getBlock() {
		Block[] temp = new Block[cnt];
		for (int i = 0; i < block.length; i++) {
			int x = block[i].getX() + this.currentXY.getX();
			int y = block[i].getY()	+ this.currentXY.getY();
			temp[i] = new Block(x,y);
		}
		return temp;
	}
	
	public Block[] getNextBlock() {
		int nextAngle;
		if(this.angle == 1) return getBlock();
		else if(this.angle-1 == this.current_angle) nextAngle = 0;
		else nextAngle = this.current_angle + 1;
		
		Block[] temp = new Block[cnt];
		for (int i = 0; i < block.length; i++) {
			int x = block_info[nextAngle][i].getX() + this.currentXY.getX();
			int y = block_info[nextAngle][i].getY() + this.currentXY.getY();
			temp[i] = new Block(x, y);
		}
		return temp;
	}
	
	public int getCurrentAngle() {
		return this.current_angle;
	}
	
	public void moveRotate() {
		if(this.angle == 1) return;
		if(this.current_angle + 1 == this.angle) {
			this.block = this.block_info[0];
			this.current_angle = 0;
		} else {
			this.current_angle++;
			this.block = this.block_info[this.current_angle];
		}
		this.setMove();
	}
	
	public void setMove() {
		for (int i = 0; i < panel.length; i++) {
			int x = this.block[i].getX() + this.currentXY.getX();
			int y = this.block[i].getY() + this.currentXY.getY();
			panel[i].setLocation(x * area, y * area);
		}
	}
	
	public void moveDown() {
		this.currentXY.move(0, 1);
		this.setMove();
	}
	
	public void moveRight() {
		this.currentXY.move(1, 0);
		this.setMove();
	}
	
	public void moveLeft() {
		this.currentXY.move(-1, 0);
		this.setMove();
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public void setColor(Color c) {
		
		this.color = c;
		for (int i = 0; i < panel.length; i++) {
			panel[i].setBackground(this.color);
		}
	}
	
}

class Rect extends Window_Item {
	
	public Rect(int area, Container con, int xCnt) {
		super(area, 1, 4, xCnt);
		
		block_info[0][0] = new Block(0,0);
		block_info[0][1] = new Block(0,1);
		block_info[0][2] = new Block(1,0);
		block_info[0][3] = new Block(1,1);
		
		this.setDefaultRandom();
		this.setItem(con);
		
	}
	
}

class OneThree extends Window_Item
{
   public OneThree(int area, Container con, int xCnt){
      super(area, 4, 4, xCnt);

      block_info[0][0] = new Block(0,0); // 0,0
      block_info[0][1] = new Block(0,1); // 1,0
      block_info[0][2] = new Block(1,1); // 1,1
      block_info[0][3] = new Block(2,1); // 1,2

      block_info[1][0] = new Block(0,2);
      block_info[1][1] = new Block(1,2);
      block_info[1][2] = new Block(1,1);
      block_info[1][3] = new Block(1,0);

      block_info[2][0] = new Block(2,1);
      block_info[2][1] = new Block(2,0);
      block_info[2][2] = new Block(1,0);
      block_info[2][3] = new Block(0,0);

      block_info[3][0] = new Block(1,0);
      block_info[3][1] = new Block(0,0);
      block_info[3][2] = new Block(0,1);
      block_info[3][3] = new Block(0,2);

      this.setDefaultRandom();
      this.setItem(con);
   }
}

class ThreeOne extends Window_Item
{
   public ThreeOne(int area, Container con, int xCnt){
      super(area, 4, 4, xCnt);

      block_info[0][0] = new Block(0,1);
      block_info[0][1] = new Block(0,0);
      block_info[0][2] = new Block(1,0);
      block_info[0][3] = new Block(2,0);

      block_info[1][0] = new Block(1,2);
      block_info[1][1] = new Block(0,2);
      block_info[1][2] = new Block(0,1);
      block_info[1][3] = new Block(0,0);

      block_info[2][0] = new Block(2,0);
      block_info[2][1] = new Block(2,1);
      block_info[2][2] = new Block(1,1);
      block_info[2][3] = new Block(0,1);

      block_info[3][0] = new Block(0,0);
      block_info[3][1] = new Block(1,0);
      block_info[3][2] = new Block(1,1);
      block_info[3][3] = new Block(1,2);

      this.setDefaultRandom();
      this.setItem(con);
   }
}

//ÀÏÀÚ
class LineBlock extends Window_Item
{
   public LineBlock(int area, Container con, int xCnt){
      super(area, 2, 4, xCnt);

      block_info[0][0] = new Block(0,-1);
      block_info[0][1] = new Block(0,0);
      block_info[0][2] = new Block(0,1);
      block_info[0][3] = new Block(0,2);

      block_info[1][0] = new Block(-1,0);
      block_info[1][1] = new Block(0,0);
      block_info[1][2] = new Block(1,0);
      block_info[1][3] = new Block(2,0);

      this.setDefaultRandom();
      this.setItem(con);
   }
}

class Triangle extends Window_Item
{
   public Triangle(int area, Container con, int xCnt){
      super(area, 4, 4, xCnt);

      block_info[0][0] = new Block(1,0);
      block_info[0][1] = new Block(0,1);
      block_info[0][2] = new Block(1,1);
      block_info[0][3] = new Block(2,1);

      block_info[1][0] = new Block(0,1);
      block_info[1][1] = new Block(1,0);
      block_info[1][2] = new Block(1,1);
      block_info[1][3] = new Block(1,2);

      block_info[2][0] = new Block(0,0);
      block_info[2][1] = new Block(1,0);
      block_info[2][2] = new Block(2,0);
      block_info[2][3] = new Block(1,1);

      block_info[3][0] = new Block(0,0);
      block_info[3][1] = new Block(0,1);
      block_info[3][2] = new Block(0,2);
      block_info[3][3] = new Block(1,1);

      this.setDefaultRandom();
      this.setItem(con); 
   }
}

class RightBlock extends Window_Item
{
   public RightBlock(int area, Container con, int xCnt){
      super(area, 2, 4, xCnt);
      
      block_info[0][0] = new Block(0,0);
      block_info[0][1] = new Block(0,1);
      block_info[0][2] = new Block(1,1);
      block_info[0][3] = new Block(1,2);

      block_info[1][0] = new Block(1,0);
      block_info[1][1] = new Block(0,0);
      block_info[1][2] = new Block(0,1);
      block_info[1][3] = new Block(-1,1);

      this.setDefaultRandom();
      this.setItem(con);
   }
}

class LeftBlock extends Window_Item
{
   public LeftBlock(int area, Container con, int xCnt){
      super(area, 2, 4, xCnt);

      block_info[0][0] = new Block(0,0);
      block_info[0][1] = new Block(1,0);
      block_info[0][2] = new Block(1,1);
      block_info[0][3] = new Block(2,1);

      block_info[1][0] = new Block(0,1);
      block_info[1][1] = new Block(0,0);
      block_info[1][2] = new Block(1,0);
      block_info[1][3] = new Block(1,-1);

      this.setDefaultRandom();
      this.setItem(con);
   }
}