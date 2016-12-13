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
		
		// 패널생성
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
		
		// 생성
		head = new Game_Test_Point();
		random = new Game_Test_Point();
		
		
		//헤드의 초기위치 설정
		x = head.getX() + (xCnt/2);
		y = head.getY() + (yCnt/2);
		panel[y][x].setFill(Color.YELLOW);
		head.setX(x);
		head.setY(y);
		
		
		// 리스트
		headlist = new LinkedList<>();
		headlist.add(head);
		//headlist.add(body);
		//headlist.add(tail);
		System.out.println(headlist.size());

		
		
		
		// 랜덤위치
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
		//랜덤의 x : 3
		//랜덤의 y : 3
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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
	
	public void move(int off_y, int off_x){ // 함수를 생성한다
		
		
		//미리 움직여 보고 벽이나 자기자신이 있다면 멈추고, 음식이 있다면 길어진다.
		int temp_y = head.getY() + off_y;
		int temp_x = head.getX() + off_x;
		if(temp_y<0 || temp_x<0 || temp_y>yCnt-1 || temp_x>xCnt-1 || panel[temp_y][temp_x].getFill()==Color.YELLOW){
			System.out.println("게임오버");
			return;
		}
		if(temp_y==random.getY() && temp_x==random.getX()){
			//먹는 로직 -> 먹음과 동시에 헤드가 길어짐
			headlist.add(random);
			head = random;
		}
		else {
		
		//새로운 헤드를 만들어 붙이고
		Game_Test_Point pt = new Game_Test_Point(); // pt 객체 생성
		pt.setY(head.getY() + off_y);
		pt.setX(head.getX() + off_x);
		headlist.add(pt); // 리스트에 pt 추가
		head = pt;
		
		//꼬리를 뗀다
		headlist.poll(); // 리스트에서 삭제
		}
		
		clear(); // 화면 초기화
		//리스트에 들어있는 모든 객체를 찍어줘야함
		for(int i=0; i<headlist.size(); i++){
			int x = headlist.get(i).getX();
			int y = headlist.get(i).getY();
			panel[y][x].setFill(Color.YELLOW);
		}
	}
	
	public void clear() {
		for(int i = 0; i < yCnt; i++){
			for (int j = 0; j < xCnt; j++){
				panel[i][j].setFill(Color.BLACK); // 화면 색칠				
				if(random.getX()==j && random.getY()==i){ // 랜덤값 유지
					panel[i][j].setFill(Color.RED);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
