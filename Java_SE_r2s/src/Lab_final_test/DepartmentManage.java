package Lab_final_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import Lab_11_JDBC.Flightmanagerment;

public class DepartmentManage {
		String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=EmployeeDB;user=sa;password=lequocsql;encrypt=true;trustServerCertificate=true";
		Connection connection = null;

		public Connection getConnection() {
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
			System.out.println("1. Xem danh sach nhan vien SalariedEmployee");
			System.out.println("2. Xem danh nhan vien hourly employee");
			System.out.println("3. Xem danh sach toan nhan vien");
			System.out.println("4. Them moi nhan vien");
			System.out.println("5. Them du lieu nhan vien phong salaried");
			System.out.println("6. Them du lieu nhan vien phong hourly employee");
			System.out.println("7. Tim nhan vien (nhap ten phong ban)");
			System.out.println("8. xem so luong nhan vien tung phong ban");
			System.out.println("9. Tim nhan vien (nhap ten nhan vien)");
			System.out.print("Moi ban lua chon chuc nang: ");
		}

		public static void main(String[] args) {
			EmployeeRepo employeeRepo = new EmployeeRepo();
			DepartmentManage departmentManage = new DepartmentManage();
			Scanner scanner = new Scanner(System.in);
			int option;
			long start;
			String name;
			String name1 ;
			// co 3 loai execute
			// execute: su dung cho tat ca cac cau lenh sql -> boolean
			// executeQuery: su dung cho select -> result set
			// executeUpdate: su dung cho insert, update, delete -> tra ve so luong dong bi thay doi

			while (true) {
				departmentManage.menu();
				option = Integer.parseInt(scanner.nextLine());

				switch (option) {
				case 1:
					//start = System.currentTimeMillis();
					employeeRepo.xemDanhSachSalaried();
					//System.out.println("Thoi gian chay la: " + (System.currentTimeMillis() - start));
					break;
				case 2:
					//start = System.currentTimeMillis();
					employeeRepo.xemDanhSachHourly();
					//System.out.println("Thoi gian chay la: " + (System.currentTimeMillis() - start));
					break;
				case 3:
					employeeRepo.xemToanBoNhanVien();
					break;
				case 4:
					employeeRepo.themMoiNhanVien();
					break;
				case 5:
				employeeRepo.themDuLieuSalaried();
					break;
				case 6:
					//System.out.println("Tam biet!");
					employeeRepo.themDuLieuHourLy();
					break;
				case 7:
					System.out.println("Nhap ten phong ban");
					name = scanner.nextLine();
					employeeRepo.findByName(name);
					break;
				case 8:
					employeeRepo.thongKeNhanVien();
					break;
				case 9:
					System.out.println("Nhap ten nhan vien");
					name1 = scanner.nextLine();
					employeeRepo.timTheoTen(name1);
					break;
				default:
					System.out.println("Ban lua chon sai chuc nang!");
					break;
				}
			}
		}
}
