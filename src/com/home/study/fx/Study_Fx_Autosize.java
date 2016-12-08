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
			button1.prefWidthProperty().bind(pane.widthProperty()); // ��ư�� ���� ���̸� â�� ũ��� ����
			button1.prefHeightProperty().bind(pane.heightProperty()); // ��ư�� ���� ���̸� â�� ũ��� ����
			
			Button button2 = new Button();
			button2.setText("TEST");
			button2.prefWidthProperty().bind(pane.widthProperty()); // ��ư�� ���� ����
			button2.prefHeightProperty().bind(pane.heightProperty()); // ��ư�� ���� ����
			
			
			/*
			button2.setMinWidth(50); // �ּ� ���� ����
			button2.setMinHeight(100); // �ּ� ���� ����
			// button2.setMinSize(minWidth, minHeight);
			// Max�� �ݴ�
			*/
			
			grid.addRow(0, button1, button2);
			
			
			pane.getChildren().add(grid);
			pane.setStyle("-fx-border-color:black"); // �����̳��� ũ��
			
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
