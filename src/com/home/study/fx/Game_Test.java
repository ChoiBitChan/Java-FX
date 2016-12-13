package com.home.study.fx;

import java.util.ArrayList;
import java.util.LinkedList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Game_Test extends Application {
	
	int xCnt = 20;
	int yCnt = 20;
	
	int x = 0;
	int y = 0;
	
	int ranX = 0;
	int ranY = 0;
	int cnt = 0;
	
	int rect_size = 20;
	
	int height = 420;
	int width = 420;
	
	Rectangle[][] panel;
	Game_Test_Point random;
	Game_Test_Point head;
	
	LinkedList<Game_Test_Point> headlist; 
	
	GridPane grid = new GridPane();
	
	
	
	Scene scene = new Scene(grid, height, width);
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		
		// �гλ���
		panel = new Rectangle[yCnt][xCnt];
		for(int i = 0; i < yCnt; i++){
			for (int j = 0; j < xCnt; j++){
				Rectangle rect = new Rectangle(rect_size, rect_size);
				rect.setFill(Color.BLACK);
				rect.setStroke(Color.WHITE);
				panel[i][j] = rect;
				
				grid.add(rect, j, i);
			}
		}
		
		// ����
		head = new Game_Test_Point();
		random = new Game_Test_Point();
		
		
		//����� �ʱ���ġ ����
		x = head.getX() + (xCnt/2);
		y = head.getY() + (yCnt/2);
		panel[y][x].setFill(Color.YELLOW);
		head.setX(x);
		head.setY(y);
		
		
		// ����Ʈ
		headlist = new LinkedList<>();
		headlist.add(head);
		//headlist.add(body);
		//headlist.add(tail);
		System.out.println(headlist.size());

		
		
		
		// ������ġ
		ranX = random.getX() + (int)(Math.random() * 20);
		ranY = random.getY() + (int)(Math.random() * 20);
		/*
		if (x == ranX && y == ranY){
			ranX = random.getX() + (int)(Math.random() * 20);
			ranY = random.getY() + (int)(Math.random() * 20);
		}
		*/
		panel[ranY][ranX].setFill(Color.RED);
		random.setX(ranX);
		random.setY(ranY);
		//������ x : 3
		//������ y : 3
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		scene.setOnKeyPressed(e->{
			
			if(e.getCode() == KeyCode.UP){
				
				move(-1, 0);

			}
			
			if(e.getCode() == KeyCode.DOWN){

				move(1, 0);
							
			}
			
			if(e.getCode() == KeyCode.RIGHT){

				move(0, 1);
				
			}
			
			if(e.getCode() == KeyCode.LEFT){

				move(0, -1);

			}
			
		});
		
		stage.setScene(scene);
		stage.show();

	}
	
	public void move(int off_y, int off_x){ // �Լ��� �����Ѵ�
		
		
		//�̸� ������ ���� ���̳� �ڱ��ڽ��� �ִٸ� ���߰�, ������ �ִٸ� �������.
		int temp_y = head.getY() + off_y;
		int temp_x = head.getX() + off_x;
		if(temp_y<0 || temp_x<0 || temp_y>yCnt-1 || temp_x>xCnt-1 || panel[temp_y][temp_x].getFill()==Color.YELLOW){
			System.out.println("���ӿ���");
			return;
		}
		if(temp_y==random.getY() && temp_x==random.getX()){
			//�Դ� ���� -> ������ ���ÿ� ��尡 �����
			headlist.add(random);
			head = random;
		}
		else {
		
		//���ο� ��带 ����� ���̰�
		Game_Test_Point pt = new Game_Test_Point(); // pt ��ü ����
		pt.setY(head.getY() + off_y);
		pt.setX(head.getX() + off_x);
		headlist.add(pt); // ����Ʈ�� pt �߰�
		head = pt;
		
		//������ ����
		headlist.poll(); // ����Ʈ���� ����
		}
		
		clear(); // ȭ�� �ʱ�ȭ
		//����Ʈ�� ����ִ� ��� ��ü�� ��������
		for(int i=0; i<headlist.size(); i++){
			int x = headlist.get(i).getX();
			int y = headlist.get(i).getY();
			panel[y][x].setFill(Color.YELLOW);
		}
	}
	
	public void clear() {
		for(int i = 0; i < yCnt; i++){
			for (int j = 0; j < xCnt; j++){
				panel[i][j].setFill(Color.BLACK); // ȭ�� ��ĥ				
				if(random.getX()==j && random.getY()==i){ // ������ ����
					panel[i][j].setFill(Color.RED);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
