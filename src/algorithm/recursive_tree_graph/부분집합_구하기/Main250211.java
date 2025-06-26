package algorithm.recursive_tree_graph.부분집합_구하기;

import java.util.ArrayList;
import java.util.List;

/**
 * 문제
 * 자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램을 작성하세요.
 *
 * 문제 접근 방법
 * DFS를 이용한다.
 * 3이란 수를 하나씩 줄여가며 포함 시킬여부를 정한다.
 * 수가 0이되면 배열을 출력한다.
 */

/**
 *
 * dfs(1, true)
 * dfs(2, true)
 * dfs(3, true)
 */

public class Main250211 {
	private static List<Integer> cache = new ArrayList<>();
	private static int num = 10;

	private void dfs(int n) {
		if(n > num) {
			System.out.println(cache);
			return;
		}

		cache.add(n);
		dfs(n +1);
		cache.remove(cache.size() - 1);
		dfs(n + 1);

	}

	public static void main(String[] args) {
		Main250211 main = new Main250211();
		main.dfs(1);

	}
}
