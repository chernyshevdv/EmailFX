package com.chernyshev;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.web.WebView;

public class MessageDetailsController implements Initializable {
	private Singleton singleton;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		singleton = Singleton.getInstance();
		subjectLabel.setText(singleton.getMessage().getSubject());
		senderLabel.setText(singleton.getMessage().getSender());
		messageWebView.getEngine().loadContent(singleton.getMessage().getContent());
		
		System.out.println("MessageDetailsController has initialized.");
		
	}
	
    @FXML
    private Label subjectLabel;

    @FXML
    private Label senderLabel;
    
    @FXML 
    private WebView messageWebView;

}
