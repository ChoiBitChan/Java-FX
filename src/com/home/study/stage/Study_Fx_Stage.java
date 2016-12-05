package com.home.study.stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Study_Fx_Stage extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		try {
			Pane pane = new Pane(); // container의 종류
			
			Scene scene = new Scene(pane, 300, 500); // 800, 500은 크기
			
			stage.setScene(scene); //
			stage.show(); // 화면에 띄우기
			
			stage.setTitle("Java FX"); // 창 타이틀
			stage.setResizable(false); // 창크기 변경 허락 유무
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	public static void main(String[] args) {
		
		launch(args);
		
	}
	
}
