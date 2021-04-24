package com.newlecture.app.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.app.entity.Notice;

public class NoticeService {
	private String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
	private String uid = "NEWLEC";
	private String pwd = "0297";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	
	public List<Notice> getList(int page ,String field, String query) throws ClassNotFoundException, SQLException{
		
		// 클래스 Program 에서 select 구문을 가져오는 기능을 했는데 매번 이것을 구현해서 쓰면 너무 불편하다
		// 따라서 함수로 만들어서 갔다 쓰기 편하게 만든다.
		
		int start = 1 + (page-1)*10; // 1, 11, 21 ,31, .....
		int end = 10*page; // 10 , 20 , 30 , 40 ....
		
		String sql = "SELECT * FROM NOTICE_VIEW2 WHERE "+field+" LIKE ? AND NUM BETWEEN ? AND ?";
		
		Class.forName(driver); // UI 가 아니므로 try/catch 말고 
														  // exception 을 던진다.
		// 여기서도 Exception 을 던진다. -> SQLException 만들기
		Connection con = DriverManager.getConnection(url, uid , pwd);
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+query+"%");  // -> '%A%' 로 쿼리문으로 들어간다.
		st.setInt(2, start);
		st.setInt(3, end);
		ResultSet rs = st.executeQuery();
		// 위와 같은 애들은 함수 호출할때마다 따로잇어야해서 같은 구문이여도 합쳐서 만들수 없다.
		
		// Notice 클래스를 다른패키지에서 만든다음 그 패키지를 import한다.
		List<Notice> list = new ArrayList<Notice>();
		
		while(rs.next()) {
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writerid = rs.getString("WRITER_ID");
			Date regDate = rs.getDate("REGDATE");
			String content = rs.getString("CONTENT");
			int hit = rs.getInt("HIT");
			String files = rs.getString("FILES");
			// get ,set으로 넣어도되지만 생성자를 이용하여 Notice 에 객체를 추가한다.
			Notice notice = new Notice(
								id,
								title,
								writerid,
								regDate,
								content,
								hit,
								files
					);
			
			// 생성된 객체를 list에 담는다.
			list.add(notice);
		}
		
		rs.close(); 
		st.close();
		con.close();
		
		// Query 문으로 select 해서 나온 결과를 list에 담았으니 이제 그 list 를 반환해준다.
		return list;
	}
	
	// Scalar 
	public int getCount() throws ClassNotFoundException, SQLException {
		int count = 0;
		String sql = "SELECT COUNT(ID) COUNT FROM NOTICE";
		
		Class.forName(driver); // UI 가 아니므로 try/catch 말고 
														  // exception 을 던진다.
		// 여기서도 Exception 을 던진다. -> SQLException 만들기
		Connection con = DriverManager.getConnection(url, uid , pwd);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		// 위와 같은 애들은 함수 호출할때마다 따로잇어야해서 같은 구문이여도 합쳐서 만들수 없다.
		
		if(rs.next())
			count = rs.getInt("COUNT");	
		
		rs.close(); 
		st.close();
		con.close();
		
		// Query 문으로 select 해서 나온 결과를 list에 담았으니 이제 그 list 를 반환해준다.
		return count;
	}
	
	public int insert(Notice notice) throws ClassNotFoundException, SQLException {
		String title = notice.getTitle();
		String writerId = notice.getWriterid();
		String content = notice.getContent();
		String files = notice.getFiles();
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = " INSERT INTO notice (" +
				 "    title," +
				 "    writer_id," +
				 "    content," +
				 "    files" +
				 ") VALUES (?,?,?,?)";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,uid,pwd);
		
		// 얼래는 아래와 같이 써서 쿼리문을 맞춰줘야하는데
		// 대입할때 너무 힘들다.
		//Statement st = con.createStatement();
		//st.ex.....(sql)
		
		// 그래서 아래와 같이 하면 쉽게 데이터를 넣을수 있다.
		PreparedStatement st = con.prepareStatement(sql);
		
		// 두가지 인자가 들어가는데 title을 넣는다 만약에 
		// index는 무엇이냐 위에 values(?,?,?,?)에 ?가 4개가있다.
		// 그래서 몇번째 ? 에 값을 대입할거냐 그것을 쓰는것이다.
		// 여기서는 title이 첫번째니까 1을 넣는다 보통index 는 0부터시작하는데
		// 위의 index는 1부터 시작한다.	
		st.setString(1, title);
		st.setString(2,	writerId);
		st.setString(3, content);
		st.setString(4, files);
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		return result;
	}
	
	public int update(Notice notice) throws ClassNotFoundException, SQLException {
		String title = notice.getTitle();
		String content = notice.getContent();
		String files = notice.getFiles();
		int id = notice.getId();
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = " UPDATE NOTICE"
				+ " SET"
				+ "    TITLE =?,"
				+ "    CONTENT = ?,"
				+ "    FILES = ?"
				+ "WHERE ID = ?";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,uid,pwd);
		
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, title);
		st.setString(2,	content);
		st.setString(3, files);
		st.setInt(4, id);
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	public int delete(int id) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "DELETE NOTICE WHERE ID=?";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,uid,pwd);
		
		PreparedStatement st = con.prepareStatement(sql);

		st.setInt(1, id);
		
		int result = st.executeUpdate();
	
		st.close();
		con.close();
		
		return result;
	}

	
	
	
}

