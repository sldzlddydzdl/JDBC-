package day0523_ex;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import day20210523.dbconnect.MyConnection;

public class Update {
	
	public static void main(String[] args) {
		try(Connection conn = DBConnect.Conn();
				Statement stmt = conn.createStatement()){
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("수정할 컬럼 번호를 입력해주세요");
			int num = sc.nextInt();
			sc.nextLine();
			System.out.println("책 제목을 입력해주세요 : ");
			String title = sc.nextLine();
			System.out.println("책 서브제목을 입력해주세요 : ");
			String sub_title = sc.nextLine();
			System.out.println("책 작성자 를 입력해주세요 : ");
			String publisher = sc.nextLine();
			
			
			System.out.println("책 가격을 입력해주세요 : ");
			int price = sc.nextInt();
			
			String sql = "update books set title = '"+title+ "', sub_title = '" + sub_title + "', publisher = '"+publisher + 
					"', price = " + price + " where book_id = " + num +""; 
			
			System.out.println(sql);
			
			stmt.executeUpdate(sql);
			System.out.println("book_id = " + num + "의 데이터가 수정되었습니다.");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
