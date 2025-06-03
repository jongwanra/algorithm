package programmers.hash.완주하지_못한_선수;

/**
 * 문제
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576?language=java
 *
 *
 * 문제 접근 방법
 * 동명이인이 있기 떄문에 Set을 통해서는 해결하기 어렵다.
 * HashMap을 이용해서 key와 value로 문제를 해결하자.
 *
 * participant: N
 * completion: M
 * 시간 복잡도: O(N + M) -> 하지만 M은 N - 1과 같으므로 -> O(N) 시간 복잡도를 가진다.
 * 공간 복잡도: O(N) 동명이인이 아닌 최악의 경우 N개의 공간만큼 HashMap을 사용하게 된다.
 */
import java.util.*;

public class Solution250604 {
	public String solution(String[] participant, String[] completion) {
		HashMap<String, Integer> nameToCountMap = new HashMap<>();
		for(String name: participant) {
			nameToCountMap.put(name, nameToCountMap.getOrDefault(name, 0) + 1);
		}

		for(String name:completion) {
			Integer count = nameToCountMap.get(name);

			if(count == 1) {
				nameToCountMap.remove(name);
				continue;
			}
			nameToCountMap.put(name, count - 1);
		}

		for(String name: nameToCountMap.keySet()){
			return name;
		}

		return "";
	}


	public static void main(String[] args) {
		Solution250604 main = new Solution250604();
		System.out.println(main.solution(new String[] {"leo", "kiki","eden"}, new String[]{"eden", "kiki"}));
	}
}
