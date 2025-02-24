package 자바_알고리즘_문제풀이_입문.recursive_tree_graph.조합_구하기;

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
public class Main250224 {
	private static boolean[] visited;
	private static int n;
	private static int r;
	public static void main(String[] args) throws IOException {
		Main250224 main = new Main250224();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		visited = new boolean[n + 1];
		main.dfs(0, 0);

	}

	private void dfs(int depth, int selected) {
		if(depth == r) {
			for(int index = 1; index <= n; index++) {
				if(visited[index]) {
					System.out.print(index + " ");
				}
			}
			System.out.println();
			return;
		}

		for(int num = selected + 1; num <= n; num++) {
			if(visited[num]) {
				continue;
			}

			visited[num] = true;
			dfs(depth + 1, num);
			visited[num] = false;

		}
	}
}
