package Lab_08_Actionable;

public class Car implements Actionable{

	private String Name, Producer;
	private int Year,Seat;
	private double Price;
	public Car(String name, String producer, int year, int seat, double price) {
		super();
		Name = name;
		Producer = producer;
		Year = year;
		Seat = seat;
		Price = price;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getProducer() {
		return Producer;
	}
	public void setProducer(String producer) {
		Producer = producer;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public int getSeat() {
		return Seat;
	}
	public void setSeat(int seat) {
		Seat = seat;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	
	@Override
	public double calculateTax() {
		double taxCar ;
		if(this.Seat < 7 ) {
			taxCar = this.Price * 0.6;
		}else {
			taxCar = this.Price * 0.7;
		}
		return taxCar;
	}
	@Override
	public double calculatePrice() {
		double countCar;
		return countCar = this.Price + this.calculateTax();
	}
	
	@Override
	public String getInfor() {
		return this.Name + " car produced by " + this.Producer + " in " + this.Year + " has " + this.Seat +
				" seats with the total price is " + this.Price + "$";
	}
}
