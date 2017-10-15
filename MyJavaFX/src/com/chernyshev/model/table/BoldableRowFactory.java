package com.chernyshev.model.table;

import javafx.scene.control.TableRow;

public class BoldableRowFactory<T extends AbstractTableItem> extends TableRow<T> {
	@Override
	final protected void updateItem(T item, boolean empty){
		super.updateItem(item, empty);
		
		if (item != null && !item.isRead())
			this.setStyle("-fx-font-weight: bold");
		else
			this.setStyle("");
	}
}
