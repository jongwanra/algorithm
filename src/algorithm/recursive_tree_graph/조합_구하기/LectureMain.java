package algorithm.recursive_tree_graph.조합_구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제
 * 1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 M개를 뽑는 방법의 수를 출력하는 프로그램을 작성하세요.
 *
 * 문제 접근 방법
 * DFS로 푼다.
 * 1 ~ N 까지를 방문 했다는 visited 배열과 depth를 통해서 전부 방문한 경우에 출력한다.
 */
public class LectureMain {
	private static int[] combi;
	private static int n;
	private static int r;
	public static void main(String[] args) throws IOException {
		LectureMain main = new LectureMain();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		combi = new int[r];
		main.dfs(0, 1);

	}

	private void dfs(int depth, int start) {
		if(depth == r) {
			for(int x: combi) {
				System.out.print(x + " ");
			}
			System.out.println();
			return;
		}

		for(int num = start; num <= n; num++) {
			combi[depth] = num;
			dfs(depth + 1, num + 1);

		}
	}
}
