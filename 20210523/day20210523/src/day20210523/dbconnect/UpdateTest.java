package day20210523.dbconnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {
	public static void main(String[] args) {
		try(Connection conn = MyConnection.getConn(); 
			Statement stmt = conn.createStatement()){
			
			// 수정 쿼리
			String sql = "Update mega.books set price = 13800 where book_id = 6";
			
			int affectedRows = stmt.executeUpdate(sql);
			
			System.out.println(affectedRows + "줄 수정");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
