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
		
		// �󷡴� �Ʒ��� ���� �Ἥ �������� ��������ϴµ�
		// �����Ҷ� �ʹ� �����.
		//Statement st = con.createStatement();
		//st.ex.....(sql)
		
		// �׷��� �Ʒ��� ���� �ϸ� ���� �����͸� ������ �ִ�.
		PreparedStatement st = con.prepareStatement(sql);
		
		// �ΰ��� ���ڰ� ���µ� title�� �ִ´� ���࿡ 
		// index�� �����̳� ���� values(?,?,?,?)�� ?�� 4�����ִ�.
		// �׷��� ���° ? �� ���� �����Ұų� �װ��� ���°��̴�.
		// ���⼭�� title�� ù��°�ϱ� 1�� �ִ´� ����index �� 0���ͽ����ϴµ�
		// ���� index�� 1���� �����Ѵ�.	
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