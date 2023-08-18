package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {
	//공통적으로 사용할 변수 선언
	private Stage stage;
	private Scene scene;
	
	
	//로그인 화면으로 가기
	public void switchToLogin(ActionEvent event) throws IOException {
//		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));//"Login.fxml"이라는 씬을 읽어와서 씬에다 등록해주면 됨. 
//		scene = new Scene(root);
//		
//		//event로부터 씬을 가져오고, 씬으로부터 스테이지를 가져온다. 
//		stage = (Stage) ( (Node) event.getSource() ).getScene().getWindow();
//		stage.setScene(scene); //로그인 씬으로 지정
//		stage.show();		//화면 출력
		switchScene(event, "Login.fxml");
	}
	
	
	//메인 화면으로 가기
	public void switchToMain(ActionEvent event) throws IOException {
//		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));//"Login.fxml"이라는 씬을 읽어와서 씬에다 등록해주면 됨. 
//		scene = new Scene(root);
//		stage = (Stage) ( (Node) event.getSource() ).getScene().getWindow();
//		stage.setScene(scene); //메인 씬으로 지정
//		stage.show();		//화면 출력
		switchScene(event, "Main.fxml");
	}
	
	//화면이동을 걍 메소드로 설정
	public void switchScene(ActionEvent event, String fxml) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource(fxml));
		scene = new Scene(root);
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
}
