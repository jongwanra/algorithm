package algorithm.dynamic_programming.최대_점수_구하기;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/10-06
 *
 * 문제당 점수와 푸는데 걸린 시간이 주어짐.
 * 최대 점수를 얻을 수 있도록 해야 함.
 * 제한 시간 안에 얻을 수 있는 최대 점수 출력
 *
 * 문제 접근 방법
 * DFS로 풀었을 경우의 시간 복잡도 = O(2^N) 시간이 걸리기 때문에 제한 시간이 초과된다.
 *
 * 중복으로 선택할 수 없는 냅색 알고리즘 문제
 *
 * 1. Problem class를 구성한다.
 * 2. 각 문제당 뒤에서 부터 포문을 돌면서 각 제한 시간당 최대값을 구한다.
 *
 * 시간 복잡도: O(N * M) N: 문제 개수, M: 제한 시간
 * 공간 복잡도: O(M)
 */
import java.util.*;
import java.io.*;
public class Main250529 {
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
		final int problemNum = Integer.parseInt(inputs[0]);
		final int limitedTime = Integer.parseInt(inputs[1]);
		Problem[] problems = new Problem[problemNum];

		for(int index = 0; index < problemNum; index++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			problems[index] = new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Main250529 main = new Main250529();
		System.out.println(main.solution(problemNum, limitedTime, problems));
	}

	private int solution(int problemNum, int limitedTime, Problem[] problems) {
		int[] dyScores = new int[limitedTime + 1];

		for(Problem problem: problems) { // 문제 개수 O(problemNum)
			// 중복 선택 방지를 위해서 뒤에서 부터 포문 동작
			// O(limitedTime)
			for(int time = limitedTime; time >= problem.time; time--) {
				dyScores[time] = Math.max(dyScores[time - problem.time] + problem.score, dyScores[time]);
			}
		}
		return dyScores[limitedTime];
	}
}
