package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FrontCon implements Initializable{

	public SelectAllDAO sADAO; 
	
	@FXML
	private TableView<Board> colTable;
	
	 @FXML
	    private TableColumn<Board, Integer> colNo;

	 @FXML
	 private TableColumn<Board, String> colTitle;
	 
	 @FXML
	 private TableColumn<Board, String> colWriter;
	 
	    @FXML
	    private TableColumn<Board, String> colReg;

	    @FXML
	    private TableColumn<Board, String> colUpd;
	    
	    List<Board> tempBoardList = new ArrayList<>();

	public void temp(ActionEvent event) {
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		tempBoardList.addAll(sADAO.selectAll());		
		
		ObservableList<Board> list = FXCollections.observableArrayList(tempBoardList);
		colTable.setItems(list);
		
		colNo.setCellValueFactory(new PropertyValueFactory<>("BoardNo"));
		colTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
		colWriter.setCellValueFactory(new PropertyValueFactory<>("Writer"));
		colReg.setCellValueFactory(new PropertyValueFactory<>("RegDate"));
		colUpd.setCellValueFactory(new PropertyValueFactory<>("UpdDate"));
		
		
	}
	
	
}
