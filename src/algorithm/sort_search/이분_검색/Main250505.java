package algorithm.sort_search.이분_검색;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/06-08
 *
 *
 * 문제 접근 방법
 * 1. 오름차순 정렬을 시키다.
 * 2. 이분탐색으로 몇 번째 위치에 값이 있는지 구한다. (위치정보가 0부터인지, 1부터인지 조건에 명시 안되어 있음)
 *
 * 시간 복잡도: O(n log(n))
 * 공간 복잡도: O(1)
 */

import java.util.*;
import java.io.*;
public class Main250505 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		final int n = Integer.parseInt(inputs[0]);
		final int target = Integer.parseInt(inputs[1]);
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int index = 0; index < n; index++ ){
			arr[index] = Integer.parseInt(st.nextToken());
		}

		Main250505 main = new Main250505();
		System.out.println(main.solution(n, target, arr));

	}

	private int solution(int n, int target, int[] arr) {
		Arrays.sort(arr);

		int lt = 0;
		int rt = n - 1;

		while(lt <= rt) {
			final int mt = (lt + rt) / 2;
			if(arr[mt] == target) {
				return mt + 1;
			}

			if(target < arr[mt]) {
				rt = mt - 1;
				continue;
			}

			lt = mt + 1;
		}

		return -1;
	}
}
