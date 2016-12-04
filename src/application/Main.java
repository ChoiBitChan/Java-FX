package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try { // 코드 실행되는 곳
			// stage > scene > container > node 크기 순서
			// Shift + Ctrl + O : import 하기
			
			
			
			
			/* 기초
			// 창
			Pane pane = new Pane(); // container의 종류
			
			Scene scene = new Scene(pane, 300, 500); // 800, 500은 크기
			
			stage.setScene(scene); //
			stage.show(); // 화면에 띄우기
			
			stage.setTitle("Java FX"); // 창 타이틀
			stage.setResizable(false); // 창크기 변경 허락 유무
			*/
			
			
			
			/*
			// 텍스트
			Label text = new Label();
			text.setText("Hello World");
			text.setStyle("-fx-font-size : 30; -fx-text-fill : red; -fx-background-color : black; -fx-border-color : yellow;"); // 폰트 사이즈, 색, 배경, 테두리
			
			StackPane pane = new StackPane();
			pane.getChildren().add(text);
			
			Scene scene = new Scene(pane, 500, 300);
			
			stage.setScene(scene);
			stage.show();
			*/
			
			
			
			/*
			// 버튼
			Label label = new Label();
			label.setText(Integer.toString(num)); // 문자만 가능
			label.setStyle("-fx-font-size : 30");
			
			Button button = new Button();
			button.setText("Add");
			button.setStyle("-fx-font-size : 15;");
			button.setOnAction(e->{ // 버튼을 눌렀을때의 이벤트
				num++; // 버튼을 누르면 숫자가 증가
				label.setText(Integer.toString(num));
			});
			
			StackPane pane = new StackPane();
			pane.getChildren().add(label);
			pane.getChildren().add(button);
			//pane.getChildren().addAll(label, button); // 모두 적용도 가능하다
			StackPane.setAlignment(label, Pos.CENTER); // 위치
			StackPane.setAlignment(button, Pos.BOTTOM_CENTER);
			
			Scene scene = new Scene(pane, 150, 150);
			
			stage.setScene(scene);
			stage.show();
			*/
			
			
			
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	int num = 0;
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
