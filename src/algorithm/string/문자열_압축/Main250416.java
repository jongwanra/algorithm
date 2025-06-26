package algorithm.string.문자열_압축;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/01-11
 *
 * 문제 접근 방법
 * 구현 문제로 보인다.
 * 문자열의 길이는 100을 넘지 않기 때문에 O(n^2) 시간 복잡도로 충분히 구현 가능하다.
 *
 * 시간 복잡도: O(n)
 * 공간 복잡도: O(n)
 */

import java.io.*;

public class Main250416 {

	public static void main(String[] args) throws IOException {
		Main250416 main = new Main250416();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println(main.solution2(br.readLine()));
	}

	private String solution(String str) {
		final int length = str.length();
		StringBuilder sb = new StringBuilder();
		for(int index = 0; index < length; index++) {
			char current = str.charAt(index);
			sb.append(current);

			int count = 1;
			int targetIndex = index + 1;

			while(targetIndex < length) {
				char target = str.charAt(targetIndex);
				if(current != target) {
					break;
				}

				count++;
				targetIndex++;
			}

			index = targetIndex - 1;

			if(count > 1) {
				sb.append(count);
			}
		}

		return sb.toString();
	}

	private String solution2(String s) {
		StringBuilder sb = new StringBuilder();

		s = s  + " ";
		int count = 1;
		for(int index = 0; index < s.length() - 1; index++) {
			if(s.charAt(index) == s.charAt(index + 1)){
				count++;
				continue;
			}

			sb.append(s.charAt(index));
			if(count > 1){
				sb.append(count);
			}
			count = 1;
		}
		return sb.toString();
	}
}
