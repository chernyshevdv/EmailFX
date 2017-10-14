package com.chernyshev;

import java.util.HashMap;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SampleData {
	private final ObservableList<EmailMessageBean> inbox = FXCollections.observableArrayList(
	    		new EmailMessageBean("Hello from Bobby", "aaa@bbb.com", 5500000, "<html>Hello my friend!</html>"),
	    		new EmailMessageBean("Hello from Lobby", "aaa@bbb.ie", 200, "<html>Hello my friend!</html>"),
	    		new EmailMessageBean("Hello from Craftsmanship", "aaa@bbb.com", 10, "<html>Hello my friend!</html>"),
	    		new EmailMessageBean("Hello from Raymondo", "aaa@bbb.com", 6300, "<html>Hello my friend!</html>")
			);
	
	private final ObservableList<EmailMessageBean> sent = FXCollections.observableArrayList(
    		new EmailMessageBean("Hi from Bobby", "aaa@bbb.com", 5500000, "<html>Hi my friend! I am Bobby.</html>"),
    		new EmailMessageBean("Hi from Lobby", "aaa@bbb.ie", 200, "<html>Hi my friend! I am Lobby</html>"),
    		new EmailMessageBean("Hi from Craftsmanship", "aaa@bbb.com", 10, "<html>Hi my friend! I am Craftsmanship</html>"),
    		new EmailMessageBean("Hi from Raymondo", "aaa@bbb.com", 6300, "<html>Hi my friend! I am Raymondo</html>")
		);

	private final ObservableList<EmailMessageBean> spam = FXCollections.observableArrayList(
    		new EmailMessageBean("Super extra offer!", "aaa@bbb.com", 5500000, "<html>To earn money fast just click the link!</html>"),
    		new EmailMessageBean("Super extra offer!", "aaa@bbb.com", 5500000, "<html>To earn money fast just click the link!</html>"),
    		new EmailMessageBean("Super extra offer!", "aaa@bbb.com", 5500000, "<html>To earn money fast just click the link!</html>"),
    		new EmailMessageBean("Super extra offer!", "aaa@bbb.com", 5500000, "<html>To earn money fast just click the link!</html>")
		);
	
	public Map<String, ObservableList<EmailMessageBean>> emailFolders = new HashMap<String, ObservableList<EmailMessageBean>>();
	
	public SampleData(){
		emailFolders.put("Inbox", inbox);
		emailFolders.put("Sent", sent);
		emailFolders.put("Spam", spam);
	}
}
