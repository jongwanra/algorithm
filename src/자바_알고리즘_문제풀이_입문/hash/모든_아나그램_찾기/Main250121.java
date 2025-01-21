package 자바_알고리즘_문제풀이_입문.hash.모든_아나그램_찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 강의의 알고리즘 접근 방법 설명만 듣고 문제를 다시 풀어봄.
 * 문제 링크: https://cote.inflearn.com/contest/10/problem/04-04
 *
 * 문제 접근 방법
 * Map의 equals()를 통해서 anagram과 window를 비교하면서 카운팅한다.
 */
public class Main250121 {
	private int solutionAfterLecture(String s, String t) {
		int answer = 0;
		final int windowSize = t.length();
		Map<Character, Integer> anagramMap = new HashMap<>();
		Map<Character, Integer> windowMap = new HashMap<>();
		for (char c : t.toCharArray()) {
			anagramMap.put(c, anagramMap.getOrDefault(c, 0) + 1);
		}

		for (int index = 0; index < windowSize - 1; index++) {
			windowMap.put(s.charAt(index), windowMap.getOrDefault(s.charAt(index), 0) + 1);
		}

		int lt = 0;
		for (int rt = windowSize - 1; rt < s.length(); rt++) {
			final char rtTarget = s.charAt(rt);
			windowMap.put(rtTarget, windowMap.getOrDefault(rtTarget, 0) + 1);
			if (windowMap.equals(anagramMap)) {
				answer++;
			}

			final char ltTarget = s.charAt(lt);
			windowMap.put(ltTarget, windowMap.getOrDefault(ltTarget, 0) - 1);
			if (windowMap.get(ltTarget) == 0) {
				windowMap.remove(ltTarget);
			}
			lt++;
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		Main250121 main = new Main250121();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(main.solutionAfterLecture(br.readLine(), br.readLine()));
	}
}
