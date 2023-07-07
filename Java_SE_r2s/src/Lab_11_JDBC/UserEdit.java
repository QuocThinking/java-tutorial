package Lab_11_JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
//import com.mysql.jdbc.PreparedStatement;

import Lab_11_JDBC.TestJDBC;

public class UserEdit {
	public List<Employee> findAll() {
		List<Employee> employees = new ArrayList<Employee>();
		Connection con = TestJDBC.getConnection();
		if (con == null) {
			System.out.println("Cannot connect to the sql database server");
		} else {
			try {
				Statement smts = con.createStatement();
				ResultSet rs = smts.executeQuery("select MaNV, Ten, Luong from NhanVien");
				while (rs.next()) {
					employees.add(new Employee(rs.getString(1), rs.getString(2), rs.getFloat(3)));
					con.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return employees;
	}

	public Employee findByID(String id) {
		Employee employee = null;
		Connection con = TestJDBC.getConnection();
		if(con == null) {
			System.out.println("Cannot connect to the sql database server");
		}else {
			try {
				Statement smts = con.createStatement();
				String query = "select MaNV, Ten, Luong from NhanVien ";
				PreparedStatement preparedStatement = con.prepareStatement(query);
				preparedStatement.setString(1, id);
				ResultSet rs = preparedStatement.executeQuery();
				if(rs.next())
					employee = new Employee(rs.getString(1),rs.getString(2),rs.getFloat(3));
				rs.close();
				preparedStatement.close();
				con.close();
				
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return employee;
	}
	
//	public int addEmployee(Employee employee) {
//		String query ="insert"
//	}
}
