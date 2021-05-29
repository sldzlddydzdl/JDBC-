package day20210529;

import java.sql.SQLException;
import java.util.List;

public class SelectListTest {
	
	
	public static void main(String[] args) {
		// 전체조회
		BookDao dao = new BookDao();
		
		try {
			List<BookDto> bookList = dao.selectList();
			
			for(BookDto bookDto : bookList) {
				System.out.println(bookDto);
			}
			
//			2021-05-16 T 10:24:44
//			로 가져와야하는데 디비에서는 해줄수가없다
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
