//package BC_Snake;
//
//import javafx.animation.KeyFrame;
//import javafx.animation.Timeline;
//import javafx.application.Application;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Label;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
//import javafx.util.Duration;
//
//public class ThreadTest extends Application {
//
//	Label label = new Label();
//	StackPane pane = new StackPane();
//	Scene scene = new Scene(pane, 500, 500);
//	Timeline timeline;
//	
//	
//	@Override
//	public void start(Stage stage) throws Exception {
//		// TODO Auto-generated method stub
//		TimeThread tt = new TimeThread();
//		System.out.println("½ÃÀÛ");
//		tt.start();
//		
//		//label.setText(Integer.toString(tt.timeCnt));
//		label.setStyle("-fx-font-size:50");
//		pane.getChildren().add(label);
//		pane.setAlignment(label, Pos.CENTER);
//		stage.setScene(scene);
//		stage.show();
//		
//		timeline = new Timeline();
//		KeyFrame k = new KeyFrame(Duration.millis(100),
//				e -> label.setText(Integer.toString(tt.timeCnt)));
//		timeline.getKeyFrames().add(k);
//		timeline.setCycleCount(Timeline.INDEFINITE);
//		timeline.play();
//		
//	}
//
//	public static void main(String[] args) {
//		launch(args);
//	}
//}
