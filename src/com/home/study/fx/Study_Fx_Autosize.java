package com.home.study.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Study_Fx_Autosize extends Application {
	@Override
	public void start(Stage stage) {
		// TODO Auto-generated method stub
		try {
			
			// stage > scene > container(pane) > node
			
			Button button1 = new Button();
			button1.setText("Button");
			button1.prefWidthProperty().bind(pane.widthProperty()); // 버튼의 가로 길이를 창의 크기와 같게
			button1.prefHeightProperty().bind(pane.heightProperty()); // 버튼의 세로 길이를 창의 크기와 같게
			
			Button button2 = new Button();
			button2.setText("TEST");
			button2.prefWidthProperty().bind(pane.widthProperty()); // 버튼의 가로 길이
			button2.prefHeightProperty().bind(pane.heightProperty()); // 버튼의 세로 길이
			
			
			/*
			button2.setMinWidth(50); // 최소 가로 길이
			button2.setMinHeight(100); // 최소 세로 길이
			// button2.setMinSize(minWidth, minHeight);
			// Max는 반대
			*/
			
			grid.addRow(0, button1, button2);
			
			
			pane.getChildren().add(grid);
			pane.setStyle("-fx-border-color:black"); // 컨테이너의 크기
			
			stage.setScene(scene);
			stage.show();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	GridPane grid = new GridPane();
	StackPane pane = new StackPane();
	Scene scene = new Scene(pane, 100, 100);
	
	public static void main(String[] args) {
		launch(args);
	}

}
