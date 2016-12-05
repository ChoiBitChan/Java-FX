package com.home.study.button;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Study_Fx_Text extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		try {
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
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	int num = 0;
	
	public static void main(String[] args) {
		
		launch(args);
		
	}
}
