package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Writefxml {
	static DataAccess data = new DataAccess();
	Parent root;
	Stage stage;
	Scene scene;
    @FXML
    private TextField contentWrite;
    @FXML
    private TextField titleWrite;
    @FXML
    private Button writeDoneBut;
    @FXML
    private TextField writerWrite;
	
	
    
    public void clickWriteDoneBut(ActionEvent event) throws IOException {
    	System.out.println("쓰기완료버튼 클릭");
    	String title = titleWrite.getText();
    	String writer = writerWrite.getText();
    	String content = contentWrite.getText();
    	
    	Board board = new Board(title, writer, content);
    	int result = data.insert(board);
		if (result>0) {
			System.out.println("게시글이 작성되었습니다.");
		} 
		stage = (Stage) ( (Node)  event.getSource() ).getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		switchScene(stage, root, "Main.fxml");
    }
    
    
    public void switchScene( Stage stage, Parent root, String fxml ) {
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
}
