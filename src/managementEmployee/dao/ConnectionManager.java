package managementEmployee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	/** 接続するDBのURL */
	private static final String URL = "jdbc:mysql://localhost:3306/app_servlet";
	/** DB接続するためのユーザー名 */
	private static final String USER_NAME = "servlet_training_user";
	/** DB接続するためのパスワード */
	private static final String PASSWORD = "systemsss";


	/**
	 * DB接続
	 *
	 * @return 接続情報
	 */
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	//■■■■■■■追加■■■■■■■■■
			// DBへ接続
			Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
//		Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
//		return con;
	}

}
