package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try { // �ڵ� ����Ǵ� ��
			// stage > scene > container > node ũ�� ����
			// Shift + Ctrl + O : import �ϱ�
			
			
			
			
			/* ����
			// â
			Pane pane = new Pane(); // container�� ����
			
			Scene scene = new Scene(pane, 300, 500); // 800, 500�� ũ��
			
			stage.setScene(scene); //
			stage.show(); // ȭ�鿡 ����
			
			stage.setTitle("Java FX"); // â Ÿ��Ʋ
			stage.setResizable(false); // âũ�� ���� ��� ����
			*/
			
			
			
			/*
			// �ؽ�Ʈ
			Label text = new Label();
			text.setText("Hello World");
			text.setStyle("-fx-font-size : 30; -fx-text-fill : red; -fx-background-color : black; -fx-border-color : yellow;"); // ��Ʈ ������, ��, ���, �׵θ�
			
			StackPane pane = new StackPane();
			pane.getChildren().add(text);
			
			Scene scene = new Scene(pane, 500, 300);
			
			stage.setScene(scene);
			stage.show();
			*/
			
			
			
			/*
			// ��ư
			Label label = new Label();
			label.setText(Integer.toString(num)); // ���ڸ� ����
			label.setStyle("-fx-font-size : 30");
			
			Button button = new Button();
			button.setText("Add");
			button.setStyle("-fx-font-size : 15;");
			button.setOnAction(e->{ // ��ư�� ���������� �̺�Ʈ
				num++; // ��ư�� ������ ���ڰ� ����
				label.setText(Integer.toString(num));
			});
			
			StackPane pane = new StackPane();
			pane.getChildren().add(label);
			pane.getChildren().add(button);
			//pane.getChildren().addAll(label, button); // ��� ���뵵 �����ϴ�
			StackPane.setAlignment(label, Pos.CENTER); // ��ġ
			StackPane.setAlignment(button, Pos.BOTTOM_CENTER);
			
			Scene scene = new Scene(pane, 150, 150);
			
			stage.setScene(scene);
			stage.show();
			*/
			
			
			
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	int num = 0;
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
