package com.chernyshev.model;

import javafx.beans.property.SimpleStringProperty;

public class EmailMessageBean {
	private SimpleStringProperty sender;
	private SimpleStringProperty subject;
	private SimpleStringProperty size;
	private String content;
	
	public EmailMessageBean(String subject, String sender, int size, String content){
		this.subject = new SimpleStringProperty(subject);
		this.sender = new SimpleStringProperty(sender);
		this.size = new SimpleStringProperty(formatSize(size));
		this.content = content;
	}

	public String getSender() {
		return sender.get();
	}

	public String getSubject() {
		return subject.get();
	}

	public String getSize() {
		return size.get();
	}
	
	public String getContent(){
		return content;
	}
	
	private static String formatSize(int sz){
		String returnValue;
		
		if (sz<0)
			returnValue = "0 B";
		else if (sz<1024)
			returnValue = sz + " B";
		else if (sz<1048576)
			returnValue = sz/1024 + " kB";
		else 
			returnValue = sz/1048576 + " MB";
		
		return returnValue;
	}
	
	// Inverse transformation
	public static Integer stringSizeToInt(String sz){
		Integer returnValue=0;
		String suffix = sz.substring(sz.length()-2, sz.length()); 
				
		if (suffix.equals(" B"))
			returnValue = new Integer(sz.substring(0, sz.length()-2));
		else if (suffix.equals("kB"))
			returnValue = (new Integer(sz.substring(0, sz.length()-3)))*1024;
		else
			returnValue = (new Integer(sz.substring(0, sz.length()-3)))*1048576;
		
		return returnValue;
	}
}
