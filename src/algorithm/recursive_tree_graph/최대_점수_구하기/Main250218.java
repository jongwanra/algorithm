package algorithm.recursive_tree_graph.최대_점수_구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/08-03
 *
 * 문제 접근 방법
 * n: 문제 개수, M: 제한 시간
 * 이후 부터, 문제를 풀었을 때의 점수, 걸리는 시간
 * 제한 시간 안에 얻을 수 있는 최대 점수를 출력해야함.
 *
 * 최대 점수를 구하는 문제. 완전 탐색 DFS로 구현한다.
 * Problem Class를 맏는다.
 */
public class Main250218 {
	private static int limitedTime; // 제한 시간
	private static int n; // 문제의 개수
	private static Problem[] problems;
	private static int answer = Integer.MIN_VALUE;
	static class Problem {
		int score;
		int time;

		public Problem(int score, int time) {
			this.score = score;
			this.time = time;
		}


	}
	public static void main(String[] args) throws IOException {
		Main250218 main = new Main250218();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		limitedTime = Integer.parseInt(st.nextToken());

		problems = new Problem[n];
		for(int index = 0; index < n; index++) {
			StringTokenizer stInLoop = new StringTokenizer(br.readLine());
			problems[index] = new Problem(Integer.parseInt(stInLoop.nextToken()), Integer.parseInt(stInLoop.nextToken()));
		}

		main.dfs(0, 0, 0);
		System.out.println(answer);

	}

	private void dfs(int depth, int timeSum, int scoreSum) {
		if(timeSum > limitedTime) {
			return;
		}

		if(depth == n) {
			answer = Math.max(scoreSum, answer);
			return;
		}

		dfs(depth + 1, timeSum + problems[depth].time, scoreSum + problems[depth].score);
		dfs(depth + 1, timeSum, scoreSum);
	}
}
