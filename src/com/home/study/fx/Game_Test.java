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
	
	// Timeline 선언
	Timeline timeline;
	int time;
	
	// 열거
	public enum Direction{
		// 필요한 값 정의
		Up,
		Down,
		Right,
		Left
	}
	// 선언
	Direction direction;
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		
		// 패널생성
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
		
		// 생성
		head = new Game_Test_Point();
		
		time = 100;
		
		//헤드의 초기위치 설정
		x = head.getX() + (xCnt/2);
		y = head.getY() + (yCnt/2);
		panel[y][x].setFill(hd_color);
		/*
		panel[y][x].setArcWidth(50);
		panel[y][x].setArcHeight(50);
		*/
		head.setX(x);
		head.setY(y);
		
		// 리스트
		headlist = new LinkedList<>();
		headlist.add(head);

		random(); // 초기 랜덤 생성
		
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

	// timeline 생성
	timeline = new Timeline();
		
	// KeyFrame 이름 = new KeyFrame(Duration.millis(초), event -> 이벤트 실행 할 메소드명());
	KeyFrame k = new KeyFrame(Duration.millis(time), e -> going());
		
	// timeline.getKeyFrames().add(KeyFrame 이름);
	timeline.getKeyFrames().add(k);	
	
	// timeline.setCycleCount(Timeline.INDEFINITE);
	timeline.setCycleCount(Timeline.INDEFINITE); // 무한으로 돌기
	
	// timeline.play();
	timeline.play();
		
	
	} //start 메소드 종료
	
	// public void 이벤트 실행 할 메소드명(){
	// if(방향 == ??){
	// 실행될 메소드
	// 	  }
	// }
	
	public void going(){ // 시계방향 순서
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
	
	public void move(int off_y, int off_x){ // 함수를 생성한다
		
		
		//미리 움직여 보고 벽이나 자기자신이 있다면 멈추고, 음식이 있다면 길어진다.
		int temp_y = head.getY() + off_y;
		int temp_x = head.getX() + off_x;
		if(
		   temp_y < 0 || 
		   temp_x < 0 ||
		   temp_y > yCnt - 1 ||
		   temp_x > xCnt - 1 ||
		   panel[temp_y][temp_x].getFill() == hd_color
		  ){
			System.out.println("게임오버");
			return;
		}
		if(temp_y == random.getY() && temp_x == random.getX()){
			//먹는 로직 -> 먹음과 동시에 헤드가 길어짐
			headlist.add(random);
			head = random;
			random(); // 먹고 나서 새로운 함수 생성
			System.out.println(headlist.size());
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
		for(int i = 0; i < headlist.size(); i++){
			int x = headlist.get(i).getX();
			int y = headlist.get(i).getY();
			panel[y][x].setFill(hd_color);
		}
	}
	
	public void clear() {
		for(int i = 0; i < yCnt; i++){
			for (int j = 0; j < xCnt; j++){
				panel[i][j].setFill(bg_color); // 화면 색칠				
				if(random.getX() == j && random.getY() == i){ // 랜덤값 유지
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
