package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		String title = "TEST2";
		String writerId = "newlec";
		String content = "hahaha";
		String files = "";
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = " INSERT INTO notice (" +
				 "    title," +
				 "    writer_id," +
				 "    content," +
				 "    files" +
				 ") VALUES (?,?,?,?)";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url,"NEWLEC","0297");
		
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
		
		System.out.println(result);
		
		
		
		
		st.close();
		con.close();
	}

}