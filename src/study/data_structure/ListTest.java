package study.data_structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		final int size = 100_000_000;
		main2(size);
	}

	private static void main1(int size) {
		long startTime = System.currentTimeMillis();
		List<Integer> list = new LinkedList<>();

		for(int index = 0; index < size; index++) {
			list.add(index);
		}
		long endTime = System.currentTimeMillis();

		System.out.println("전부 add한 경우: " + (endTime - startTime) + "초가 소요되었습니다.");
	}


	private static void main2(int size) {
		long startTime2 = System.currentTimeMillis();
		List<Integer> list2 = new ArrayList<>(size);
		for(int index = 0; index < size; index++) {
			list2.add(index);
		}
		long endTime2 = System.currentTimeMillis();

		System.out.println("전부 add한 경우: " + (endTime2 - startTime2)  + "초가 소요되었습니다.");
	}
}
