package com.home.study.text;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Study_Fx_Text extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub

		try {
			Label text = new Label();
			text.setText("Hello World");
			text.setStyle("-fx-font-size : 30; -fx-text-fill : red; -fx-background-color : black; -fx-border-color : yellow;"); // ��Ʈ ������, ��, ���, �׵θ�
			
			StackPane pane = new StackPane();
			pane.getChildren().add(text);
			
			Scene scene = new Scene(pane, 500, 300);
			
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public static void main(String[] args) {
		
		launch(args);
		
	}
}
