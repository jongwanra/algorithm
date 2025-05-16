package 자바_알고리즘_문제풀이_입문.recursive_tree_graph.조합_구하기;

/**
 * 문제
 * https://www.inflearn.com/courses/lecture?courseId=326750&type=LECTURE&unitId=73404&subtitleLanguage=ko
 *
 * 문제 접근 방법
 * 조합의 경우의 수를 구하는 문제이다.
 */

import java.io.*;
public class Main250516 {
	private static int[] combi;
	private static int n;
	private static int r;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		n = Integer.parseInt(inputs[0]);
		r = Integer.parseInt(inputs[1]);

		combi = new int[r];

		Main250516 main = new Main250516();
		main.solution(0, 1);
	}

	private void solution(int depth, int start) {
		if(depth == r) {
			for(int x:combi) {
				System.out.print(x + " ");
			}
			System.out.println();
			return;
		}

		for(int num = start; num <= n; num++) {
			combi[depth] = num;
			solution(depth + 1, num + 1);
		}

	}
}
