package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	// start 메서드 내부에서 UI 구성 요소를 생성하고 화면에 표시하는 등의 작업을 수행
	public void start(Stage stage) {
		try {
			//FXML 파일을 로드하여 UI 계층 구조를 생성
			// root : 화면레이아웃 -- 여기에 각종 Pane 및 컨트롤을 추가함. 
			//FXMLLoader.load() 메서드는 FXML 파일을 로드하여 UI 계층 구조를 생성하는 역할
			// "Main.fxml" 파일을 로드하려는 것
			//Parent root = 생성된 UI 계층 구조를 나타내는 Parent 클래스의 객체에 할당
			//Parent 클래스는 UI 계층 구조의 최상위 컨테이너
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			//이렇게 생성된 root 객체는 JavaFX의 Scene에 추가되어 화면에 표시될 준비가 됩니다. 
			
			//UI 계층 구조를 포함하는 씬(Scene)을 생성
			//씬:  Pane을 담는 프레임으로 화면에 보이지 않는 틀. 화면설정가능
			Scene scene = new Scene(root);
			// 해당 씬에 스타일 시트(CSS)를 추가
			
			//add(getClass().getResource("application.css").toExternalForm());
			//			: "application.css" 파일의 경로를 가져오고, 이를 외부 형식의 URL 문자열로 변환하는 역할
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//주어진 씬을 스테이지(Stage)에 설정
			stage.setScene(scene);
			// 윈도우를 보여주는 역할
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	//JavaFX 애플리케이션을 실행하기 위한 메인 메서드
	public static void main(String[] args) {
		//Stage 객체 생성 및 main 윈도우 생성의 역할
		launch(args);
	}
}
