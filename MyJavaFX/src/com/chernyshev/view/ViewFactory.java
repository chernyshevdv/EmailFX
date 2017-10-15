package com.chernyshev.view;

import java.io.IOException;

import com.chernyshev.controller.AbstractController;
import com.chernyshev.controller.MainController;
import com.chernyshev.controller.MessageDetailsController;
import com.chernyshev.model.ModelAccess;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ViewFactory {
	private final static String MAIN_VIEW_FXML = "MainLayout.fxml";
	private final static String DETAILS_VIEW_FXML = "MessageDetailsLayout.fxml";
	private final static String DEFAULT_CSS = "style.css";
	
	private static ViewFactory instance = new ViewFactory(new ModelAccess());
	private ModelAccess modelAccess;
	private MainController mainController;
	private MessageDetailsController messageDetailsController;
	
	public static ViewFactory getInstance(){
		return instance;
	}
	
	private ViewFactory(ModelAccess modelAccess){
		this.modelAccess = modelAccess;
		mainController = new MainController(this.modelAccess);
		messageDetailsController = new MessageDetailsController(this.modelAccess);
	}
	
	public Scene getMainScene(){
		return getSceneFromFXML(MAIN_VIEW_FXML, mainController);
	}
	
	public Scene getMessageDetailsScene(){
		return getSceneFromFXML(DETAILS_VIEW_FXML,messageDetailsController);
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

	public MainController getMainController() {
		return mainController;
	}

	public MessageDetailsController getMessageDetailsController() {
		return messageDetailsController;
	}	
	//// Private methods go here
	
	private Scene getSceneFromFXML(String sceneFile, AbstractController controller){
		Pane pane;
		Scene scene;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(sceneFile));
			loader.setController(controller);
			pane = loader.load(); 
			scene = new Scene(pane);
			scene.getStylesheets().add(getClass().getResource(DEFAULT_CSS).toExternalForm());
		} catch (IOException e) {
			pane = null;
			scene = null;
			e.printStackTrace();
		}
		
		return scene;
	}

}
