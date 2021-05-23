package day0523_ex;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Insert {

	public static void main(String[] args) {
		try(Connection conn = DBConnect.Conn();
			Statement stmt = conn.createStatement()){
			
			Scanner sc = new Scanner(System.in);
			System.out.println("책 제목을 입력해주세요 : ");
			String title = sc.nextLine();
			System.out.println("책 서브제목을 입력해주세요 : ");
			String sub_title = sc.nextLine();
			System.out.println("책 작성자 를 입력해주세요 : ");
			String publisher = sc.nextLine();
			System.out.println("책 가격을 입력해주세요 : ");
			int price = sc.nextInt();
			System.out.println("책 날짜를 입력해주세요 : ");
			String Date = sc.next();
			
			String sql = "insert into books values ( 0, '" +title + "', '" + sub_title + "', '" + publisher + "'," + price + ",'" + Date + "', now())";
			
			int row = stmt.executeUpdate(sql);
			System.out.println(row + " 줄 만큼 정보 입력");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
