package 자바_알고리즘_문제풀이_입문.hash.모든_아나그램_찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 문제 링크: https://cote.inflearn.com/contest/10/problem/04-04
 * 문제 접근 방법
 * 1. T 문자열에 HashMap을 이용해서 알파벳당 갯수를 나타낸다.
 * 2. lt와 rt를 변수로 두고 반복문을 돌면서 갯수에 대한 카운팅을 한다.
 * 3. 전체가 0일 경우 갯수를 출력한다.
 */
public class Main250120 {
	private int solution(String s, String t) {
		Map<Character, Integer> store = generateOriginStore(t);

		int lt = 0;
		int answer = 0;
		for(int rt = 0; rt < s.length(); rt++){
			final int distance = rt - lt + 1;
			final char targetRt = s.charAt(rt);
			// 만약에 targetC가 존재하지 않는 값이라면?
			Integer targetRtValue = store.get(targetRt);
			if(targetRtValue == null || targetRtValue <= 0) {
				store = generateOriginStore(t);
				lt = rt + 1;
				continue;
			}
			store.put(targetRt, targetRtValue - 1);
			if(distance < t.length()) {
				continue;
			}

			answer = increaseAnswerCountIfAllMatched(store, answer);
			char targetLt = s.charAt(lt);
			store.put(targetLt, store.get(targetLt) + 1);
			lt++;

		}

		return answer;
	}

	private int increaseAnswerCountIfAllMatched(Map<Character, Integer> store, Integer answer) {
		final boolean isAllMatched = store.values()
			.stream()
			.allMatch(v -> v == 0);

		if(isAllMatched) {
			answer++;
		}

		return answer;
	}

	public Map<Character, Integer> generateOriginStore(String s) {
		Map<Character, Integer> store = new HashMap<>();
		for(char c: s.toCharArray()){
			Integer value = store.getOrDefault(c, 0);
			store.put(c, ++value);
		}

		return store;
	}

	public static void main(String[] args) throws IOException {
		Main250120 main = new Main250120();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(main.solution(br.readLine(), br.readLine()));
	}
}
