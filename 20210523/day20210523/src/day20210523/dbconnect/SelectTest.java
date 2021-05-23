package day20210523.dbconnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

public class SelectTest {
	public static void main(String[] args) {
		
		//mysql 커넥션객체를 담을 수 있는 변수 생성
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			conn = MyConnection.getConn();
			
			// 조회하는 쿼리를 실행하자
			String sql = "select film_id, title, release_year, rental_duration,"
					+ " rental_rate, last_update from film limit 5";
			
			//Connection으로 부터 Statement 라는 객체는 가져온다.  
			statement = conn.createStatement();
			
			//Statement 라는 객체로 쿼리를 실행한다. Statement 는 쿼리를 실행해주는 객체다.
			//select 는 결과를 받아와야한다.
			//그 결과를 담을 수 있는 resultSet이라는 객체로 받는다.
			rs = statement.executeQuery(sql);
					
			// ResultSet 에서 결과를 꺼낸다
			// rs 가 맨처음에는 아무것도없는 row 에 접근해서 rs.next()를 해줘야한다
			while(rs.next()) {
//				int film_id = rs.getInt("film_id");
//				String title = rs.getString("title");
//				String year = rs.getString("release_year");
//				int rental_duration = rs.getInt("rental_duration");
//				double rental_rate = rs.getDouble("rental_rate");
//				LocalDateTime last_update = rs.getTimestamp("last_update").toLocalDateTime();
				
				// 결과의 컬럼 번호로도 가져올수 있다.
				int film_id = rs.getInt(1);
				String title = rs.getString(2);
				String year = rs.getString(3);
				int rental_duration = rs.getInt(4);
				double rental_rate = rs.getDouble(5);
				LocalDateTime last_update = rs.getTimestamp(6).toLocalDateTime();
				System.out.println(film_id + ", " + title + ", " + year + ", " + rental_duration + ", " + rental_rate + ", " + last_update);
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// null 체크 하는 이유는 MyConnection.getConn() 에서 Exception 이발생하면
			// conn 이 null 이되므로 nullExceptionPoint를 막는다. 
				try {
					if(rs != null) {rs.close();}
					if(statement != null) {statement.close();}
					if(conn != null) {conn.close();}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
	}
}

// 객체는
// 연결이 끊겼을 때 

// Car car = new Car();

// Car car1 = car;
// car = null;

// 하면 car1이 연결되어있으므로 객체가 안사라진다. 