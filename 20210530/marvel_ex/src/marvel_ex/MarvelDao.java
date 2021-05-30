package marvel_ex;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MarvelDao {

	private MarvelDao() {}
	private static MarvelDao instance = new MarvelDao();
	public static MarvelDao getInstance() {
		return instance;
	}
	
	// 그냥 전체 조회하기
	public List<MarvelDto> select(Connection conn) throws SQLException {
		
		String sql = "select * from marvel_movie";
		
		List<MarvelDto> movieList = new ArrayList<>();
		
		try(Statement stmt = conn.createStatement()){
			
			try(ResultSet rs = stmt.executeQuery(sql)){
				
				while(rs.next()) {
					movieList.add(new MarvelDto(
							rs.getInt("movie_id"),
							rs.getString("title"),
							rs.getString("title_eng"),
							rs.getDate("release_date").toLocalDate(),
							rs.getLong("world_box_office"),
							rs.getTimestamp("write_date").toLocalDateTime(),
							rs.getTimestamp("update_date").toLocalDateTime()));
				}
				
			}
			
		}
		
		return movieList;
		
	}
	
	// 제목이름으로 조회하기
	public List<MarvelDto> selectByTitle(Connection conn, String title) throws SQLException{
		
		String sql = "select * from marvel_movie where title like ?";
		
		List<MarvelDto> movieList = new ArrayList<>();
		
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			
			pst.setString(1, "%"+title+"%");
			
			try(ResultSet rs = pst.executeQuery()){
				
				while(rs.next()) {
					movieList.add(new MarvelDto(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getDate(4).toLocalDate(),
							rs.getLong(5),
							rs.getTimestamp(6).toLocalDateTime(),
							rs.getTimestamp(7).toLocalDateTime()));
				}
			}
		}
		
		return movieList;
		
	}
	
	// 아이디 하나 받아서 전체 조회하기
	public MarvelDto selectByOne(Connection conn , int movieId) throws SQLException {
		
		String sql = "select * from marvel_movie where movie_id = ?";
		
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			
			pst.setInt(1, movieId);
			
			try(ResultSet rs = pst.executeQuery()){
				
				if(rs.next()) {
					MarvelDto marvelDto	= new MarvelDto(
							rs.getInt("movie_id"),
							rs.getString("title"),
							rs.getString("title_eng"),
							rs.getDate("release_date").toLocalDate(),
							rs.getLong("world_box_office"),
							rs.getTimestamp("write_date").toLocalDateTime(),
							rs.getTimestamp("update_date").toLocalDateTime());
					
					return marvelDto;
				}
				else 
					return null;
				
			}
			
		}
	}

		
	// 업데이트 하기
	public int update(Connection conn, MarvelDto marvelDto) throws SQLException {
		
		String sql = "update marvel_movie set title=? , title_eng=?,"
				+ "release_date=? ,world_box_office=?, write_date=?, update_date=? where movie_id = ?";
		
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			
			pst.setString(1, marvelDto.getTitle());
			pst.setString(2, marvelDto.getTitleEng());
			pst.setDate(3, Date.valueOf(marvelDto.getReleaseDate()));
			pst.setLong(4, marvelDto.getWorldBoxOffice());
			pst.setTimestamp(5, Timestamp.valueOf(marvelDto.getWriteDate()));
			pst.setTimestamp(6, Timestamp.valueOf(marvelDto.getUpdateDate().now()));
			pst.setInt(7, marvelDto.getMovieId());
			
			return pst.executeUpdate();
		}
	
	}

	// 데이터 넣기
	public int insert(Connection conn, MarvelDto marvelDto) throws SQLException {
		
		String sql = "insert into marvel_movie(movie_id, title, title_eng, release_date, world_box_office, write_date, update_date)"
				+ "values(?,?,?,?,?,?,?)";
		
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			
			pst.setInt(1, marvelDto.getMovieId());
			pst.setString(2, marvelDto.getTitle());
			pst.setString(3, marvelDto.getTitleEng());
			pst.setDate(4, Date.valueOf(marvelDto.getReleaseDate()));
			pst.setLong(5, marvelDto.getWorldBoxOffice());
			pst.setTimestamp(6, Timestamp.valueOf(marvelDto.getWriteDate()));
			pst.setTimestamp(7, Timestamp.valueOf(marvelDto.getUpdateDate()));
			
			return pst.executeUpdate();
			
		}
		
	}

	// 데이터 지우기
	public int delete(Connection conn , int movieId) throws SQLException {
		
		String sql = "delete from marvel_movie where movie_id=?";
		
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			
			pst.setInt(1, movieId);
			
			return pst.executeUpdate();
		}
	}


	
	// 몇개의 영화를 조회할 것인가?
	public List<MarvelDto> selectHowMany(Connection conn , int RowNum) throws SQLException{
		
		String sql = "select * from marvel_movie limit ?";
		
		List<MarvelDto> movieList = new ArrayList<>();
		
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			
			
			
			pst.setInt(1, RowNum);
			
			try(ResultSet rs = pst.executeQuery()){
				
				while(rs.next()) {
					movieList.add(new MarvelDto(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getDate(4).toLocalDate(),
							rs.getLong(5),
							rs.getTimestamp(6).toLocalDateTime(),
							rs.getTimestamp(7).toLocalDateTime()));
				}
				
			}
			
		}
		
		return movieList;
	}
	
	
}
