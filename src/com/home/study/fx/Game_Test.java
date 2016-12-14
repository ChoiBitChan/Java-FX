package com.home.study.fx;

import java.util.ArrayList;
import java.util.LinkedList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


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
	int width = 600;
	
	Rectangle[][] panel;
	Game_Test_Point random;
	Game_Test_Point head;
	
	Color bg_color = Color.BLACK;
	Color bord_color = Color.WHITE;
	Color hd_color = Color.YELLOW;
	Color ran_color = Color.RED;
	
	LinkedList<Game_Test_Point> headlist; 
	
	//Game_Test_Going going = new Game_Test_Going();
	
	GridPane grid = new GridPane();
	
	Scene scene = new Scene(grid, width, height);
	
	// Timeline ����
	Timeline timeline;
	int time;
	
	// ����
	public enum Direction{
		// �ʿ��� �� ����
		Up,
		Down,
		Right,
		Left
	}
	// ����
	Direction direction;
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		
		// �гλ���
		panel = new Rectangle[yCnt][xCnt];
		for(int i = 0; i < yCnt; i++){
			for (int j = 0; j < xCnt; j++){
				Rectangle rect = new Rectangle(rect_size, rect_size);
				rect.setFill(bg_color);
				//rect.setStroke(bord_color);
				panel[i][j] = rect;
				
				grid.add(rect, j, i);
			}
		}
		
		// ����
		head = new Game_Test_Point();
		
		time = 100;
		
		//����� �ʱ���ġ ����
		x = head.getX() + (xCnt/2);
		y = head.getY() + (yCnt/2);
		panel[y][x].setFill(hd_color);
		/*
		panel[y][x].setArcWidth(50);
		panel[y][x].setArcHeight(50);
		*/
		head.setX(x);
		head.setY(y);
		
		// ����Ʈ
		headlist = new LinkedList<>();
		headlist.add(head);

		random(); // �ʱ� ���� ����
		
		scene.setOnKeyPressed(e->{
			if(e.getCode() == KeyCode.UP){
				//move(-1, 0);
				direction = Direction.Up;
			}
			if(e.getCode() == KeyCode.DOWN){
				//move(1, 0);
				direction = Direction.Down;
			}
			if(e.getCode() == KeyCode.RIGHT){
				//move(0, 1);
				direction = Direction.Right;
			}
			if(e.getCode() == KeyCode.LEFT){
				//move(0, -1);
				direction = Direction.Left;
			}
			if(e.getCode() == KeyCode.SPACE){
				//move(0, -1);
			}
		});
		
		stage.setScene(scene);
		stage.show();
		
		//going.start();

	// timeline ����
	timeline = new Timeline();
		
	// KeyFrame �̸� = new KeyFrame(Duration.millis(��), event -> �̺�Ʈ ���� �� �޼ҵ��());
	KeyFrame k = new KeyFrame(Duration.millis(time), e -> going());
		
	// timeline.getKeyFrames().add(KeyFrame �̸�);
	timeline.getKeyFrames().add(k);	
	
	// timeline.setCycleCount(Timeline.INDEFINITE);
	timeline.setCycleCount(Timeline.INDEFINITE); // �������� ����
	
	// timeline.play();
	timeline.play();
		
	
	} //start �޼ҵ� ����
	
	// public void �̺�Ʈ ���� �� �޼ҵ��(){
	// if(���� == ??){
	// ����� �޼ҵ�
	// 	  }
	// }
	
	public void going(){ // �ð���� ����
		if(direction == Direction.Up){
			move(-1, 0);
		}
		if(direction == Direction.Right){
			move(0, 1);
		}
		if(direction == Direction.Down){
			move(1, 0);
		}
		if(direction == Direction.Left){
			move(0, -1);
		}
	}
	
	public void move(int off_y, int off_x){ // �Լ��� �����Ѵ�
		
		
		//�̸� ������ ���� ���̳� �ڱ��ڽ��� �ִٸ� ���߰�, ������ �ִٸ� �������.
		int temp_y = head.getY() + off_y;
		int temp_x = head.getX() + off_x;
		if(
		   temp_y < 0 || 
		   temp_x < 0 ||
		   temp_y > yCnt - 1 ||
		   temp_x > xCnt - 1 ||
		   panel[temp_y][temp_x].getFill() == hd_color
		  ){
			System.out.println("���ӿ���");
			return;
		}
		if(temp_y == random.getY() && temp_x == random.getX()){
			//�Դ� ���� -> ������ ���ÿ� ��尡 �����
			headlist.add(random);
			head = random;
			random(); // �԰� ���� ���ο� �Լ� ����
			System.out.println(headlist.size());
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
		for(int i = 0; i < headlist.size(); i++){
			int x = headlist.get(i).getX();
			int y = headlist.get(i).getY();
			panel[y][x].setFill(hd_color);
		}
	}
	
	public void clear() {
		for(int i = 0; i < yCnt; i++){
			for (int j = 0; j < xCnt; j++){
				panel[i][j].setFill(bg_color); // ȭ�� ��ĥ				
				if(random.getX() == j && random.getY() == i){ // ������ ����
					panel[i][j].setFill(ran_color);
					
				}
			}
		}
	}
	
	public void random() {
		random = new Game_Test_Point();
		
		ranX = random.getX() + (int)(Math.random() * 20);
		ranY = random.getY() + (int)(Math.random() * 20);
		panel[ranY][ranX].setFill(ran_color);
		random.setX(ranX);
		random.setY(ranY);
		
		for(int i = 0; i < headlist.size(); i++){
			int x = headlist.get(i).getX();
			int y = headlist.get(i).getY();
			if(x == ranX && y == ranY){
				random();
			}
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
