package com.chernyshev;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class App extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane pane =  FXMLLoader.load(getClass().getResource("MainLayout.fxml"));
		
		Scene scene = new Scene(pane);
		scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	

}
