package com.chernyshev;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.chernyshev.view.ViewFactory;


public class App extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		ViewFactory viewFactory = ViewFactory.getInstance();
		Scene scene = viewFactory.getMainScene();

		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	

}
