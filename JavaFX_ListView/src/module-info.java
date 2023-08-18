module JavaFX_Stage {
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires java.base;
	
	opens application to javafx.graphics, javafx.fxml;
}
