package com.home.study.fx;

import java.awt.Color;
import java.awt.Container;

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

	//private boolean[][] grid;
	private JPanel[][] background;
	private JPanel[][] subground;

	private Container fc;

	private JPanel center, sub, next;

	private final Color bgColor = Color.black;
	private final Color subColor = Color.white;
	private final Color nextColor = Color.black;
	

	public Window(String str) {

		this.setTitle(str);
		this.xCnt = 14;
		this.yCnt = 25;
		this.sxCnt = 10;
		this.nxCnt = 2;
		this.nyCnt = 6;

		this.area = 20;

		this.width = this.xCnt * this.area;
		this.height = this.yCnt * this.area;

		this.background = new JPanel[this.xCnt][this.yCnt];
		this.subground = new JPanel[this.sxCnt][this.yCnt];
		//this.grid = new boolean[this.xCnt][this.yCnt]; // 블럭의 유무를 알기 위해서 생성

		this.fc = this.getContentPane();

		this.center = new JPanel();
		this.center.setSize(this.width, this.height);
		this.center.setLayout(null);
		this.fc.add(this.center, "Center");

		this.setBounds(200, 200, this.width + (this.sxCnt * this.area) + 36, this.height + 45);

		this.sub = new JPanel();
		this.next = new JPanel();
		this.sub.setBounds(this.width + 10, 0, this.sxCnt * this.area, this.height);
		this.sub.setBackground(this.subColor);
		this.sub.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		
		
		this.next.setBounds(this.nxCnt * this.area, this.nxCnt * this.area, this.nyCnt * this.area, this.nyCnt * this.area);
		this.next.setBackground(this.nextColor);
		this.next.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		
		this.center.add(this.sub);
		this.sub.setLayout(null);
		this.sub.add(this.next);

		for (int i = 0; i < background.length; i++) {
			for (int p = 0; p < background[i].length; p++) {
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
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setVisible(true);
		
		
		
		

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {

		new Window("Window");

	}
}
