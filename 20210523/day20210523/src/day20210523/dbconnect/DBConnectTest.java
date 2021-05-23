package day20210523.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectTest {
	public static void main(String[] args) {
		
		
		// 디비연동 테스트 
		try {
			// 디비에 접속하기 위한 Driver 클래스를 로드
			Class.forName("com.mysql.cj.jdbc.Driver"); // 없는 클래스를 노드할수 있으니 try catch로묶기
			
			// mysql에 접속하기 위한 게정을 준비한다
			String user = "root";
			String password = "1234"; // 얼래는이렇게 안한다.
			
			// mysql에 접속하는 url을 셋팅
			// 프로토콜://아이피주소:포트번호/데이타베이스이름?파라미터
			String url = "jdbc:mysql://localhost:3306/sakila?characterEncoding=utf-8&serverTimezone=Asia/Seoul";
			
			// 디비에 접속할 준비가 끝
			// 디비에 접속을 해서, 접속된 커넥션 객체를 받아온다.
			Connection conn = DriverManager.getConnection(url, user, password);
			
			System.out.println("커넥션 객체 : " +conn);
			
		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
