package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;

public class Controller implements Initializable {
	
	@FXML    //어노테이션 붙여주면 그 요소를 가져올 수 있음. 
		   	//fxml의 요소와 자동 연결
	private Circle circle; // Main.fxml의 컨트롤 요소의 fx:id="circle" 과 변수명 일치
	
	private double x;	//x=0.0
	private double y;	//y=0.0
	
	Scene scene;
	
	
	//메소드를 정의해줄거임
	public void up(ActionEvent event) {
		//동그라미를 위로 이동
//		System.out.println(circle.getCenterX()); //0.0
//		System.out.println(circle.getCenterY()); //0.0
		circle.setCenterY(y-=10);
		System.out.println("UP");
	}
	public void down(ActionEvent event) {
		System.out.println("DOWN");
		circle.setCenterY(y+=10);
	}
	public void left(ActionEvent event) {
		circle.setCenterX(x-=10);
		System.out.println("LEFT");
	}
	public void right(ActionEvent event) {
		circle.setCenterX(x+=10);
		System.out.println("RIGHT");
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		System.out.println("체크");
		// TODO Auto-generated method stub
//		try {
//			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
//			Scene scene = new Scene(root);
//			scene.setOnKeyPressed( this::keyPress );
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	public void keyPress(KeyEvent event) {
		// 눌린 키의 코드를 가져옵니다. 
		//KeyCode 열거형은 키보드 키를 나타내는 상수를 가지고 있습니다.
		KeyCode keyCode = event.getCode();
		System.out.println(keyCode);
		
		switch (keyCode.toString()) {
		case "UP": circle.setCenterY(y-=10); break;
		case "DOWN": circle.setCenterY(y+=10); break;
		case "LEFT": circle.setCenterX(x-=10); break;
		case "RIGHT": circle.setCenterX(x+=10); break;

		default:
			break;
		}
		
		
	}
	public Scene getScene() {
		return scene;
	}
	public void setScene(Scene scene) {
		System.out.println("체크2");
		this.scene = scene;
	}
	
	public void setEvent() {
		if( scene != null ) {
			scene.setOnKeyPressed( this::keyPress );
		}
	}
	
	
}
