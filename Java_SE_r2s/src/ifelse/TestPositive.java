package ifelse;

import java.util.Scanner;

public class TestPositive {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
    int number = input.nextInt();
 
    // check if number is positive
    if (number < 0) {
        System.out.print("negative");
    }
    // check if number is negative
    else if (number > 0) {
        System.out.print("positive");
    }
    // otherwise print zero
    else {
        System.out.print("zero");
    }
 
    input.close();
 
}
}
