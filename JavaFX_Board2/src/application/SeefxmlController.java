package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SeefxmlController implements Initializable {
	static ArrayList<Board> boardList = new ArrayList<>();	//게시글 전체에서 사용할 수 있는 배열
	static Scanner sc = new Scanner(System.in);
	static DataAccess data = new DataAccess();
	int indexx;
	Parent root;
	Stage stage;
	Scene scene;
	 	@FXML
	    private TextArea contentSee;
	    @FXML
	    private Button gotolistButton;
	    @FXML
	    private Button delButton;
	    @FXML
	    private TextField noSee;
	    @FXML
	    private TextField regdateSee;
	    @FXML
	    private TextField titleSee;
	    @FXML
	    private Button updButton;
	    @FXML
	    private TextField upddateSee;
	    @FXML
	    private TextField writeSee;
	    
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			//보여주기
			boardList = data.selectList();
		}
		
		//상품 상세정보 출력
		public void inputItemIndex(int index) {
			System.out.println("넘어온 index: "+index);
			indexx=index;
			Board selectedBoard = boardList.get(index);		//메뉴리스트의 인덱스의 요소를 가져옴. 
			noSee.setText(selectedBoard.getBoardNo() +"");
			titleSee.setText(selectedBoard.getTitle()); //그 요소의 이름을 textName에 세팅함. 
			writeSee.setText(selectedBoard.getWriter());
			upddateSee.setText(selectedBoard.getUpdDate()+"");
			regdateSee.setText(selectedBoard.getRegDate()+"");
			contentSee.setText(selectedBoard.getContent());
		}
		
		//수정 버튼 클릭 
		public void clickUpdButton(ActionEvent event) throws IOException {
			String title = titleSee.getText();
			String content = contentSee.getText();
			String writer = writeSee.getText();
			Board board = new Board(title, content, writer);
			Board board1 = boardList.get(indexx);
			int boardNo =board1.getBoardNo();
			board.setBoardNo(boardNo);
			int result = data.update(board);
			
			if (result>0) {
				System.out.println("게시글이 수정되었습니다.");
				
			}
			stage = (Stage) ( (Node)  event.getSource() ).getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
			try {
				root = loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			switchScene(stage, root, "Main.fxml");
		}
		
		
		//삭제 버튼 클릭 
		public void clickDelButton(ActionEvent event) throws IOException {
			System.out.println("넘어온 index: "+indexx);
			Board board = boardList.get(indexx);
			int boardNo =board.getBoardNo();
			int result = data.delete(boardNo);
			if (result>0) {
				System.out.println("게시글이 삭제되었습니다.");
			} else {
				System.out.println("게시글이 삭제되지 않았습니다.");
			}
			stage = (Stage) ( (Node)  event.getSource() ).getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
			try {
				root = loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			switchScene(stage, root, "Main.fxml");
		}
		
		//목록으로 이동
		public void gotolistButton(ActionEvent event) throws IOException {
			stage = (Stage) ( (Node)  event.getSource() ).getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
			try {
				root = loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			switchScene(stage, root, "Main.fxml");
		}
		
		//화면이동을 걍 메소드로 설정
		public void switchScene( Stage stage, Parent root, String fxml ) {
			scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		}
		
}
