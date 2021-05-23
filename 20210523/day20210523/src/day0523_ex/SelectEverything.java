package day0523_ex;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Scanner;

public class SelectEverything {

	public static void main(String[] args) {
		
		ResultSet rs = null;
		
		try(Connection conn = DBConnect.Conn();
			Statement stmt = conn.createStatement()){
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("몇개를 조회할 것인가요 : ");
			int num = sc.nextInt();
			
			String sql = "select * from books limit " + num +" ";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int book_id = rs.getInt(1);
				String title = rs.getString(2);
				String sub_title = rs.getString(3);
				String publisher = rs.getString(4);
				int price = rs.getInt(5);
				LocalDateTime publication_date = rs.getTimestamp(6).toLocalDateTime();
				System.out.println(book_id + ", " + title + ", " + sub_title + ", " + publisher + ", " + price + ", " + publication_date);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				if(rs != null)
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
