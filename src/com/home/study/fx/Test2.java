package com.home.study.fx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Test2 extends Application {
	
	GridPane[][] grid;
	StackPane pane = new StackPane();
	Scene scene = new Scene(pane, 400, 600);
	
	@Override
	public void start(Stage stage) {
		// TODO Auto-generated method stub
		
		this.grid = new GridPane[4][4];
		
		stage.setScene(scene);
		stage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
