package Lab_11_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//import buoi11.bai1.FlightManagement;

public class Flightmanagerment {
	String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=Qlychuyenbay;user=sa;password=lequocsql;encrypt=true;trustServerCertificate=true";
	Connection connection = null;

	private Connection getConnection() {
		if (connection != null) {
			return connection;
		} else {
			try {
				connection = DriverManager.getConnection(dbURL);
				return connection;
			} catch (Exception e) {
				System.out.println("get connection get error: " + e);
				System.exit(0);
			}
		}

		return null;
	}

	private void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void menu() {
		System.out.println("Menu");
		System.out.println("1. Xem danh sach nhan vien");
		System.out.println("2. Xem danh sach chuyen bay");
		System.out.println("3. Xem danh sach chung nhan");
		System.out.println("4. Xem danh sach may bay");
		System.out.println("5. Them moi nhan vien");
		System.out.println("6. Thoat");
		System.out.print("Moi ban lua chon chuc nang: ");
	}

	public static void main(String[] args) {
		Flightmanagerment flightManagement = new Flightmanagerment();
		Scanner scanner = new Scanner(System.in);
		int option;
		long start;
		
		// co 3 loai execute
		// execute: su dung cho tat ca cac cau lenh sql -> boolean
		// executeQuery: su dung cho select -> result set
		// executeUpdate: su dung cho insert, update, delete -> tra ve so luong dong bi thay doi

		while (true) {
			flightManagement.menu();
			option = Integer.parseInt(scanner.nextLine());

			switch (option) {
			case 1:
				start = System.currentTimeMillis();
				flightManagement.xemDanhSachNhanVien();
				System.out.println("Thoi gian chay la: " + (System.currentTimeMillis() - start));
				break;
			case 2:
				start = System.currentTimeMillis();
				flightManagement.xemDanhSachChuyenBay();
				System.out.println("Thoi gian chay la: " + (System.currentTimeMillis() - start));
				break;
			case 3:
				flightManagement.xemDanhSachChungNhan();
				break;
			case 4:
				flightManagement.xemDanhSachMayBay();
				break;
			case 5:
				flightManagement.themMoiNhanVien();
				break;
			case 6:
				System.out.println("Tam biet!");
				flightManagement.closeConnection();
				return;
			default:
				System.out.println("Ban lua chon sai chuc nang!");
				break;
			}
		}
	}

	private void themMoiNhanVien() {
		PreparedStatement preparedStatement = null;
		Scanner scanner = new Scanner(System.in);
		try {
			String sqlQuery = "INSERT INTO nhanvien VALUES (?, ?, ?)";
			preparedStatement = connection.prepareStatement(sqlQuery);

			System.out.print("Nhap ma nhan vien: ");
			preparedStatement.setString(1, scanner.nextLine());
			System.out.print("Nhap ten nhan vien: ");
			preparedStatement.setString(2, scanner.nextLine());
			System.out.print("Nhap luong nhan vien: ");
			preparedStatement.setInt(3, Integer.parseInt(scanner.nextLine()));

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

	private void xemDanhSachMayBay() {
		Statement statement = null;
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(dbURL);
			statement = connection.createStatement();

			String sqlQuery = "select * from maybay";
			ResultSet resultSet = statement.executeQuery(sqlQuery);
			System.out.println("Danh sach may bay la:");
			System.out.printf("%-12s|%-20s|%-10s\n", "Mã máy bay", "Loại máy bay", "Tầm bay");
			while (resultSet.next()) {
				System.out.printf("%-12s|%-20s|%-10s\n", resultSet.getInt(1), resultSet.getString(2),
						resultSet.getInt(3));
			}
		} catch (Exception e) {
			System.err.println("xemDanhSachMayBay Error: " + e);
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
	}

	private void xemDanhSachChungNhan() {
		Statement statement = null;
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(dbURL);
			statement = connection.createStatement();

			String sqlQuery = "select * from chungnhan";
			ResultSet resultSet = statement.executeQuery(sqlQuery);
			System.out.println("Danh sach chung nhan la:");
			System.out.printf("%-13s|%-10s\n", "Mã chứng nhận", "Mã máy bay");
			while (resultSet.next()) {
				System.out.printf("%-13s|%-10s\n", resultSet.getString(1), resultSet.getInt(2));
			}
		} catch (Exception e) {
			System.err.println("xemDanhSachChungNhan Error: " + e);
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
	}

	private void xemDanhSachChuyenBay() {
		Statement statement = null;

		try {
			statement = getConnection().createStatement();

			String sqlQuery = "select * from chuyenbay";
			ResultSet resultSet = statement.executeQuery(sqlQuery);
			System.out.println("Danh sach chuyen bay la:");
			System.out.printf("%-13s|%-6s|%-6s|%-10s|%-15s|%-15s|%-10s\n", "Mã chuyến bay", "Ga đi", "Ga đến", "Độ dài",
					"Giờ đi", "Giờ đến", "Chi phí");
			while (resultSet.next()) {
				System.out.printf("%-13s|%-6s|%-6s|%-10s|%-15s|%-15s|%-10s\n", resultSet.getString(1),
						resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getTime(5),
						resultSet.getTime(6), resultSet.getInt(7));
			}
		} catch (Exception e) {
			System.err.println("xemDanhSachChuyenBay Error: " + e);
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void xemDanhSachNhanVien() {
		Statement statement = null;

		try {
			statement = getConnection().createStatement();

			String sqlQuery = "select * from nhanvien";
			ResultSet resultSet = statement.executeQuery(sqlQuery);
			System.out.println("Danh sach nhan vien la:");
			System.out.printf("%-13s|%-20s|%-20s\n", "Mã nhân viên", "Tên nhân viên", "Lương");
			while (resultSet.next()) {
				System.out.printf("%-13s|%-20s|%-20d\n", resultSet.getString(1), resultSet.getString(2),
						resultSet.getInt(3));
			}
		} catch (Exception e) {
			System.err.println("xemDanhSachNhanVien Error: " + e);
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
