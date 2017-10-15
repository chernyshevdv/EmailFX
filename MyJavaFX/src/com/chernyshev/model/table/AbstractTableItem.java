package com.chernyshev.model.table;

import javafx.beans.property.SimpleBooleanProperty;

public abstract class AbstractTableItem {
	private final SimpleBooleanProperty read = new SimpleBooleanProperty();
	
	public AbstractTableItem(boolean isRead){
		setRead(isRead);
	}
	
	public SimpleBooleanProperty getReadProperty(){
		return this.read;
	}
	
	public void setRead(boolean isRead){
		this.read.set(isRead);
	}
	
	public boolean isRead(){
		return this.read.get();
	}
}
