package com.chernyshev.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.web.WebView;

import com.chernyshev.model.EmailMessageBean;
import com.chernyshev.model.ModelAccess;

public class MessageDetailsController extends AbstractController implements Initializable {
	public MessageDetailsController(ModelAccess modelAccess) {
		super(modelAccess);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		EmailMessageBean message = getModelAccess().getMessage();
		subjectLabel.setText(message.getSubject());
		senderLabel.setText(message.getSender());
		messageWebView.getEngine().loadContent(message.getContent());
		
		System.out.println("MessageDetailsController has initialized.");
		
	}
	
    @FXML
    private Label subjectLabel;

    @FXML
    private Label senderLabel;
    
    @FXML 
    private WebView messageWebView;

}
