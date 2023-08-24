package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
			
			//setOnCloseRequest 메서드는 윈도우(스테이지)가 닫힐 때 호출되는 이벤트 핸들러를 설정합니다.
			//닫기 버튼 X 클릭 시, exit() 메소드 호출되도록 지정
			stage.setOnCloseRequest(event -> { //닫기 요청했을 때 어떤 메소드를 실행해줄 것이냐 ()
				//이 코드는 기존의 닫기 이벤트를 소멸시키기 위해 사용됩니다. 이벤트를 소멸시킴으로써 기본적인 윈도우 닫기 동작(프로그램 종료)을 막을 수 있습니다. 
				event.consume(); 		//기존 이벤트(프로그램 종료)를 제거. consume "소멸시키다"
				exit(stage);
			});		
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	public void exit(Stage stage) {
		//경고창	
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("프로그램 종료");
		alert.setHeaderText("정말로 종료하시겠습니까?");
		alert.setContentText("프로그램이 종료됩니다.");
		
		//[확인] 클릭 시
		//alert.showAndWait()는 JavaFX에서 Alert 다이얼로그를 표시하고 사용자의 응답을 기다리는 메서드입니다. 
		//이 메서드를 호출하면 경고창이 화면에 표시되고, 사용자가 확인 버튼이나 다른 버튼을 클릭할 때까지 프로그램의 실행이 일시 정지됩니다.
		if (alert.showAndWait().get() == ButtonType.OK ) {
			System.out.println("프로그램을 종료합니다.");
			stage.close(); //(1)프로그램종료방법
//			System.exit(0); //(2)프로그램종료방법
		}
	}
}