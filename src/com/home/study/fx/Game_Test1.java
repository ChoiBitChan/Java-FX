package com.home.study.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Game_Test1 extends Application {
	
	GridPane grid = new GridPane();
	StackPane pane = new StackPane();
	Scene scene = new Scene(pane, 500, 500);
	
	Rectangle[][] block;
	GridPane background;
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			Rectangle rect;
			block = new Rectangle[10][10];
			for(int i = 0; i < 10; i++){
				for(int j = 0; j < 10; j++){
					rect = new Rectangle(5, 5);
					rect.setFill(Color.GRAY);
					block[i][j] = rect;
					background.add(rect, j, i);
					
					
					//grid.add(block, i, j);
					
				}
			}
					
			pane.getChildren().add(background);
			
			stage.setScene(scene);
			stage.show();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
