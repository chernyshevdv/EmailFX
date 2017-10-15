package com.chernyshev.controller;

import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import com.chernyshev.model.EmailMessageBean;
import com.chernyshev.model.ModelAccess;
import com.chernyshev.model.SampleData;
import com.chernyshev.model.table.BoldableRowFactory;
import com.chernyshev.view.ViewFactory;

public class MainController extends AbstractController implements Initializable {

	public MainController(ModelAccess modelAccess) {
		super(modelAccess);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ViewFactory viewFactory = ViewFactory.getInstance();
		emailTableView.setRowFactory(e->new BoldableRowFactory<>());
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
		TreeItem<String> inbox = new TreeItem<String>("Inbox", viewFactory.resolveIcon("Inbox"));
		TreeItem<String> sent = new TreeItem<String>("Sent", viewFactory.resolveIcon("Sent"));
			TreeItem<String> subitem1 = new TreeItem<String>("Subitem1", viewFactory.resolveIcon("Subitem1"));
			TreeItem<String> subitem2 = new TreeItem<String>("Subitem2", viewFactory.resolveIcon("Subitem2"));
			inbox.getChildren().addAll(subitem1, subitem2);
		TreeItem<String> spam = new TreeItem<String>("Spam", viewFactory.resolveIcon("Spam"));
		TreeItem<String> trash = new TreeItem<String>("Trash", viewFactory.resolveIcon("Trash"));
		
		root.getChildren().addAll(inbox, sent, spam, trash);
		root.setExpanded(true);
		root.setGraphic(viewFactory.resolveIcon(root.getValue()));
		
		emailTableView.setContextMenu(new ContextMenu(showDetails));
		
		emailFoldersTreeView.setOnMouseClicked(e->{
			TreeItem<String> item = emailFoldersTreeView.getSelectionModel().getSelectedItem();
			if (item != null)
				emailTableView.setItems(sampleData.emailFolders.get(item.getValue()));
		});
		
		emailTableView.setOnMouseClicked(e->{
			EmailMessageBean message = emailTableView.getSelectionModel().getSelectedItem();
			getModelAccess().setMessage(message);
			if (message != null)
				messageRenderer.getEngine().loadContent(message.getContent());
		});
		
		showDetails.setOnAction(e->{
			try {
				Scene scene = viewFactory.getMessageDetailsScene();
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.show();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		});
		
		
		System.out.println("MainController initialzed");
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
