package algorithm.sort_search.삽입_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  문제 링크: https://cote.inflearn.com/contest/10/problem/06-03
 *  문제 접근 방법
 *  삽입 정렬을 이용해 오름차순으로 정렬한다.
 *
 *  참고 링크
 *  https://gmlwjd9405.github.io/2018/05/06/algorithm-insertion-sort.html
 */
public class Main250203 {
	public static void main(String[] args) throws IOException {
		Main250203 main = new Main250203();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int index = 0; index <n; index++){
			arr[index] = Integer.parseInt(st.nextToken());
		}

		int[] answer = main.solution(n, arr);
		for(int ans: answer){
			System.out.print(ans + " ");
		}
	}

	private int[] solution(int n, int[] arr) {
		for(int targetPos = 1; targetPos < n; targetPos++) {
			final int target = arr[targetPos];
			int comparePos = 0;
			for(comparePos = targetPos - 1; comparePos >= 0; comparePos--) {
				final int compare = arr[comparePos];
				if(target < compare) {
					arr[comparePos + 1] = compare;
					continue;
				}
				break;
			}
			arr[comparePos + 1] = target;
		}

		return arr;
	}
}
