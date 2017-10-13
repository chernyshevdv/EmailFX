package com.chernyshev;

import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.web.WebView;

public class MainController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		messageRenderer.getEngine().loadContent("<html><body>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of de Finibus Bonorum et Malorum (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, Lorem ipsum dolor sit amet.., comes from a line in section 1.10.32.</body></html>");
		subjectCol.setCellValueFactory(new PropertyValueFactory<EmailMessageBean, String>("subject"));
		senderCol.setCellValueFactory(new PropertyValueFactory<EmailMessageBean, String>("sender"));
		sizeCol.setCellValueFactory(new PropertyValueFactory<EmailMessageBean, String>("size"));
		
		emailTableView.setItems(data);
		
		sizeCol.setComparator(new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				Integer i1, i2;
				
				i1 = EmailMessageBean.stringSizeToInt(o1);
				i2 = EmailMessageBean.stringSizeToInt(o2);
				
				System.out.println(String.format("Comparing %s (%d) to %s (%d) yields %d", o1, i1, o2, i2, i1.compareTo(i2)));
				
				return i1.compareTo(i2);
			}
			
		});
	}
	

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
    
    final ObservableList<EmailMessageBean> data = FXCollections.observableArrayList(
    		new EmailMessageBean("Hello from Bobby", "aaa@bbb.com", 5500000),
    		new EmailMessageBean("Hello from Lobby", "aaa@bbb.ie", 200),
    		new EmailMessageBean("Hello from Craftsmanship", "aaa@bbb.com", 10),
    		new EmailMessageBean("Hello from Raymondo", "aaa@bbb.com", 6300)
    		);

}
