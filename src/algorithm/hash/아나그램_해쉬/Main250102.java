package algorithm.hash.아나그램_해쉬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * https://cote.inflearn.com/contest/10/problem/04-02
 *
 * 문제 접근 방법
 * a 문자열을 반복문 돌 때 Map에 추가한다.
 * b 문자열을 반복문 돌 떄 Map에서 count를 감소시킨다.
 * hashMap의 values를 돌면서 카운트가 0이 아닌 경우 NO를 출력한다.
 */
public class Main250102 {
	private String solution(String aStr, String bStr) {
		Map<Character, Integer> couterMap = new HashMap<>();

		for(char ch: aStr.toCharArray()){
			Integer value = couterMap.getOrDefault(ch, 0);
			couterMap.put(ch, value + 1);
		}

		for(char ch: bStr.toCharArray()){
			Integer value = couterMap.getOrDefault(ch, 0);
			couterMap.put(ch, value - 1);
		}

		final boolean isAnagram = couterMap.values().stream()
			.allMatch((v) -> v == 0);

		return isAnagram ? "YES" : "NO";
	}
	public static void main(String[] args) throws IOException {
		Main250102 main = new Main250102();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println(main.solution(br.readLine(), br.readLine()));
	}
}
