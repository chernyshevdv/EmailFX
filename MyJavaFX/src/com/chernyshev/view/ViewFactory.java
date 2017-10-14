package com.chernyshev.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ViewFactory {
	public Scene getMainScene(){
		return getSceneFromFXML("MainLayout.fxml");
	}
	
	public Scene getMessageDetailsScene(){
		return getSceneFromFXML("MessageDetailsLayout.fxml");
	}
	
	public Node resolveIcon(String treeItemValue){
		String lowerCaseTreeItemValue = treeItemValue.toLowerCase();
		ImageView returnIcon;
		
		try {
			if (lowerCaseTreeItemValue.contains("inbox"))
				returnIcon = new ImageView(new Image(getClass().getResourceAsStream("images/inbox.png")));
			else if (lowerCaseTreeItemValue.contains("sent"))
				returnIcon = new ImageView(new Image(getClass().getResourceAsStream("images/sent2.png")));
			else if (lowerCaseTreeItemValue.contains("spam"))
				returnIcon = new ImageView(new Image(getClass().getResourceAsStream("images/spam.png")));
			else if (lowerCaseTreeItemValue.contains("@"))
				returnIcon = new ImageView(new Image(getClass().getResourceAsStream("images/email.png")));
			else
				returnIcon = new ImageView(new Image(getClass().getResourceAsStream("images/folder.png")));
		} catch (NullPointerException e) {
			System.out.println("Invalid image pointer.");
			e.printStackTrace();
			returnIcon = new ImageView();
		}
		returnIcon.setFitHeight(16);
		returnIcon.setFitWidth(16);
		return returnIcon;
	}
	
	//// Private methods go here
	
	private Scene getSceneFromFXML(String sceneFile){
		Pane pane;
		Scene scene;
		try {
			pane = FXMLLoader.load(getClass().getResource(sceneFile));
			scene = new Scene(pane);
			scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		} catch (IOException e) {
			pane = null;
			scene = null;
			e.printStackTrace();
		}
		
		return scene;
	}
}
