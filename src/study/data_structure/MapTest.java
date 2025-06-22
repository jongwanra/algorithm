package study.data_structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {
	private void computeIfAbsentTest() {
		Map<String, List<Integer>> map = new HashMap<>();
		map.computeIfAbsent("apple", (k) -> new ArrayList<>())
			.add(1);

		map.computeIfAbsent("apple", (k) -> new ArrayList<>())
			.add(2);

		map.computeIfAbsent("apple", (k) -> new ArrayList<>())
			.add(3);

		List<Integer> list = map.get("apple");
		for (Integer i : list) {
			System.out.println("i = " + i);
		}
	}

	private void putIfAbsentTest() {
		Map<String, String> map = new HashMap<>();

		//"A"란 키가 없기 때문에 "ABC"가 "A"키가 생성됨
		String a = map.putIfAbsent("A", "ABC");

		System.out.println("a = " + a); // 리턴 값 = null
		System.out.println(map.get("A"));

		System.out.println("--------------");

		//"A"란 키가 존재하므로 그대로 "ABC"
		String b = map.putIfAbsent("A", "DEF");

		System.out.println("b = " + b); // 리턴값 "ABC"
		System.out.println(map.get("A")); // 리턴값이 "ABC" 겠지

	}

	public static void main(String[] args) {
		MapTest mapTest = new MapTest();
		mapTest.computeIfAbsentTest();
		mapTest.putIfAbsentTest();
	}
}
