package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController {
	
	@FXML
	private TextField textName;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void inputName(ActionEvent event) throws Exception {
		String name = textName.getText();
		
		// Sub.fxml 읽어오기	
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Sub.fxml"));
		root = loader.load();		//Sub 씬 가져옴
		
		//Sub.fxml에 연결된 SubController 가져오기
		SubController subController = loader.getController();
		subController.printName(name);		//SubController를 통해서 Main 씬에서 입력한 name(이름)을 Sub 씬에 넘김
		
		//Main -> Sub 화면 전환
		//(Node) event.getSource() : 이벤트의 발생원인이 되는 UI 요소(예: 버튼)를 나타내는 Node 객체를 가져옵니다. //원래반환타입: Object
		//getScene() : UI 요소가 속한 Scene 객체를 가져옵니다. 
		//getWindow(): 해당 Scene 객체가 속한 Window 객체를 가져옵니다.  //Window는 일반적으로 Stage를 의미하며, 화면 창을 나타냅니다.
		//(Stage) : 앞서 가져온 Window 객체를 형변환하여 실제 Stage 객체로 변환합니다. 
		stage = (Stage) ( (Node) event.getSource() ).getScene().getWindow();
		
		//이 Scene 객체는 "Sub" 화면에 대한 씬을 정의하게 됩니다.
		scene = new Scene(root);
		//앞서 가져온 Scene 객체를 현재 Stage에 설정하여 "Sub" 화면으로 전환될 수 있도록 합니다.
		stage.setScene(scene);
		//show() 메서드를 호출하면 새 화면이 보여집니다.
		stage.show();
		
	}
	
	
	
}
