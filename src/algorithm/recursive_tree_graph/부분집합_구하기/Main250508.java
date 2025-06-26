package algorithm.recursive_tree_graph.부분집합_구하기;

/**
 * 문제
 * 3 입력이 주어졌을 때, 1 ~ 3까지의 부분집합을 구한다.
 * 문제 접근 방법
 * DFS로 접근한다.
 * 각 숫자를 선택하는 경우, 선택하지 않는 경우를 이용해서 푼다.
 *
 */

import java.io.*;
public class Main250508 {
	private static boolean[] cache;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		cache = new boolean[n + 1];
		Main250508 main = new Main250508();
		main.solution(1, n);
	}

	private void solution(int depth, int n) {
		if(depth == n + 1) {
			for(int index = 1; index <= n; index++) {
				if(cache[index]) {
					System.out.print(index + " ");
				}
			}
			System.out.println();
			return;
		}

		// 선택하는 경우
		cache[depth] = true;
		solution(depth + 1, n);

		// 선택하지 않는 경우
		cache[depth] = false;
		solution(depth + 1, n);

	}
}
