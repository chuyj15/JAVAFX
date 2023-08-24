package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class Main extends Application {
	
	@Override
	public void start(Stage stage) {
		try {
//			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));	//이코드로 fxml을 가져온거임.
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
			Parent root = loader.load();		// 씬 가져옴
			
			//Sub.fxml에 연결된 SubController 가져오기
			Controller controller = loader.getController();
			Scene scene = new Scene(root);
			controller.setScene(scene);
			controller.setEvent();
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//scene의 메소드를 살펴보자
			//(1)키보드 입력 시, 호출할 메소드 지정 (람다식)
//			scene.setOnKeyPressed((KeyEvent event) -> {	
//				KeyCode keyCode = event.getCode();
//				System.out.println(keyCode);
//			});
			
			//(2)키보드 입력 시, 호출할 메소드 지정(메소드 레퍼런스)
			//setOnKeyPressed 메서드를 사용하여 특정 키가 눌렸을 때 호출할 메서드를 지정할 수 있습니다. 
//			scene.setOnKeyPressed( this::keyPress );
			
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	//메소드 정의
//	public void keyPress(KeyEvent event) {
//		// 눌린 키의 코드를 가져옵니다. 
//		//KeyCode 열거형은 키보드 키를 나타내는 상수를 가지고 있습니다.
//		KeyCode keyCode = event.getCode();
//		System.out.println(keyCode);
//	}
}
