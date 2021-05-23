package day20210523.dbconnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {
	public static void main(String[] args) {
		
		// try Resource 를 써서 close 를 자동으로 해주자
		try(Connection conn = MyConnection.getConn();
			Statement stmt = conn.createStatement()){
			
			String sql = "insert into mega.books values (0,'달러구트 꿈 백화점',"
					+ "'주문하신 꿈은 매진입니다|이미예 장편소설','이미예', 12420, '2020-07-08', now())";
			
			// 인서트문 실행
			int affectedRows = stmt.executeUpdate(sql);
			
			System.out.println(affectedRows + "줄을 삽입했습니다.");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
