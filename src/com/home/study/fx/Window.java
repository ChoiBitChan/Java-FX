package com.home.study.fx;

import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class Window extends JFrame implements Runnable {

	private int width; // 사이즈
	private int height; // 사이즈
	private int xCnt, yCnt; // 칸 개수
	private int sxCnt, syCnt;
	private int nxCnt, nyCnt;

	private int area; // 단위 ex:20
	private int time;

	// private boolean[][] grid;
	private JPanel[][] background;
	private JPanel[][] subground;
	private ArrayList<Window_Item> itemList;

	private Window_Item nextItem;
	private Window_Item currentItem;

	private Container fc;

	private JPanel center, sub, next;

	private final Color bgColor = Color.black;
	private final Color subColor = Color.white;
	private final Color nextColor = Color.gray;

	Thread t;

	public Window(String str) {

		this.setTitle(str);
		this.xCnt = 14;
		this.yCnt = 25;
		this.sxCnt = 10;
		this.nxCnt = 3;
		this.nyCnt = 4;
		
		this.time = 500;

		this.area = 20;

		this.width = this.xCnt * this.area;
		this.height = this.yCnt * this.area;

		this.itemList = new ArrayList<Window_Item>();

		this.background = new JPanel[this.xCnt][this.yCnt];
		this.subground = new JPanel[this.sxCnt][this.yCnt];
		// this.grid = new boolean[this.xCnt][this.yCnt]; // 블럭의 유무를 알기 위해서 생성

		this.fc = this.getContentPane();

		this.center = new JPanel();
		this.center.setSize(this.width, this.height);
		this.center.setLayout(null);
		this.fc.add(this.center, "Center");

		this.setBounds(200, 200, this.width + (this.sxCnt * this.area) + 36, this.height + 45);

		itemList.add(new Rect(this.area, this.center, this.xCnt));

		this.sub = new JPanel();
		this.next = new JPanel();
		this.sub.setBounds(this.width + 10, 0, this.sxCnt * this.area, this.height);
		this.sub.setBackground(this.subColor);
		this.sub.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

		this.next.setBounds(this.nxCnt * this.area, 1 * this.area, this.nyCnt * this.area, this.nyCnt * this.area);
		this.next.setBackground(this.nextColor);
		this.next.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

		this.center.add(this.sub);
		this.sub.setLayout(null);
		this.sub.add(this.next);

		for (int i = 0; i < background.length; i++) { // 0~13 14회
			for (int p = 0; p < background[i].length; p++) { // 0~24 25회
				this.background[i][p] = new JPanel();
				this.background[i][p].setBounds(i * this.area, p * this.area, this.area, this.area);
				this.background[i][p].setBackground(this.bgColor);
				this.background[i][p].setBorder(new SoftBevelBorder(BevelBorder.RAISED));
				this.center.add(background[i][p]);
			}
		}

		for (int i = 0; i < subground.length; i++) {
			for (int p = 0; p < subground[i].length; p++) {
				this.subground[i][p] = new JPanel();
				this.subground[i][p].setBounds(i * this.area, p * this.area, this.area, this.area);
				this.subground[i][p].setBackground(this.subColor);
				this.subground[i][p].setBorder(new SoftBevelBorder(BevelBorder.RAISED));
				this.sub.add(subground[i][p]);
			}
		}

		this.currentItem = itemList.get(0);
		this.currentItem.setColor(Color.YELLOW);
		this.currentItem.setDefaultLocation();
		setNextItem();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		t = new Thread(this);
		t.start();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			while (true) {
				Thread.sleep(this.time);

				goDown();
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public boolean goDown() {
		Block[] tempBlock = this.currentItem.getBlock();

		for (int i = 0; i < tempBlock.length; i++) {
			int x = tempBlock[i].getX();
			int y = tempBlock[i].getY() + 1;
			if (y >= this.yCnt) {

				setCopyBlock();
				setNewItem();
				return false;
			}
		}

		this.currentItem.moveDown();
		return true;
	}

	public void setCopyBlock() {
		Block[] tempBlock = this.currentItem.getBlock();
		for (int i = 0; i < tempBlock.length; i++) { // i는 0부터 3까지
			setBack(tempBlock[i].getX(), tempBlock[i].getY(), this.currentItem.getColor());
		}
		this.currentItem.setReadyLocation();
	}

	public void setBack(int x, int y, Color c) {
		this.background[x][y].setBackground(c);
		this.background[x][y].setBorder(new SoftBevelBorder(BevelBorder.RAISED));

	}

	public void setNewItem() {
		this.currentItem = this.nextItem;
		this.currentItem.setDefaultLocation();
		setNextItem();
	}

	public void setNextItem() {
		Window_Item temp;

		temp = itemList.get(0);
		this.nextItem = temp;
		this.nextItem.setColor(Color.YELLOW);
		this.nextItem.setNextLocation();
		
	}

	public static void main(String[] args) {

		new Window("Window");

	}
}
