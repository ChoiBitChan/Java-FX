package com.home.study.fx;


import javafx.application.Application;
import javafx.geometry.Pos;
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
			/*
			
			Label label1 = new Label("Hello");
			Label label2 = new Label("World");
			
			1
			grid.addColumn(0, label1, label2); // 가로
			grid.setHgap(10); // 가로의 갭
			*/
			
			
			/*
			2
			grid.addRow(0, label1, label2); // 세로
			grid.setVgap(10); // 세로의 갭
			*/
			
			
			/*
			3
			for (int y = 0; y < 10; y++){
				for (int x = 0; x < 10; x++){
					Label label = new Label();
					label.setStyle("-fx-border-color:black; -fx-font-size:15;");
					label.setText(" ("+x+","+y+")");
					grid.addRow(y, label);
				}
			}
			*/
			
			
			
			Label label1 = new Label("A");
			Label label2 = new Label("B");
			Label label3 = new Label("C");
			
			label1.setStyle("-fx-border-color:black; -fx-font-size:30;");
			label2.setStyle("-fx-border-color:black; -fx-font-size:30;");
			label3.setStyle("-fx-border-color:black; -fx-font-size:30;");
			
			// grid.add(child, columnIndex, rowIndex, colspan, rowspan);
			grid.add(label1, 0, 0, 1, 1);
			grid.add(label2, 0, 1, 1, 1);
			grid.add(label3, 1, 1, 1, 1);
			
			grid.setAlignment(Pos.CENTER);
			
			
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
