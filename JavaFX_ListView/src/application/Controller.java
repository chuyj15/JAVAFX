package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller implements Initializable {
	
	@FXML
	private Label itemLabel;

	@FXML
	private ListView<String> listView;
	
	String[] menuList = {"아메리카노","카페라떼","헤이즐넛"};
	String selectedItem;
	Parent root;
	Stage stage;
	Scene scene;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//데이터를 리스트뷰에 추가
		listView.getItems().addAll(menuList);
		
		
		//궁금한 거: 왜 이니셜라이즈 메소드에 이 이벤트를 추가한거지??
		
		//마우스클릭 이벤트
		listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				//더블 클릭 이벤트
				if (event.getClickCount()==2) {
					System.out.println("더블 클릭!!");
					// getSelectionModel(): 선택 모델은 현재 선택된 아이템을 추적하고 관리하는 객체
					selectedItem = listView.getSelectionModel().getSelectedItem();
					itemLabel.setText(selectedItem);
					System.out.println("선택한 아이템: "+ selectedItem);
					
					stage = (Stage) ( (Node)  event.getSource() ).getScene().getWindow();
					
					//메뉴 아이템의 번호 넘기기
					//아메리카노(0)
					//카페라떼(1)
					//헤이즐넛(2)
					//현재 선택된 아이템의 인덱스를 가져오는 역할을 함. 
					int index = listView.getSelectionModel().getSelectedIndex();
					
					//Sub씬을 가져오기. 
					FXMLLoader loader = new FXMLLoader(getClass().getResource("Sub.fxml"));
					try {
						root = loader.load();	//load()메소드를 호출해야 loader에 Sub씬 인스턴스를 가져온다.
										//호출해야 Controller 도 null이 되지 않는다. 
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					//Sub.fxml에 연결된 SubController 가져오기.
					//왜 가져왔냐면, SubController클래스에 있는 inputItemIndex 메소드를 사용하기 위해서 인 것 같음.~!~!~
					SubController subController = loader.getController();
					
					if (subController !=null) {
						//inputItemIndex 메소드 정의
						subController.inputItemIndex(index);
					}
					//화면 이동
					switchScene(stage, root, "Sub.fxml");
				}
			}
		});
		
		//리스트뷰 아이템 선택 이벤트
		//내가 선택한 '아메리카노'를 itemLabel 이라는 라벨에 텍스트를 띄워줄거임.
		//addListener(): 발생한 이벤트에 따라 처리한 작업을 연결해줌 
		//ChangeListener 가 인터페이스기 때문에 changed라는 메소드를 구현해줘야 함. 
		listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			//익명구현객체를 생성한거임
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				//현재 선택한 아이템을 itemLabel에 텍스트로 지정
				selectedItem = listView.getSelectionModel().getSelectedItem();
				itemLabel.setText(selectedItem);
			}
		});
	}
	
	
	//화면이동을 걍 메소드로 설정
		public void switchScene(Stage stage,  Parent root, String fxml) {
//			try {
//				FXMLLoader loader = new  FXMLLoader(getClass().getResource("fxml"));
//				Parent root = loader.load();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
//			} catch (IOException e) {
//				System.out.println("화면이동을 할 수 없습니다.");
//				e.printStackTrace();
//			}
		}
	
}
