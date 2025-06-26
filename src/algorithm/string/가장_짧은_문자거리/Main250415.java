package algorithm.string.가장_짧은_문자거리;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/01-10
 *
 *
 * 문제 접근 방법
 * 문자열 길이가 100을 넘지 않기 때문에 n^2 시간 복잡도로도 무방하다.
 *
 * 반복문을 돌면서 target을 찾는다.
 * 찾은 이후에 거리를 계산하고 최소값을 배열에 저장한다.
 * 결과를 출력한다.
 */
import java.io.*;
import java.util.*;

public class Main250415 {
	private static int MAX_DISTANCE = 100;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		final String str = st.nextToken();
		final Character target = st.nextToken().charAt(0);

		Main250415 main = new Main250415();
		for(int answer: main.solution2(str, target)){
			System.out.print(answer + " ");
		}

	}
	// 시간 복잡도: O(n^2)
	// 공간 복잡도: O(n)
	private int[] solution(String str, Character target) {
		final int length = str.length();
		int[] answer = new int[length];
		Arrays.fill(answer, Integer.MAX_VALUE);

		for(int index = 0; index < length; index++) {
			if(str.charAt(index) != target) {
				continue;
			}

			for(int targetIndex = 0; targetIndex < length; targetIndex++) {
				answer[targetIndex] = Math.min(answer[targetIndex], Math.abs(targetIndex - index));
			}
		}

		return answer;
	}

	// 시간 복잡도: O(n)
	// 공간 복잡도: O(n)
	private int[] solution2(String str, Character target) {
		final int length = str.length();
		int[] answer = new int[length];
		Arrays.fill(answer, Integer.MAX_VALUE);

		int distance = MAX_DISTANCE;
		for(int index = 0; index < length; index++) {
			if(str.charAt(index) == target) {
				distance = 0;
			}
			answer[index] = distance++;
		}


		distance = MAX_DISTANCE;
		for(int index = length - 1; index >= 0; index--) {
			if(str.charAt(index) == target) {
				distance = 0;
			}

			answer[index] = Math.min(answer[index], distance);
			distance++;
		}
		return answer;
	}
}
