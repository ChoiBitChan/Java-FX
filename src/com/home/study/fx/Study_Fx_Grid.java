package com.home.study.fx;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Study_Fx_Grid extends Application {

	@Override
	public void start(Stage stage) {
		// TODO Auto-generated method stub
		// stage > scene > container(pane) > node
		
		try {
			
			Label label1 = new Label("Hello");
			Label label2 = new Label("World");
			
			grid.addColumn(0, label1, label2); // 가로
			//grid.addRow(rowIndex, children); // 세로
			
			
			
			stage.setScene(scene);
			stage.show();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	GridPane grid = new GridPane();
	Scene scene = new Scene(grid, 400, 400);
	
	
	public static void main(String[] args) {
		
		launch(args);
		
	}
	
}
