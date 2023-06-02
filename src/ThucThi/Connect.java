package ThucThi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	public static Connection getConnect() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		String conString="JDBC:sqlite://D://Quan.db";
		String name="";
		String passWord="";
		Connection con=DriverManager.getConnection(conString, name, passWord);
		return con;
	}
}
