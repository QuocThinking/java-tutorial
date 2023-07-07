package CollectionFramework;

public class Test implements Comparable<Test>{

	 int number;
	 
	 String name, address;
	 
	 public Test(int number) {
		 this.number = number;
	 }
	 
	 @Override
	public String toString() {
		return String.valueOf(number);
	}

	@Override
	public int compareTo(Test o) {
		return this.number < o.number ? -1 : 1;
	}
}
