package com.home.study.fx;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;


class Block {

	private int x;
	private int y;

	// 생성자
	public Block() {
	}

	public Block(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// 해당 포인트만큼 감산
	public void move(int xPlus, int yPlus) {
		this.x += xPlus;
		this.y += yPlus;
	}

	// X좌표 반환
	public int getX() {
		return this.x;
	}

	// Y좌표 반환
	public int getY() {
		return this.y;
	}

	// 자신 반환
	public Block getBlock() {
		return this;
	}

	// XY세팅
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

public class Window_Item {

	JPanel[] panel;
	Block[] block; // 현재포인트 좌표
	Block[][] block_info; // 각도별 포인트

	Block currentXY;
	int cnt; // 총판넬 개수
	int angle; // 총각도 개수
	int current_angle; // 현재 각도값
	int xCnt; // 가로값

	Color color = Color.YELLOW;
	int area; // 넓이

	public Window_Item(int area, int angle, int cnt, int xCnt) {
		this.angle = angle; // 각도 개수
		this.cnt = cnt; // cnt = 4

		this.panel = new JPanel[cnt];
		this.block = new Block[cnt];
		this.block_info = new Block[angle][cnt];
		this.area = area; // area = 20

		this.currentXY = new Block(0, 0); // 현재 값
		this.xCnt = xCnt; // xCnt = 14

		for (int i = 0; i < cnt; i++) { // 패널 생성 cnt = 4;
			this.panel[i] = new JPanel(); // 모든 블럭은 4개의 패널만 생성
		}
	}

	public void setDefaultRandom() {
		this.current_angle = (int) (Math.random() * this.angle);

		this.block = this.block_info[this.current_angle];

	}

	public void setItem(Container c) {
		for (int i = 0; i < panel.length; i++) {

			panel[i].setBackground(this.color);
			panel[i].setSize(area, area);
			panel[i].setLocation(((block[i].getX()) * area) - 100, ((block[i].getY()) * area) - 100);

			panel[i].setBorder(new SoftBevelBorder(BevelBorder.RAISED));

			c.add(panel[i]);
		}
	}

	public void setNextLocation() {
		for (int i = 0; i < panel.length; i++) {
			int x = block[i].getX() + (xCnt - 3);
			int y = block[i].getY() + 1;
			panel[i].setLocation(x * area, y * area);
		}
		this.currentXY.setXY((xCnt - 3), 1);
	}

	public void setDefaultLocation() {
		for (int i = 0; i < panel.length; i++) {
			int x = block[i].getX() + (int) (xCnt / 2 - 2);

			int y = block[i].getY() + 2;

			panel[i].setLocation(x * area, y * area);

		}
		this.currentXY.setXY((int) (xCnt / 2 - 2), 3);
	}

	public void setReadyLocation() {
		for (int i = 0; i < panel.length; i++) {
			panel[i].setLocation(((block[i].getX()) * area) - 100, ((block[i].getY()) * area) - 100);

		}
	}

	public Block getCurrentXY() {
		return this.currentXY;
	}

	public void setCurrentXY(int x, int y) {
		this.currentXY.move(x, y);
	}

	public Block[] getBlock() {
		Block[] temp = new Block[cnt];
		for (int i = 0; i < block.length; i++) {
			int x = block[i].getX() + this.currentXY.getX();
			int y = block[i].getY() + this.currentXY.getY();
			temp[i] = new Block(x, y);
		}
		return temp;
	}

	public void setColor(Color c) {

		this.color = c;
		for (int i = 0; i < panel.length; i++) {
			panel[i].setBackground(this.color);
		}
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

	public Color getColor() {
		return this.color;
	}

}

class Rect extends Window_Item {

	public Rect(int area, Container con, int xCnt) {
		super(area, 1, 4, xCnt);

		block_info[0][0] = new Block(0, 0);
		block_info[0][1] = new Block(0, 1);
		block_info[0][2] = new Block(1, 0);
		block_info[0][3] = new Block(1, 1);

		this.setDefaultRandom();
		this.setItem(con);

	}
}
