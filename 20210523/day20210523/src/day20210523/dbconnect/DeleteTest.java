package day20210523.dbconnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest {
	public static void main(String[] args) {
		try(Connection conn = MyConnection.getConn();
			Statement stmt = conn.createStatement()){
			
			String sql = "delete from mega.books where book_id = 6";
			
			int affectedRows = stmt.executeUpdate(sql);
			System.out.println(affectedRows+ "줄 삭제");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

// day0523_ex 프로젝트 생성해서 
// books 테이블에 조회, 삽입, 삭제, 수정을 할 수 있도록 클래스를 각각 구현
// 전체조회 : 사용자로부터 가져올 row수를 입력받아 해당되는 갯수만큼 춫ㄹ력
// 책조회 : 사용자로부터 책 제목을 입력받아 해당되는 단어가 들어간 책을 출력
// 삽입 : 사용자로부터 책 정보를 입력받아 디비에 삽입하도록 ㄱ현
// 수정 : 사용자로부터 책 정보를 입력받아 해당되는 책을 수정하도록 구현
// 삭제 : 사용자로부터 책 id 를 입력받아 해당되는 책을 삭제하도록 구현 

