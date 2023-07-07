package Lab_08_Actionable;

public class CarManagement {
	public static void main(String[] args) {
		Car c1 = new Car("Honda", "Honda", 2020, 8, 30000);
		System.out.println("Information of car is : \n" + c1.getInfor() );
		System.out.println("Tax or car is : " + c1.calculateTax());
		System.out.println("Price of car : " + c1.calculatePrice());
	}
}
