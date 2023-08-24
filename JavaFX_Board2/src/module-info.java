//모듈시스템이란?
//자바 애플리케이션을 더 구조화하고 모듈 간의 의존성과 가시성을 관리하는 도구
//모듈: 클래스, 인터페이스, 리소스, 설정 파일 등을 하나의 단위로 묶은 것
//   :즉 애플리케이션의 구성 요소를 더 작은 단위로 나눈 것


module JavaFX_Stage {
	//현재 모듈이 "javafx.controls" 모듈에 의존함
	//현재 모듈은 "javafx.controls" 모듈의 클래스와 리소스에 접근할 수 있습니다.
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	// "application" 패키지를 열어서 
	//"javafx.graphics" 모듈과 "javafx.fxml" 모듈에서 
	//해당 패키지의 클래스에 접근할 수 있도록 합니다. 
	opens application to javafx.base, javafx.graphics, javafx.fxml;
}
