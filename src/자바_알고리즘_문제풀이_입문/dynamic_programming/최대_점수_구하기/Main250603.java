package 자바_알고리즘_문제풀이_입문.dynamic_programming.최대_점수_구하기;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/10-06
 *
 * 각 문제당 점수와 푸는데 걸리는 시간이 주어진다.
 * 제한시간 m안에 n개의 문제 중 최대 점수를 얻어야 함. (유형당 한개의 문제만 풀 수 있음. 중복 x)
 *
 * 문제 접근 방법
 * DFS로 접근할 경우 풀 수는 있지만 시간 복잡도에서 걸림 ( O(2^N))
 *
 * 제한 시간을 배열로 만든다.
 * 제한 시간 배열에 제한 시간 동안의 문제당 최대 점수를 비교하여 뒤에서 부터 기록한다.
 */
import java.util.*;
import java.io.*;

public class Main250603 {
	static class Problem {
		int score;
		int time;

		public Problem(int score, int time) {
			this.score = score;
			this.time = time;
		}


	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		final int n = Integer.parseInt(inputs[0]);
		final int limitTime = Integer.parseInt(inputs[1]);
		Problem[] problems = new Problem[n];

		for(int index = 0; index < n; index++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			final int score = Integer.parseInt(st.nextToken());
			final int time = Integer.parseInt(st.nextToken());
			problems[index] = new Problem(score, time);
		}

		Main250603 main = new Main250603();
		System.out.println(main.solution(n, limitTime, problems));
	}

	private int solution(int n, int limitTime, Problem[] problems) {
		int[] maxScores = new int[limitTime + 1];

		for(Problem problem: problems) {
			for(int index = limitTime; index >= problem.time; index--) {
				maxScores[index] = Math.max(maxScores[index], maxScores[index - problem.time] + problem.score);
			}
		}

		return maxScores[limitTime];
	}
}
