package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller implements Initializable{
	
	@FXML
	private TableView<Board> boardTableView;
    @FXML
    private TableColumn<Board, Integer> colBoardNo;
    @FXML
    private TableColumn<Board, String> colTitle;
    @FXML
    private TableColumn<Board, String> colWriter;
    @FXML
    private TableColumn<Board, String> colRegDate;
    @FXML
    private TableColumn<Board, String> colUpdDate;
	
	//이니셜라이저블 메서드
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Board board1 = new Board(1, "제목1", "작성자1", "내용1","2023-08-18","2023-08-18");
		Board board2 = new Board(2,"제목2", "작성자2", "내용2","2023-08-18","2023-08-18");
		Board board3 = new Board(3,"제목3", "작성자3", "내용3","2023-08-18","2023-08-18");
		ArrayList<Board> boardList = new ArrayList<Board>();
		boardList.add(board1);
		boardList.add(board2);
		boardList.add(board3);
		
		//ObservableList는 JavaFX에서 제공하는 데이터 구조 중 하나로, 변경 가능한 리스트를 나타냅니다. 
		//FXCollections.observableArrayList(...) 메서드는 
		//			주어진 요소들을 포함하는 새로운 ObservableList 인스턴스를 생성합니다
		ObservableList<Board> list = FXCollections.observableArrayList(
//			board1, board2, board3
			boardList
		);
		
		//TableColumn에 열과 추가할 아이템 객체의 게터 이름 지정하기.
		// - setCellValueFactory : cell에 들어갈 값을 지정하는 메소드
		// 			- 이 안에 객체로는 new PropertyValueFactory<>() 를 넣어줌. 
		// - new PropertyValueFactory<>("게터이름")
		// * 게터이름 : get을 제외한 게터 메소드의 이름
		//ex) getBoardNo --> BoardNo
		//※ module-info.java --> java.base 모듈 추가
		//PropertyValueFactory : JavaFX에서 제공하는 데이터 바인딩을 위한 유틸리티 클래스
		//							컬럼과 데이터 객체의 속성을 연결
		colBoardNo.setCellValueFactory(new PropertyValueFactory<>("BoardNo"));
		colTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
		colWriter.setCellValueFactory(new PropertyValueFactory<>("Writer"));
		colRegDate.setCellValueFactory(new PropertyValueFactory<>("RegDate"));
		colUpdDate.setCellValueFactory(new PropertyValueFactory<>("UpdDate"));
		
		//TableView  에 데이터 리스트를 지정
		// - 미리 매핑된 TableColumn 에 리스트의 요소 객체의 변수값이 getter로 가져와서 
		boardTableView.setItems(list);
	}
	
}
