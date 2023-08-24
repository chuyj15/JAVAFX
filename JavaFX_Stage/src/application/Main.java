package application;
	
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			
			//그래픽 요소들을 담기 위한 컨테이너인 Group을 생성하는 부분
			//Group 컨테이너는 레이아웃을 관리하지 않고, 그저 그래픽 요소들을 자유롭게 배치하는 역할을 수행
			Group root = new Group();	//이거 컨데이너인가??....
			Scene scene = new Scene(root, Color.BLACK);
			stage.setTitle("프로그램 제목");
			stage.setWidth(420);
			stage.setHeight(420);
			//처음 뜰 때 위치 지정
//			stage.setX(500);
//			stage.setY(500);
			
			//프로그램 아이콘 지정하기 
			Image icon = new Image("icon.png");
			stage.getIcons().add(icon);
			
			//리사이징 여부 지정하기
			stage.setResizable(false);
			
			//전체화면 여부 지정하기
			stage.setFullScreen(true);
			//전체화면 종료키 설정
			stage.setFullScreenExitHint("전체 화면 종료: (X 키를 누르세요)");
			stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("X"));
		
			//스테이지에 씬 지정하고 화면에 출력하기
			stage.setScene(scene);
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
