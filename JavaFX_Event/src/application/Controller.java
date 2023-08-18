package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

public class Controller {
	
	@FXML    //어노테이션 붙여주면 그 요소를 가져올 수 있음. 
		   	//fxml의 요소와 자동 연결
	private Circle circle; // Main.fxml의 컨트롤 요소의 fx:id="circle" 과 변수명 일치
	
	private double x;	//x=0.0
	private double y;	//y=0.0
	
	
	
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
}
