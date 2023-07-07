package CollectionFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ArrayListJava {

	public static void main(String[] args) {
		
		System.out.println("This is frist array list");
		List<Integer> list1 = new ArrayList<>();
		for(int i = 1; i <= 10; i++) {
			list1.add(i);
		}
		System.out.println(list1);
		// remove
//		list1.remove(0);
//		System.out.println(list1);
		
		System.out.println("user method remove (Integer.valueOf(5))");
		list1.remove(Integer.valueOf(5));
		System.out.println(list1 + "\n");
		
		// sort
		
		
		System.out.println("This is a second arraylist");
		List<Integer> list2 = new ArrayList<>();
		for(int i = 10; i > 0; i--) {
			list2.add(i);
		}
		System.out.println(list2);
		System.out.println("Use method sort");
		//Collections.sort(list2);
		list2.sort(Comparator.naturalOrder());
		System.out.println(list2);
		list2.sort(Comparator.reverseOrder());
		System.out.println(list2 + "\n");
		
		System.out.println("use sort object");
		List<Test> list3 = new ArrayList<>();
		for(int i = 0; i < 10 ; i++) {
			list3.add(new Test(i));
		}
		System.out.println(list3);
		Collections.sort(list3);
		System.out.println(list3);
		
		list3.sort(Comparator.reverseOrder());
		System.out.println(list3 + "\n");
		
		System.out.println("so sang name");
		Collections.sort(list3,new TestComparatorName());
		System.out.println(list3);
	
	
	}
	

	
	

}
