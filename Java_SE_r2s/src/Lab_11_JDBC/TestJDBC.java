package Lab_11_JDBC;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.PreparedStatement;

import java.sql.Statement;

//`import com.sql.jdbc.Statement;

public class TestJDBC {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {

	try {
	String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=Qlychuyenbay;user=sa;password=lequocsql;encrypt=true;trustServerCertificate=true";
		Connection conn = DriverManager.getConnection(dbURL);
			if (conn != null) {
				System.out.println("Connected");
				
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
			System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());
			}

	
	
	} catch (SQLException ex) {
		System.err.println("Cannot connect database, " + ex);
	}
	}
	    
//	    public static void main(String args[]) {
//	        try {
//	            // connnect to database 'testdb'
//	            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
//	            // crate statement
//	            Statement stmt = conn.createStatement();
//	            // get data from table 'student'
//	            ResultSet rs = stmt.executeQuery("select * from NhanVien");
//	            // show data
//	            while (rs.next()) {
//	                System.out.println(rs.getString(1) + "  " + rs.getString(2) 
//	                        + "  " + rs.getFloat(3));
//	            }
//	            // close connection
//	            conn.close();
//	        } catch (Exception ex) {
//	            ex.printStackTrace();
//	        }
//	    }
	
	


//		String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=Qlychuyenbay;user=sa;password=lequocsql;encrypt=true;trustServerCertificate=true";
//
//		Statement smts = null;
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//
//		try {
//			connection = DriverManager.getConnection(dbURL);
//			smts = connection.createStatement();
//			String sqlQuyery = "Select * from CHUYENBAY";
//			ResultSet resultSet = smts.executeQuery(sqlQuyery);
//			while (resultSet.next()) {
//				System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3)
//						+ " " + resultSet.getFloat(4) + " " + resultSet.getDate(5) + " " + resultSet.getDate(6) + " "
//						+ resultSet.getFloat(7));
//			}
//			System.out.println("=========================");
//			sqlQuyery = "Select * from CHUYENBAY where MaCB = ?";
//			preparedStatement = connection.prepareStatement(sqlQuyery);
//			preparedStatement.setString(1, "VN254");
//			
//			resultSet = preparedStatement.executeQuery();
//			while (resultSet.next()) {
//				System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3)
//						+ " " + resultSet.getFloat(4) + " " + resultSet.getDate(5) + " " + resultSet.getDate(6) + " "
//						+ resultSet.getFloat(7));
//			}
//			
//		} catch (SQLException e) {
//			System.err.println(" Error : " + e);
//		} finally {
//			if (connection != null) {
//				try {
//
//					connection.close();
//
//				} catch (SQLException e2) {
//					e2.printStackTrace();
//				}
//
//			}
//			if (smts != null) {
//				try {
//					smts.close();
//				} catch (SQLException e2) {
//					e2.printStackTrace();
//				}
//			}
//			if (preparedStatement != null) {
//				try {
//					preparedStatement.close();
//				} catch (Exception e2) {
//					e2.printStackTrace();
//				}
//			}
//	public static Connection getConnection() {
//		 Connection c = null;
//		 try {
//			 DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//			 String url ="jdbc:mySQL://localhost:3306/test";
//			 String username = "root";
//			 String password ="";
//			 
//			 c = DriverManager.getConnection(url, username, password);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		 return c;
//	}
////	
////	public static void closeConnection(Connection c) {
////		
////	}
//	    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
//	            + "databaseName=Qlychuyenbay;"
//	            + "integratedSecurity=true";
//	    private static String USER_NAME = "sa";
//	    private static String PASSWORD = "lequocsql";	
	 public static Connection getConnection() {
	        Connection conn = null;
	        try {
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Qlychuyenbay;user=sa;password=lequocsql;encrypt=true;trustServerCertificate=true");
	            System.out.println("connect successfully!");
	        } catch (Exception ex) {
	            System.out.println("connect failure!");
	            ex.printStackTrace();
	        }
	        return conn;
	    }
		
	}
	

