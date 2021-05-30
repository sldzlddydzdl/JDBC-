package marvel_ex;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteTest {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("삭제할 영화의 Id 를 입력해주세요");
		int movieId = Integer.parseInt(sc.nextLine());
		
		try {
			Connection conn = MyConnection.getConn();
			
			MarvelDao marvelDao = MarvelDao.getInstance();
			
			int affectedRow = marvelDao.delete(conn, movieId);
			
			System.out.println(affectedRow + " 열이 삭제되었습니다.");
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
