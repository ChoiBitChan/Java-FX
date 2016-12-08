package com.home.study.fx;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;


public class Window extends JFrame implements Runnable, KeyListener {

	private int width; // ������
	private int height; // ������
	private int xCnt, yCnt; // ĭ ����
	private int sxCnt, syCnt;
	private int nxCnt, nyCnt;

	private int area; // ���� ex:20
	private int time;

	private boolean[][] grid;
	private JPanel[][] background; // background �г�
	private JPanel[][] subground; // subground �г�
	private ArrayList<Window_Item> itemList; // ������ ����Ʈ
	private ArrayList<Color> colorList;
	
	private Random rnd;

	private Window_Item nextItem; // �ؽ�Ʈ ������
	private Window_Item currentItem; // ���� ������

	private Container fc; // �����̳�

	private JPanel center, sub, next; // �г��� ����
	
	private boolean isKey = true;

	private final Color bgColor = Color.black;
	private final Color subColor = Color.white;
	private final Color nextColor = Color.gray;

	Thread t; // ������

	public Window(String str) {

		this.setTitle(str);
		this.xCnt = 14; // ������ ������ 14��
		this.yCnt = 25; // ������ ������ 25��
		this.sxCnt = 10; // sub �г� ���� ������ 10��
		this.nxCnt = 3; // next �г� ���� ������ 3��
		this.nyCnt = 4; // next �г� ���� ������ 4��
		
		this.time = 250; // �����带 0.5�ʵ��� �۵���ų time

		this.area = 20; // ���� 20

		this.width = this.xCnt * this.area; // �� ���� ���̸� 14 * 20
		this.height = this.yCnt * this.area; // �� ���� ���̸� 25 * 20

		this.itemList = new ArrayList<Window_Item>(); // Window_Item���� ������ ����Ʈ�� �����´�

		this.background = new JPanel[this.xCnt][this.yCnt]; // background ��� �̸��� 14 x 25���� ���۷������� ����
		this.subground = new JPanel[this.sxCnt][this.yCnt]; // subground 
		this.grid = new boolean[this.xCnt][this.yCnt]; // ���� ������ �˱� ���ؼ� ����
		this.rnd = new Random(System.currentTimeMillis());

		this.fc = this.getContentPane(); // �����̳�

		this.center = new JPanel(); // center �г�
		this.center.setSize(this.width, this.height); // ������ 280 x 500
		this.center.setLayout(null); // ���̾ƿ� 
		this.fc.add(this.center, "Center"); // center �г��� �����̳ʿ� �ִ´�
		
		this.addKeyListener(this);
		this.setBounds(200, 200, this.width + (this.sxCnt * this.area) + 36, this.height + 45); // �ʱ� ���� ����(â�� ��ġ)

		itemList.add(new Rect(this.area, this.center, this.xCnt));
		itemList.add(new OneThree(this.area, this.center, this.xCnt));
	    itemList.add(new ThreeOne(this.area, this.center, this.xCnt));
	    itemList.add(new LineBlock(this.area, this.center, this.xCnt));
	    itemList.add(new Triangle(this.area, this.center, this.xCnt));
	    itemList.add(new RightBlock(this.area, this.center, this.xCnt));
	    itemList.add(new LeftBlock(this.area, this.center, this.xCnt)); 
		
		this.colorList = new ArrayList<Color>();
		this.colorList.add(Color.red);
		this.colorList.add(Color.blue);
	    this.colorList.add(Color.green);
	    this.colorList.add(Color.orange);
	    this.colorList.add(Color.pink);
		
		this.sub = new JPanel(); // sub �г�
		this.next = new JPanel(); // next �г�
		this.sub.setBounds((this.width + 10), 0, (this.sxCnt * this.area), this.height); // sub �г��� �ʱ� ��ġ�� �����Ѵ� (280, 0, 200, 500)
		this.sub.setBackground(this.subColor);
		this.sub.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

		this.next.setBounds(this.nxCnt * this.area, 1 * this.area, this.nyCnt * this.area, this.nyCnt * this.area); // next �г��� �ʱ� ��ġ�� �����Ѵ�
		this.next.setBackground(this.nextColor);
		this.next.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

		this.center.add(this.sub); // center �гο� sub �г��� �ø���
		this.sub.setLayout(null); // 
		this.sub.add(this.next); // sub �гο� next �г��� �ø���
		
		for (int i = 0; i < background.length; i++) { // 0~13 14ȸ
			for (int p = 0; p < background[i].length; p++) { // 0~24 25ȸ
				this.background[i][p] = new JPanel(); // background�� �ִ� ������ ���۷��� ���� ����
				this.background[i][p].setBounds(i * this.area, p * this.area, this.area, this.area); // ������ �г� ��ġ �� ũ�� ����
				this.background[i][p].setBackground(this.bgColor);
				this.background[i][p].setBorder(new SoftBevelBorder(BevelBorder.RAISED));
				this.center.add(background[i][p]); // ������ ������ �г��� center�� ����
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
		
		this.currentItem = itemList.get(rnd.nextInt(itemList.size()));
		this.currentItem.setColor(this.colorList.get(this.rnd.nextInt(this.colorList.size())));
		this.currentItem.setDefaultLocation();
		setNextItem();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	
		t = new Thread(this);
		t.start();
		
	}
	
	public void setNextItem() {
		Window_Item temp;
		do{
			temp = itemList.get(rnd.nextInt(itemList.size()));
		}
		while (temp == this.currentItem);
		this.nextItem = temp;
		this.nextItem.setColor(this.colorList.get(this.rnd.nextInt(this.colorList.size())));
		this.nextItem.setNextLocation();
		
	}
	
	public void setNewItem() {
		this.currentItem = this.nextItem;
		this.currentItem.setDefaultLocation();
		setNextItem();
	}

	public void setBack(int x, int y, Color c) {
		this.background[x][y].setBackground(c);
		this.background[x][y].setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		this.grid[x][y] = true;
	}
	
	public void setEmptyBack(int x, int y) {
		this.background[x][y].setBorder(null);
		this.background[x][y].setBackground(this.bgColor);
		this.grid[x][y] = false;
	}

	public void setCopyBlock() {
		Block[] tempBlock = this.currentItem.getBlock();
		for (int i = 0; i < tempBlock.length; i++) {
			setBack(tempBlock[i].getX(), tempBlock[i].getY(), this.currentItem.getColor());
		}
		this.currentItem.setReadyLocation();
	}
	
	public void checkLine() {
		for (int i = 0; i < grid[0].length; i++) {
			boolean isLine = true;
			for (int p = 0; p < grid.length; p++) {
				if(!grid[p][i]) {
					isLine = false;
					break;
				}
			}
			if(isLine) {
				deleteLine(i);
			}
		}
	}
	
	public void deleteLine(int line) {
		boolean temp[] = new boolean[xCnt];
		JPanel tempPanel[] = new JPanel[xCnt];
		
		for (int i = line; i > 0; i--) {
			for (int p = 0; p < grid.length; p++) {
				if(i==line) {
					tempPanel[p] = background[p][i];
					tempPanel[p].setLocation(p * this.area, 0);
				}
				grid[p][i] = grid[p][i-1];
				background[p][i] = background[p][i-1];
				background[p][i].setLocation(p * this.area, i * this.area);
			}
		}
		
		for (int i = 0; i < grid.length; i++) {
			background[i][0] = tempPanel[i];
			setEmptyBack(i, 0);
		}
	}
	
	public void printInfo() {
		Block temp = this.currentItem.getCurrentXY();
	}
	
	public void goRotate() {
		Block[]	tempBlock = this.currentItem.getNextBlock();
		for (int i = 0; i < tempBlock.length; i++) {
			int x = tempBlock[i].getX();
			int y = tempBlock[i].getY();
			if(x < 0 || x >= this.xCnt || y+1 >= this.yCnt || this.grid[x][y] ) {
				return;
			}
		}
		this.currentItem.moveRotate();
	}
	
	public boolean goDown() {
		Block[] tempBlock = this.currentItem.getBlock();
		for (int i = 0; i < tempBlock.length; i++) {
			int x = tempBlock[i].getX();
			int y = tempBlock[i].getY() + 1;
			
			if(y >= this.yCnt || this.grid[x][y]) {
				setCopyBlock();
				checkLine();
				setNewItem();
				return false;
			}
		}
		
		this.currentItem.moveDown();
		return true;
	}
	
	public void goRight() {
		Block[] tempBlock = this.currentItem.getBlock();
		
		for (int i = 0; i < tempBlock.length; i++) {
			int x = tempBlock[i].getX() + 1;
			int y = tempBlock[i].getY();
			if(x >= this.xCnt || this.grid[x][y]) {
				return;
			}
		}
		this.currentItem.moveRight();
	}
	
	public void goLeft() {
		Block[] tempBlock = this.currentItem.getBlock();
		
		for (int i = 0; i < tempBlock.length; i++) {
			int x = tempBlock[i].getX() - 1;
			int y = tempBlock[i].getY();
			if(x < 0 || this.grid[x][y]) {
				return;
			}
		}
		this.currentItem.moveLeft();
	}
	

	

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(!this.isKey) return;
		switch (e.getKeyCode()) {
		case KeyEvent.VK_DOWN : 
			goDown();
			break;
		case KeyEvent.VK_LEFT:
            goLeft();
            break;
		case KeyEvent.VK_RIGHT:
	        goRight();
	        break;
		case KeyEvent.VK_UP:
            goRotate();
            break;    
		case KeyEvent.VK_SPACE:
            while(goDown()){}
            break;   
		}
	}
	public void keyReleased(KeyEvent e){}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true) {
				Thread.sleep(this.time);
				goDown();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

		new Window("Window");

	}
	
}
