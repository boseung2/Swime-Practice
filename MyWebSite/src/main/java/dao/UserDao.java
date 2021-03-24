package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


class Dao {
	static Connection conn;
	static String tableName = "";
	
	public Dao() {
		this(null, "");
	}
	public Dao(String tableName) {
		this(null, tableName);
	}
	public Dao(Connection conn, String tableName) {
		super();
		this.tableName = tableName;
		this.conn = conn;
	}
	
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public String getTableName() {
		return tableName;
	}
	
	void rollback() {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	void close(AutoCloseable... acs) {
		for(int i = 0; i < acs.length; i++) {
			if(acs[i] != null) {
				try {
					acs[i].close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}

public class UserDao extends Dao {
	static String id, password, name, email;
	final static String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	final static String DB_USER = "student"; // DB의 userid와 pwd를 알맞게 변경
	final static String DB_PASSWORD = "1234";
	static Statement stmt = null;
	static ResultSet rs = null;
	static String query = "";
	final static UserDao instance = new UserDao();
	int count = 0;
	
	private UserDao(){
		super(null,"student.USER_INFO");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {		
			e.printStackTrace();
		}
	}
	
	void openConn_stmt() throws Exception {
		super.conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // 데이터베이스의 연결을 설정한다.
		stmt = conn.createStatement();
	}
		
	public static Connection getConnection() throws Exception {
		return conn;
	}
	
	public static UserDao getInstance() {
//		return new UserDao4();
		return instance;
	}
	
//	UserDao4 getInstance() {
//	      return this;
//	}
	
	public void print_list(List<User> list) {
		Iterator<User> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public List<User> selectAllUsers() throws Exception {
		List<User> list = new ArrayList<>();
		try {
			openConn_stmt();
			query = String.format("SELECT * FROM %s", tableName);
			rs = stmt.executeQuery(query); // SQL문을 실행한다.
			while (rs.next()) {
				list.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
			throw e;
		} finally {
			close(stmt,rs,conn);
		}

		return list;
	}

	public int deleteUser(String userId) throws Exception {
		query = String.format("DELETE FROM %s WHERE user_id = '%s'", tableName, userId);
		count = 0;
		try {
			openConn_stmt();
			count = stmt.executeUpdate(query); // SQL문을 실행한다.
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
			throw e;
		} finally {
			close(stmt, rs, conn);
		}
		return count;
	}


	public User selectUser(String userId) throws Exception {
		query = String.format("SELECT * FROM %s WHERE user_id = '%s'", tableName, userId);
		User user = null;
		try {
			openConn_stmt();
			rs = stmt.executeQuery(query); // SQL문을 실행한다.
			while (rs.next()) {
				user = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
			throw e;
		} finally {
			close(stmt, rs, conn);
		}
		return user;
	}

	public int insertUser(User u) throws Exception {
		query = "INSERT INTO " + tableName + " (USER_ID, PASSWORD, NAME, EMAIL) VALUES('" + u.getId() + "', '" + u.getPassword() + "', '" + u.getName() + "', '" + u.getEmail() + "')";;
		count = 0;
		try {
			openConn_stmt();
			count = stmt.executeUpdate(query); // SQL문을 실행한다.
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
			throw e;
		} finally {
			close(stmt, rs, conn);
		}
		return count;
	}

	public int updateUser(User u) throws Exception {
		query = String.format("UPDATE %s SET PASSWORD = '%s', NAME = '%s', EMAIL = '%s' WHERE USER_ID = '%s'", tableName, u.getPassword(), u.getName(), u.getEmail(), u.getId());
		count = 0;
		try {
			openConn_stmt();
			count = stmt.executeUpdate(query); // SQL문을 실행한다.
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
			throw e;
		} finally {
			close(stmt, rs, conn);
		}
		return count;
	}
}
