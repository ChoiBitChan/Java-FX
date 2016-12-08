package com.home.study.fx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Test1 extends Application {
	
	

	@Override
	public void start(Stage stage) {
		// TODO Auto-generated method stub
		
		int a = 1;
		
		try {
			for(int x = 0; x < 4; x++){
				for(int y = 0; y < 4; y++){
					Button button = new Button();
					//button.setText(" ["+x+","+y+"]");
					
					button.setText(Integer.toString(a));
					a++;
					
					button.setStyle("-fx-font-size : 10");
					button.prefWidthProperty().bind(pane.widthProperty());
					button.prefHeightProperty().bind(pane.heightProperty());
					grid.addRow(x, button);
					
					button.setOnAction(e->{
						System.out.println(button.getText());
						
						button.setText("OK");
						button.setStyle("-fx-background-color : white");
					});
				}
			}
			
			pane.getChildren().add(grid);
			//grid.getChildren().add(button);
			
			grid.setAlignment(Pos.CENTER);
			
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
