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
			Pane pane = new Pane(); // container�� ����
			
			Scene scene = new Scene(pane, 300, 500); // 800, 500�� ũ��
			
			stage.setScene(scene); //
			stage.show(); // ȭ�鿡 ����
			
			stage.setTitle("Java FX"); // â Ÿ��Ʋ
			stage.setResizable(false); // âũ�� ���� ��� ����
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	public static void main(String[] args) {
		
		launch(args);
		
	}
	
}
