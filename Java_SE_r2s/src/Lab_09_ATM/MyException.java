package Lab_09_ATM;

import javax.annotation.processing.Messager;

public class MyException extends Throwable {

	String messeger;
	
	public MyException(String mess) {
		this.messeger = mess;
	}
	@Override
	public String getMessage() {
	return this.messeger;
	}
}
