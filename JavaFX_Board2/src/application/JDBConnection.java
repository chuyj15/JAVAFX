package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBConnection {		//이걸 직접 사용할게 아니라 직접 사용할 곳에 상속시킬거임!
	// 이 변수들은 데이터베이스 연결 및 쿼리 실행에 사용됩니다.
	
	//java.sql.Connection 인터페이스의 인스턴스
	//데이터베이스와의 연결을 나타내는 객체
	//DriverManager.getConnection() 메소드를 통해 
	//   데이터베이스에 연결하고 얻어온 연결 객체를 저장
	public Connection con; // Connection: 인터페이스
	
	//java.sql.Statement 인터페이스의 인스턴스
	//SQL 문을 실행하는 데 사용되는 객체
	//SQL : (Structured Query Language) :데이터베이스의 모든 작업을 통제하는 비절차적(Non-procedural) 언어
	//정적인(Static) SQL 문을 실행
	public Statement stmt;	//인터페이스
	
	//java.sql.PreparedStatement 인터페이스의 인스턴스
	//미리 준비된 SQL 문을 실행하는 데 사용되는 객체
	//동적으로 파라미터화된 SQL 문을 실행
	//SQL 쿼리에 변수를 바인딩하여 실행
	public PreparedStatement psmt;	//인터페이스
	
	//java.sql.ResultSet 인터페이스의 인스턴스
	//데이터베이스 쿼리 결과를 나타내는 객체
	//SELECT 문을 실행한 후 결과 집합에 대한 데이터를 읽어오는 데 사용됨
	//결과 집합의 데이터를 순차적으로 읽어오거나 처리할 수 있습니다.
	public ResultSet rs;		//인터페이스
	
	//기본 생성자
	public JDBConnection() {
		//JDBC 드라이버 로드
		//MySQL
		try {
			//"com.mysql.cj.jdbc.Driver": MySQL 데이터베이스를 위한 JDBC 드라이버의 클래스 이름
			//Class.forName() : 클래스를 동적으로 로드하는 역할
			Class.forName("com.mysql.cj.jdbc.Driver");
			//DB에 연결
			// url 에는 데이터베이스 종류, 호스트, 포트, 데이터베이스명, 타임존 등의 정보가 포함
			String url = "jdbc:mysql://127.0.0.1:3306/joeun?serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true&useSSL=false";
			String id = "joeun";
			String pw = "123456";
			
			//DriverManager: JDBC 드라이버 관리를 위한 클래스. 데이터베이스와의 연결을 관리하고 드라이버를 등록하는 역할
			//getConnection(url, id, pw): 데이터베이스와의 연결을 설정하는 메소드
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("DB 연결 성공");
		} catch (Exception e) {
			System.err.println("DB 연결 실패");
			e.printStackTrace();
		}
		
		
	}
	
	//이제 이 클래스를 실행시켜야 함. ==>
//	public static void main(String[] args) {
//		JDBConnection jdbc = new JDBConnection();
//	}
	//실질적으로 메인은 다른 클래스에서 사용할거임. 
	
	
}
