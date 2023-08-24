package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SubController  implements Initializable {
	//필드 선언
	@FXML private TextField textName;
	@FXML private TextField textPrice;
	@FXML private TextArea textDescription;
	List<Menu> menuList = new ArrayList<Menu>();
	Menu selectedMenu;
	
	Stage stage;
	Scene scene;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		menuList.add(new Menu("아메리카노", 2000, "신맛 콜롬비아 원두 500ml"));
		menuList.add(new Menu("카페라떼", 3000, "맛있는 카페라떼"));
		menuList.add(new Menu("헤이즐넛", 3500, "Best 메뉴"));
	}
	
	//상품 상세정보 출력
	public void inputItemIndex(int index) {
		System.out.println("넘어온 index: "+index);
		selectedMenu = menuList.get(index);		//메뉴리스트의 인덱스의 요소를 가져옴. 
		textName.setText(selectedMenu.getName()); //그 요소의 이름을 textName에 세팅함. 
		textPrice.setText(selectedMenu.getPrice()+"");
		textDescription.setText(selectedMenu.getDescription());
	}
	
	//목록 버튼 클릭 
	public void clicklist(ActionEvent event) throws IOException {
		FXMLLoader loader = new  FXMLLoader(getClass().getResource("Main.fxml"));
		Parent root = loader.load();
		
		stage = (Stage) ( (Node)  event.getSource() ).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
}