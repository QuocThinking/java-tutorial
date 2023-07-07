package CollectionFramework;
import java.util.HashMap;
import java.util.Map;
public class MapInterface {
	public static void main(String[] args) {
	 
		Map<String, Double> map1 = new HashMap<>();
		System.out.println("Map vừa dc khởi tạo" + map1);
	
		// thêm phần tử
		map1.put("A", 8.5);
		map1.put("B", 7d);
		map1.put("C", 6.7);
		map1.put("D", 5d);
		
		System.out.println("Map sau khi dc in : " + map1);
		
		// Lấy giá trị của phần tử
		System.out.println("Map get key C = " + map1.get("C"));
		System.out.println("Map get key H = " + map1.get("H"));
		// Lấy key 
		System.out.println("Map get key : " + map1.keySet());
	}
}
