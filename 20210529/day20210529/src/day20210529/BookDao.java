package day20210529;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// DataBase 가 바껴도 소스가 안바뀌게 해주게 해준다.
// 사용자가 직접 정의하는 객체이다
public class BookDao {
	
	// Dao : Data access object
	// 디비 쿼리를 실행해 주는 메서드를 몽땅 다 만들거임.
	
	// insert, update , selectOneById, selectListByTitle, selectList, delete
	
	// 북의 전체 정보를 보는 메서드 
	public List<BookDto> selectList() throws ClassNotFoundException, SQLException{
		
		String sql = "select book_id, title, sub_title, publisher , price, "
				+ "publication_date, reg_date from books";
		
		try(Connection conn = MyConnection.getConn();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql)){
			
			List<BookDto> list = new ArrayList<>();
			
//			db -> rs -> dto -> list
			
			while(rs.next()) {
				BookDto bookDto = new BookDto(
						rs.getInt("book_id"), 
						rs.getString("title"),
						rs.getString("sub_title"), 
						rs.getString("publisher"),
						rs.getInt("price"),
						// String 받아서 parse 하는 방법 날짜관련된것들
						LocalDate.parse(rs.getString("publication_date")), 
						LocalDateTime.parse(rs.getString("reg_date"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//						2021-05-16 10:20:06 
//						2021-05-16T10:20:06 이렇게 나와야하는데만들수 없으니
				// 		DateTimeFormatter.ofPa
				
				list.add(bookDto);
			}
			
			return list;
		}
		
	}

	
	// 북 아이디를 전달받아 해당되는 북의 정보를 반환하는 메서드
	public BookDto selectOneById(int bookId) throws ClassNotFoundException, SQLException {
		
		String sql = "select book_id, title, sub_title, publisher , price, "
				+ "publication_date, reg_date from books where book_id =?";
		
		try(Connection conn = MyConnection.getConn();
			PreparedStatement pst = conn.prepareStatement(sql)){
			
			// 미완성인 pst 의 쿼리의 '?' 부문을 셋팅
			pst.setInt(1, bookId);
			
			// 쿼리를 실행
			// ResultSet rs = pst.executeQuery(sql) 하면
			// ? 를포함한 sql 문을 실행할라해서 안된다!
			try(ResultSet rs = pst.executeQuery()){
				if(rs.next()) {
					return new BookDto(rs.getInt("book_id"), 
							rs.getString("title"),
							rs.getString("sub_title"),
							rs.getString("publisher"),
							rs.getInt("price"),
							rs.getDate("publication_date").toLocalDate(),
							rs.getTimestamp("reg_date").toLocalDateTime());
				}else {
					System.out.println("해당 bookId 가 없습니당!");
					return null;
				}
			}		
		}
	}
	
	
	// 제목을 전달받아 해당되는 제목의 글자가 있는 북리스트를 반환
	public List<BookDto> selectListByTitle(){

		

		return null;
	}
	
	// 책 내용을 데이타베이스에 추가하는 메서드
	public int insert(BookDto bookDto) throws ClassNotFoundException, SQLException {
		
		String sql = "insert into books(book_id, title, sub_title, publisher,"
				+ "price, publication_date, reg_date) values (?,?,?,?,?,?,?)";
		
		try(Connection conn = MyConnection.getConn();
			PreparedStatement pst = conn.prepareStatement(sql)){
			
			pst.setInt(1, bookDto.getBookId());
			pst.setString(2, bookDto.getTitle());
			pst.setString(3, bookDto.getSub_title());
			pst.setString(4, bookDto.getPublisher());
			pst.setInt(5, bookDto.getPrice());
			pst.setDate(6, Date.valueOf(bookDto.getPublicationDate()));
			pst.setTimestamp(7, Timestamp.valueOf(bookDto.getRegDate()));
			
			// 쿼리문 실행
			return pst.executeUpdate(); // 실행한 row 수를 반환한다.
		}
		
	}
	
	
	// 책의 내용을 수정하는 메소드
	public int update(BookDto bookDto) throws ClassNotFoundException, SQLException {
		
		String sql = "update books set title=?, sub_title=?, publisher=?, "
				+ "price=?, publication_date=? ,reg_date=? where book_id=?";
		
		try(Connection conn = MyConnection.getConn();
			PreparedStatement pst = conn.prepareStatement(sql)){
			
			pst.setString(1, bookDto.getTitle());
			pst.setString(2, bookDto.getSub_title());
			pst.setString(3, bookDto.getPublisher());
			pst.setInt(4, bookDto.getPrice());
			pst.setDate(5, Date.valueOf(bookDto.getPublicationDate()));
			pst.setTimestamp(6, Timestamp.valueOf(bookDto.getRegDate()));
			pst.setInt(7, bookDto.getBookId());
			
			return pst.executeUpdate();
		}
	}
	
	
	
	
	
	
}
