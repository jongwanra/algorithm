package algorithm.dynamic_programming.최대_점수_구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/10-06
 *
 * 문제 접근 방법
 * 강의 내에서 중복 선택을 안하기 위해서 뒤에서 부터 dy를 채워 나간다.
 * 각 dy의 요소의 정의는 해당 제한시간이 주어졌을 때 최대 점수를 의미한다.
 */
public class Main250402 {
	static class Problem {
		int score;
		int time;

		public Problem(int score, int time) {
			this.score = score;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {
		Main250402 main = new Main250402();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int n = Integer.parseInt(st.nextToken()); // 문제 개수
		final int limitTime = Integer.parseInt(st.nextToken()); // 제한 시간
		Problem[] problems = new Problem[n];
		for(int index = 0; index < n; index++) {
			StringTokenizer stArr = new StringTokenizer(br.readLine());
			problems[index] = new Problem(Integer.parseInt(stArr.nextToken()), Integer.parseInt(stArr.nextToken()));
		}

		System.out.println(main.solution(limitTime, problems));
	}

	private int solution(int limitTime, Problem[] problems) {
		int[] dy = new int[limitTime + 1];

		for(Problem problem: problems) {
			for(int index = limitTime; index >= problem.time; index--) {
				dy[index] = Math.max(dy[index - problem.time] + problem.score, dy[index]);
			}
			System.out.println(Arrays.toString(dy));
		}
		return dy[limitTime];
	}
}
