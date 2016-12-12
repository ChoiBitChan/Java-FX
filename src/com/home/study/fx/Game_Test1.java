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

	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		
		Rectangle block;
		
		try {
			for(int i = 0; i < 10; i++){
				for(int j = 0; j < 10; j++){
					block = new Rectangle(5,5);
					block.setFill(Color.GRAY);
					
					
					grid.add(block, i, j);
					
				}
			}
					
				
			
		
			
			pane.getChildren().add(grid);
			
			stage.setScene(scene);
			stage.show();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	GridPane grid = new GridPane();
	StackPane pane = new StackPane();
	Scene scene = new Scene(pane, 500, 500);
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
