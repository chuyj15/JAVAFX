package application;
	

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			
			Group root = new Group();
			//600,600 : 가로세로 사이즈임. 그래서 setWidth setHeight 쓸필요없음
			Scene scene = new Scene(root,600,600, Color.BLACK);
			stage.setTitle("프로그램 제목");
			
			//씬에 컨트롤 요소 추가하기
			//Text 요소 추가
			Text text = new Text();
			text.setText("Hello Java FX!~~~~");
			text.setX(100);
			text.setY(100);
			text.setFill(Color.LIME);					//글씨 색상 지정
			text.setFont(Font.font("Consolas", 50));  // 글꼴 지정(서체, 크기)
			//getChildren() : 씬의 자식요소들을 가져와서 거기에 텍스트를 추가할수있음
			root.getChildren().add(text);		//루트에 자식으로 텍스트 추가하기
			
			//Line 요소 추가
			Line line = new Line();
			line.setStartX(100);
			line.setStartY(120);
			line.setEndX(480);
			line.setEndY(120);
			line.setStroke(Color.LIME);
			root.getChildren().add(line);
			
			//Line요소 추가 - 대각선
			Line line2 = new Line();
			line2.setStartX(0);
			line2.setStartY(600);
			line2.setEndX(600);
			line2.setEndY(400);
			line2.setStroke(Color.LIME);
			line2.setStrokeWidth(5);
			root.getChildren().add(line2);
			
			//Rectangle 요소 추가
			Rectangle rectangle = new Rectangle();
			rectangle.setX(380);
			rectangle.setY(380);
			rectangle.setWidth(100);
			rectangle.setHeight(100);
			rectangle.setFill(Color.SPRINGGREEN);
			root.getChildren().add(rectangle); //컨테이너에 노드 추가하는거지??
			
			//Circle 요소 추가
			Circle circle = new Circle();
			circle.setCenterX(280);
			circle.setCenterY(280);
			circle.setRadius(50);
			circle.setFill(Color.ORANGE);
			root.getChildren().add(circle);		//컨테이너에 노드 추가하는거지??
			
			//Image 추가
			Image image = new Image("icon.png");
			ImageView imageview = new ImageView(image);
			imageview.setFitWidth(100);
			imageview.setFitHeight(100);
			imageview.setX(180);
			imageview.setY(180);
			root.getChildren().add(imageview);  //컨테이너에 노드 추가하는거지??
			
			
			//프로그램 아이콘 지정하기 
			Image icon = new Image("icon.png");
			stage.getIcons().add(icon);		
			
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
