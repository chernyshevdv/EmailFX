package com.chernyshev;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class MyJavaFX extends Application{
	@Override
	public void start(Stage primaryStage) {
		StackPane pane = new StackPane();
		pane.getChildren().add(new Button("Stack pane"));
		Scene scene = new Scene(pane,200, 50);
		primaryStage.setTitle("Stack pane demo");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		Stage stage2 = new Stage();
		Circle circle = new Circle();
		circle.setCenterX(100);
		circle.setCenterY(100);
		circle.setRadius(50);
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
