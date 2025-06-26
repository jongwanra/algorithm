package algorithm.recursive_tree_graph.합이_같은_부분집합;

import java.util.Scanner;

public class LectureMain {
	static String answer = "NO";
	static int n, total = 0;
	boolean flag = false;

	public static void main(String[] args) {

		LectureMain main = new LectureMain();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
			total += arr[i];
		}
		main.dfs(0, 0, arr);
		System.out.println(answer);

	}

	private void dfs(int level, int sum, int[] arr) {
		if(flag) {
			return;
		}
		if(sum > total /2) {
			return;
		}

		if(level == n) {
			if((total - sum) == sum) {
				answer = "YES";
				flag=true;
			}

		} else {
			dfs(level + 1, sum + arr[level], arr);
			dfs(level + 1, sum, arr);
		}

	}
}
