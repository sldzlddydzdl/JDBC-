package day0523_ex;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//삭제 : 사용자로부터 책 id 를 입력받아 해당되는 책을 삭제하도록 구현 
public class delete {
	public static void main(String[] args) {
		try(Connection conn = DBConnect.Conn();
			Statement stmt = conn.createStatement()){
			
			Scanner sc = new Scanner(System.in);
			System.out.println("삭제할 book_id 를 입력해주세요 : ");
			int num = sc.nextInt();
			
			String sql = "delete from books where book_id = " + num + "";
			
			stmt.executeUpdate(sql);
			
			System.out.println("book_id = " + num + " 정보가 삭제되었습니다.");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
