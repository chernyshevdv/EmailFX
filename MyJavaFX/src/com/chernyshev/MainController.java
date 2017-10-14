package com.chernyshev;

import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebView;

public class MainController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//messageRenderer.getEngine().loadContent("<html><body>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of de Finibus Bonorum et Malorum (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, Lorem ipsum dolor sit amet.., comes from a line in section 1.10.32.</body></html>");
		subjectCol.setCellValueFactory(new PropertyValueFactory<EmailMessageBean, String>("subject"));
		senderCol.setCellValueFactory(new PropertyValueFactory<EmailMessageBean, String>("sender"));
		sizeCol.setCellValueFactory(new PropertyValueFactory<EmailMessageBean, String>("size"));
		
		// emailTableView.setItems(data);
		
		sizeCol.setComparator(new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				Integer i1, i2;
				
				i1 = EmailMessageBean.stringSizeToInt(o1);
				i2 = EmailMessageBean.stringSizeToInt(o2);
				
				return i1.compareTo(i2);
			}
			
		});
		
		
		emailFoldersTreeView.setRoot(root);
		TreeItem<String> inbox = new TreeItem<String>("Inbox", resolveIcon("Inbox"));
		TreeItem<String> sent = new TreeItem<String>("Sent", resolveIcon("Sent"));
			TreeItem<String> subitem1 = new TreeItem<String>("Subitem1", resolveIcon("Subitem1"));
			TreeItem<String> subitem2 = new TreeItem<String>("Subitem2", resolveIcon("Subitem2"));
			inbox.getChildren().addAll(subitem1, subitem2);
		TreeItem<String> spam = new TreeItem<String>("Spam", resolveIcon("Spam"));
		TreeItem<String> trash = new TreeItem<String>("Trash", resolveIcon("Trash"));
		
		root.getChildren().addAll(inbox, sent, spam, trash);
		root.setExpanded(true);
		root.setGraphic(resolveIcon(root.getValue()));
		
		emailTableView.setContextMenu(new ContextMenu(showDetails));
		
		emailFoldersTreeView.setOnMouseClicked(e->{
			TreeItem<String> item = emailFoldersTreeView.getSelectionModel().getSelectedItem();
			if (item != null)
				emailTableView.setItems(sampleData.emailFolders.get(item.getValue()));
		});
		
		emailTableView.setOnMouseClicked(e->{
			EmailMessageBean message = emailTableView.getSelectionModel().getSelectedItem();
			if (message != null)
				messageRenderer.getEngine().loadContent(message.getContent());
		});
		
		showDetails.setOnAction(e->{
			System.out.println("menu item clicked.");
		});
		
		
		System.out.println("MainController initialzed");
	}
	
	private Node resolveIcon(String treeItemValue){
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
	
	@FXML 
	private TreeView<String> emailFoldersTreeView;
	private TreeItem<String> root = new TreeItem<String>("anemail@gmail.com");
	private SampleData sampleData = new SampleData();
	MenuItem showDetails = new MenuItem("show details");

    @FXML
    private TableView<EmailMessageBean> emailTableView;

	@FXML
    private TableColumn<EmailMessageBean, String> subjectCol;

    @FXML
    private TableColumn<EmailMessageBean, String> senderCol;

    @FXML
    private TableColumn<EmailMessageBean, String> sizeCol;

    @FXML
    private WebView messageRenderer;
	
    @FXML
    private Button Button1;

    @FXML
    void Button1Action(ActionEvent event) {
    	System.out.println("Button1 is clicked.");
    }
    

}
