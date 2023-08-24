package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainController implements Initializable{
	static ArrayList<Board> boardList = new ArrayList<>();	//게시글 전체에서 사용할 수 있는 배열
	static Scanner sc = new Scanner(System.in);
	static DataAccess data = new DataAccess();
	Parent root;
	Stage stage;
	Scene scene;
	
    @FXML
    private TableView<Board> boardTableView;
    @FXML
    private TableColumn<Board, Integer> colBoardNo;
    @FXML
    private TableColumn<Board, String> colRegDate;
    @FXML
    private TableColumn<Board, String> colTitle;
    @FXML
    private TableColumn<Board, String> colUpdDate;
    @FXML
    private TableColumn<Board, String> colWriter;
    @FXML
    private Button writeButton;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//보드 객체 가져오기 
		boardList = data.selectList();
		ObservableList<Board> list = FXCollections.observableArrayList(
				boardList
			);
		colBoardNo.setCellValueFactory(new PropertyValueFactory<>("BoardNo"));
		colTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
		colWriter.setCellValueFactory(new PropertyValueFactory<>("Writer"));
		colRegDate.setCellValueFactory(new PropertyValueFactory<>("RegDate"));
		colUpdDate.setCellValueFactory(new PropertyValueFactory<>("UpdDate"));
		
		boardTableView.setItems(list);
		
		
		
		
		boardTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				//더블 클릭 이벤트 -->아이템라벨에 표시해주고, 인덱스넘기고, 화면넘기기까지 함. 
				if (event.getClickCount()==2) {
					System.out.println("더블 클릭!!");
					// getSelectionModel(): 선택 모델은 현재 선택된 아이템을 추적하고 관리하는 객체
					//사실 밑에 두개는 필요없을 거  같음. 더블클릭했을 때만 하는 거니까. 
//					selectedItem = listView.getSelectionModel().getSelectedItem();
//					itemLabel.setText(selectedItem);
//					System.out.println("선택한 아이템: "+ selectedItem);
					
					stage = (Stage) ( (Node)  event.getSource() ).getScene().getWindow();
					int index = boardTableView.getSelectionModel().getSelectedIndex();
					
					//Sub씬을 가져오기. 
					FXMLLoader loader = new FXMLLoader(getClass().getResource("Seefxml.fxml"));
					try {
						root = loader.load();	//load()메소드를 호출해야 loader에 Sub씬 인스턴스를 가져온다.
										//호출해야 Controller 도 null이 되지 않는다. 
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					//Sub.fxml에 연결된 SubController 가져오기.
					//왜 가져왔냐면, SubController클래스에 있는 inputItemIndex 메소드를 사용하기 위해서 인 것 같음.~!~!~
					SeefxmlController seefxmlController = loader.getController();
					if (seefxmlController !=null) {
						//inputItemIndex 메소드 정의
						seefxmlController.inputItemIndex(index);
					}
				
					//화면 이동
					switchScene(stage, root, "Sub.fxml");
				}
			}
		});
	}
	
	//게시물쓰기버튼 클릭할 때 실행할 메소드
	public void clickwriteButton(ActionEvent event) throws IOException {
		stage = (Stage) ( (Node)  event.getSource() ).getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Writefxml.fxml"));
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if( root == null )
			return;
		
		//화면 이동
		switchScene(stage, root, "Writefxml.fxml");
	}
	
	
	//화면이동을 걍 메소드로 설정
	public void switchScene( Stage stage, Parent root, String fxml ) {
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());		stage.setScene(scene);
		stage.show();
	}
}
