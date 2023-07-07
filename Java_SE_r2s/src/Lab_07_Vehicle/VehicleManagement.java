package Lab_07_Vehicle;

public class VehicleManagement {
	public static void main(String[] args) {
		Vehicle v1 = new Vehicle("Quoc", "Honda", 125, 207776);
		v1.hienThiThongTin();
		System.out.println("==============================");
		Vehicle v2 = new Vehicle("Quoc_2", "Honda_2", 300, 500555);
		v2.hienThiThongTin();
		System.out.println("==============================");
		Vehicle v3 = new Vehicle();
		v3.hienThiThongTin();
		System.out.println("==============================");
		double tong = v1.getThueTruocBa() + v2.getThueTruocBa() + v3.getThueTruocBa();
		System.out.println("Tổng thuế 3 xe : " + tong);
	}
}
