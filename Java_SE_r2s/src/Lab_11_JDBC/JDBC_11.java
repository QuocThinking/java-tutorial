package Lab_11_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC_11 {

	 private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
	            + "databaseName=Qlychuyenbay;"
	            + "integratedSecurity=true";
	    private static String USER_NAME = "sa";
	    private static String PASSWORD = "lequocsql";
	 
	    /**
	     * main
	     * 
	     * @author viettuts.vn
	     * @param args
	     */
	    public static void main(String args[]) {
	        try {
	            // connnect to database 'testdb'
	            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
	            // crate statement
	            Statement stmt = conn.createStatement();
	            // get data from table 'student'
	            ResultSet rs = stmt.executeQuery("select * from NhanVien");
	            // show data
	            while (rs.next()) {
	                System.out.println(rs.getString(1) + "  " + rs.getString(2) 
	                        + "  " + rs.getFloat(3));
	            }
	            // close connection
	            conn.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	 
	 
	    /**
	     * create connection 
	     * 
	     * @author viettuts.vn
	     * @param dbURL: database's url
	     * @param userName: username is used to login
	     * @param password: password is used to login
	     * @return connection
	     */
	    public static Connection getConnection(String dbURL, String userName, 
	            String password) {
	        Connection conn = null;
	        try {
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            conn = DriverManager.getConnection(dbURL, userName, password);
	            System.out.println("connect successfully!");
	        } catch (Exception ex) {
	            System.out.println("connect failure!");
	            ex.printStackTrace();
	        }
	        return conn;
	    }
}
