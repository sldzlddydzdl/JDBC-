package marvel_ex;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SelectTest {
	
	
	public static void main(String[] args) {
		//전체 조회
		try(Connection conn = MyConnection.getConn()){
			
			MarvelDao marvelDao = MarvelDao.getInstance();
			
			List<MarvelDto> movieList = marvelDao.select(conn);
			
			for(MarvelDto dto : movieList) {
				System.out.println(dto);
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
