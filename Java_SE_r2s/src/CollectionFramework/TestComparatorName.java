package CollectionFramework;

import java.util.Comparator;

public class TestComparatorName implements Comparator<Test> {

	@Override
	public int compare(Test o1, Test o2) {
		return o1.name.compareTo(o2.name);
	}
	

}
