package Lab_final_test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//import entities.User;
//import myconnection.MySQLConnection;

//import myconnection.MySQLConnection;

//import entities.User;
//import myconnection.MySQLConnection;

public class EmployeeRepo {
	String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=EmployeeDB;user=sa;password=lequocsql;encrypt=true;trustServerCertificate=true";
	private List<Employee> employees;

	public List<Employee> xemDanhSachSalaried() {
		List<Employee> employees = new ArrayList<Employee>();
		Statement statement = null;
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(dbURL);
			statement = connection.createStatement();

			String sqlQuery = " select e.ssn,e.firstName,e.lastName,e.email, e.phone, s.basicSalary,s.commissionRate,s.grossSales, de.DEPT_NAME\r\n"
					+ " from EMPLOYEE e inner join salariedEmployee s\r\n"
					+ " on e.ssn = s.ssn inner join DEPARTMENT_EM de on de.DEPT_NAME = 'SALARIED_EMPLOYEE'";
			ResultSet resultSet = statement.executeQuery(sqlQuery);
			System.out.println("Danh sach salaried employee:");
			System.out.printf("%-12s|%-20s|%-20s|%-30s|%-20s|%-30s|%-30s|%-30s|%-30s\n", "ssn", "firstname", "lastname",
					"email", "phone", "basicsalary", "commisionrate", "grosssales", "deptname");
			while (resultSet.next()) {
				System.out.printf("%-12s|%-20s|%-20s|%-30s|%-20s|%-30s|%-30s|%-30s|%-30s\n", resultSet.getString(1),
						resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
						resultSet.getFloat(6), resultSet.getFloat(7), resultSet.getFloat(8), resultSet.getString(9));
			}
		} catch (Exception e) {
			System.err.println("Danh sach salaried employee Error: " + e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return employees;
	}

	public List<Employee> xemDanhSachHourly() {
		List<Employee> employees = new ArrayList<Employee>();
		Statement statement = null;
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(dbURL);
			statement = connection.createStatement();

			String sqlQuery = "  select e.ssn,e.firstName,e.lastName,e.email, e.phone, h.wage,h.workingHours ,de.DEPT_NAME\r\n"
					+ " from EMPLOYEE e inner join hourlyEmployee h\r\n"
					+ " on e.ssn = h.ssn inner join DEPARTMENT_EM de on de.DEPT_NAME = 'HOURLY_EMPLOYEE'";

			ResultSet resultSet = statement.executeQuery(sqlQuery);
			System.out.println("Danh sach hourly employee:");
			System.out.printf("%-12s|%-20s|%-20s|%-30s|%-20s|%-30s|%-30s|%-30s\n", "ssn", "firstname", "lastname",
					"email", "phone", "basicsalary", "wage", "workinghours", "deptname");
			while (resultSet.next()) {
				System.out.printf("%-12s|%-20s|%-20s|%-30s|%-20s|%-30s|%-30s|%-30s\n", resultSet.getString(1),
						resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
						resultSet.getFloat(6), resultSet.getFloat(7), resultSet.getString(8));
			}
		} catch (Exception e) {
			System.err.println("Danh sach hourly employee Error: " + e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return employees;
	}

	public List<Employee> xemToanBoNhanVien() {
		List<Employee> employees = new ArrayList<Employee>();
		Statement statement = null;
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(dbURL);
			statement = connection.createStatement();

			String sqlQuery = " select * from EMPLOYEE";

			ResultSet resultSet = statement.executeQuery(sqlQuery);
			System.out.println("Danh sach toan nhan vien:");
			System.out.printf("%-12s|%-20s|%-20s|%-30s|%-30s|%-20s|%-30s\n", "ssn", "firstname", "lastname", "birthday",
					"email", "phone", "dept_id");
			while (resultSet.next()) {
				System.out.printf("%-12s|%-20s|%-20s|%-30s|%-30s|%-20s|%-30s\n", resultSet.getString(1),
						resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
						resultSet.getString(6), resultSet.getInt(7));
			}
		} catch (Exception e) {
			System.err.println("Danh sach toan nhan vien: " + e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return employees;
	}

	public void themMoiNhanVien() {

		PreparedStatement preparedStatement = null;
		Scanner scanner = new Scanner(System.in);
		DepartmentManage departmentManage = new DepartmentManage();
		Employee employee = new Employee() {
		};
		Connection con = departmentManage.getConnection();
		Date date = new Date(0);
		String phone = null;
		String email;
		String birthdate;
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\ @([\\w]+\\.)+[\\w]+[\\w]$";
		DateFormat simpleDateFormat = new SimpleDateFormat("d/M/yyyy");
		simpleDateFormat.setLenient(false);
		try {

			String sqlQuery = "INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?, ?)";
			preparedStatement = con.prepareStatement(sqlQuery);

			System.out.print("Nhap ssn: ");
			preparedStatement.setString(1, scanner.nextLine());
			System.out.print("Nhap firstname: ");
			preparedStatement.setString(2, scanner.nextLine());
			System.out.print("Nhap lastname: ");
			preparedStatement.setString(3, scanner.nextLine());

			DateFormat simDateFormat = new SimpleDateFormat("d/M/yyyy");
			simpleDateFormat.setLenient(false);
//			while (true) {
//				try {
//					System.out.print("Nhap birthday: ");
//					birthdate = scanner.nextLine();
//					preparedStatement.setString(4,birthdate);
//					employee.setBirthDate(birthdate);
//					break;
//				} catch (Exception e) {
//					System.out.println(e.getMessage());
//				}
//			}

			System.out.print("Nhap birthday: ");
			birthdate = scanner.nextLine();
			preparedStatement.setString(4, birthdate);
			//employee.setBirthDate(birthdate);
			while (true) {
				try {
					System.out.print("Nhap phone: ");
					phone = scanner.nextLine();
					preparedStatement.setString(5, phone);
					employee.setPhone(phone);
					break;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			while (true) {
				try {
//					System.out.print("Nhap email: ");
//					email = scanner.nextLine();
//					preparedStatement.setString(6, scanner.nextLine());
//					employee.setEmail(email);
					System.out.print("Nhap email: ");
					email = scanner.nextLine();
					Boolean b = email.matches(EMAIL_REGEX);
					preparedStatement.setString(6, email);

					break;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

			System.out.print("Nhap dept_id: ");
			preparedStatement.setInt(7, Integer.parseInt(scanner.nextLine()));

			// lay thong tin nguoi dung voi ma duoc nhap vao truoc khi insert

			int affectedRows = preparedStatement.executeUpdate();
			System.out.println("Them nhan vien moi " + (affectedRows > 0 ? "thanh cong" : "khong thanh cong"));
		} catch (Exception e) {
			System.err.println("themMoiNhanVien Error: " + e);
		} finally {

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void themDuLieuSalaried() {
		PreparedStatement preparedStatement = null;
		Scanner scanner = new Scanner(System.in);
		DepartmentManage departmentManage = new DepartmentManage();
		Connection con = departmentManage.getConnection();
		Date date = new Date(0);
		try {
			String sqlQuery = "INSERT INTO salariedemployee VALUES (?, ?, ?, ?, ?)";
			preparedStatement = con.prepareStatement(sqlQuery);

			System.out.print("Nhap commisionRate: ");
			preparedStatement.setFloat(1, (float) Double.parseDouble(scanner.nextLine()));
			System.out.print("Nhap grossSales: ");
			preparedStatement.setFloat(2, (float) Double.parseDouble(scanner.nextLine()));
			System.out.print("Nhap basicSalary: ");
			preparedStatement.setFloat(3, (float) Double.parseDouble(scanner.nextLine()));
			System.out.print("Nhap dept_id: ");
			preparedStatement.setInt(4, (int) Double.parseDouble(scanner.nextLine()));
			System.out.print("Nhap ssn: ");
			preparedStatement.setString(5, scanner.nextLine());

			// lay thong tin nguoi dung voi ma duoc nhap vao truoc khi insert

			int affectedRows = preparedStatement.executeUpdate();
			System.out.println("Them du lieu salaried " + (affectedRows > 0 ? "thanh cong" : "khong thanh cong"));
		} catch (Exception e) {
			System.err.println("themMoiNhanVien Error: " + e);
		} finally {

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void themDuLieuHourLy() {
		PreparedStatement preparedStatement = null;
		Scanner scanner = new Scanner(System.in);
		DepartmentManage departmentManage = new DepartmentManage();
		Connection con = departmentManage.getConnection();

		try {
			String sqlQuery = "INSERT INTO hourlyemployee VALUES (?, ?, ?, ?)";
			preparedStatement = con.prepareStatement(sqlQuery);

			System.out.print("Nhap wage: ");
			preparedStatement.setFloat(1, (float) Double.parseDouble(scanner.nextLine()));
			System.out.print("Nhap workinghour: ");
			preparedStatement.setFloat(2, (float) Double.parseDouble(scanner.nextLine()));
			System.out.print("Nhap dept_id: ");
			preparedStatement.setInt(3, (int) Double.parseDouble(scanner.nextLine()));
			System.out.print("Nhap ssn: ");
			preparedStatement.setString(4, scanner.nextLine());

			// lay thong tin nguoi dung voi ma duoc nhap vao truoc khi insert

			int affectedRows = preparedStatement.executeUpdate();
			System.out
					.println("Them du lieu hourly employee " + (affectedRows > 0 ? "thanh cong" : "khong thanh cong"));
		} catch (Exception e) {
			System.err.println("themMoiNhanVien Error: " + e);
		} finally {

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public List<Employee> findByName(String name) {
		List<Employee> employees = new ArrayList<Employee>();
		DepartmentManage departmentManage = new DepartmentManage();
		PreparedStatement preparedStatement = null;
		Connection con = departmentManage.getConnection();
		if (con == null) {
			System.out.println("Cannot connect to the sql Database Server!");
		} else {
			try {
				String query = "select de.DEPT_NAME,e.firstName,e.lastName,e.ssn\r\n"
						+ "from DEPARTMENT_EM de inner join EMPLOYEE e\r\n" + "on de.DEPT_ID = e.DEPT_ID\r\n"
						+ "where de.DEPT_NAME like ?";
				// PreparedStatement psta = con.prepareStatement(query);
				preparedStatement = con.prepareStatement(query);
				// preparedStatement.setString(1, "VN254");

//				resultSet = preparedStatement.executeQuery();
//				preparedStatement = connection.prepareStatement(sqlQuyery);
				preparedStatement.setString(1, "\u0025" + name + "\u0025");
				ResultSet rs = preparedStatement.executeQuery();
				System.out.println("Danh sach phong ban :");
				System.out.printf("%-20s|%-20s|%-30s|%-30s\n", "deptname", "firstname", "lastname", "ssn");
				while (rs.next()) {
					System.out.printf("%-20s|%-20s|%-30s|%-30s\n", rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getString(4));
				}
				rs.close();
				preparedStatement.close();
				con.close();
			} catch (Exception e) {
				System.err.println("Danh sach toan nhan vien: " + e);
			}

		}
		return employees;
	}

	public List<Employee> thongKeNhanVien() {
		List<Employee> employees = new ArrayList<Employee>();
		Statement statement = null;
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(dbURL);
			statement = connection.createStatement();

			String sqlQuery = " select e.DEPT_NAME, count(*) as 'so luong nhan vien'\r\n"
					+ "from DEPARTMENT_EM e, EMPLOYEE d\r\n" + "where e.DEPT_ID = d.DEPT_ID\r\n"
					+ "group by e.DEPT_NAME";

			ResultSet resultSet = statement.executeQuery(sqlQuery);
			System.out.println("so luong nhan vien cac phong ban:");
			System.out.printf("%-20s|%-20s\n", "deptname", "so luong nhan vien");
			while (resultSet.next()) {
				System.out.printf("%-20s|%-20s\n", resultSet.getString(1), resultSet.getString(2));
			}
		} catch (Exception e) {
			System.err.println("Danh sach nhan vien cac phong ban: " + e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return employees;
	}

	public List<Employee> timTheoTen(String name) {
		List<Employee> employees = new ArrayList<Employee>();
		DepartmentManage departmentManage = new DepartmentManage();
		PreparedStatement preparedStatement = null;
		Connection con = departmentManage.getConnection();
		if (con == null) {
			System.out.println("Cannot connect to the sql Database Server!");
		} else {
			try {
				String query = "select e.firstName,e.lastName,e.phone,e.ssn,d.DEPT_NAME\r\n"
						+ "from EMPLOYEE e,DEPARTMENT_EM d\r\n" + "where e.firstName like ?";
				// PreparedStatement psta = con.prepareStatement(query);
				preparedStatement = con.prepareStatement(query);
				// preparedStatement.setString(1, "VN254");

//				resultSet = preparedStatement.executeQuery();
//				preparedStatement = connection.prepareStatement(sqlQuyery);
				preparedStatement.setString(1, "\u0025" + name + "\u0025");
				ResultSet rs = preparedStatement.executeQuery();
				System.out.println("Danh sach nhan vien :");
				System.out.printf("%-20s|%-20s|%-30s|%-30s|%-30s\n", "firstname", "lastname", "phone", "ssn",
						"deptname");
				while (rs.next()) {
					System.out.printf("%-20s|%-20s|%-30s|%-30s|%-30s\n", rs.getString(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getString(5));
				}
				rs.close();
				preparedStatement.close();
				con.close();
			} catch (Exception e) {
				System.err.println("Danh sach toan nhan vien: " + e);
			}

		}
		return employees;
	}

}