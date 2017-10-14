package com.chernyshev;
import com.chernyshev.view.ViewFactory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class App extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		ViewFactory viewFactory = new ViewFactory();
		Scene scene = viewFactory.getMainScene();

		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	

}
