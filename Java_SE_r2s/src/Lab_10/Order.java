package Lab_10;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Order {
	private String number;
	private Date date;

	public Order() {
		super();
	}

	public Order(String number, Date date) throws Exception {

		this.setNumber(number);
		this.date = date;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) throws Exception {
		if (number == null || number.length() != 10) {
			throw new Exception("[Order] : Error Length number must be 10 ");
		} else {
			this.number = number;
		}
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return "Order [number=" + number + ", date=" + dateFormat.format(date) + "]";
	}
	

}
