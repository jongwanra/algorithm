package 자바_알고리즘_문제풀이_입문.sort_search.마구간_정하기;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/06-10
 *
 * 가장 가까운 두 말의 거리가 최대가 되게 말을 배치 한다.
 * c 마리의 말을 n개의 마구간에 배치했을 때 가장 가까운 두 말의 거리 최대값을 출력
 *
 * 문제 접근 방법
 * 마구간 거리에 대해 이분 탐색을 진행한다.
 * 마구간의 최소 거리: 각 거리간 최소 값.
 * 마구간의 최대 거리: 최대값 - 최소값
 *
 * 시간 복잡도: O(n log d) 최대 거리는 1,000,000,000 이므로 정렬 알고리즘의 n보다 길다.
 * 공간 복잡도: O(1)
 */

import java.util.*;
import java.io.*;
public class Main250507 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		final int n = Integer.parseInt(inputs[0]);
		final int horseCount = Integer.parseInt(inputs[1]);

		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int index = 0; index  < n; index++) {
			arr[index] = Integer.parseInt(st.nextToken());
		}


		Main250507 main = new Main250507();
		System.out.println(main.solution(n, horseCount, arr));

	}

	private int solution(int n, int horseCount, int[] arr) {
		int answer = Integer.MIN_VALUE;
		Arrays.sort(arr);
		int minDistance = 1;
		int maxDistance = arr[n - 1] - arr[0];
		while(minDistance <= maxDistance ){
			// O(log d)
			final int targetDistance = (minDistance + maxDistance) / 2;
			// o(n)
			if(isPossibleDistance(horseCount, arr, targetDistance)) {
				minDistance = targetDistance + 1;
				answer = Math.max(answer, targetDistance);
				continue;
			}

			maxDistance = targetDistance - 1;

		}

		return answer;
	}

	private boolean isPossibleDistance(int horseCount, int[] arr, int targetDistance) {
		int usedCount = 1;
		int recentUsed = arr[0];
		for(int index = 1; index < arr.length; index++) {
			if(arr[index] - recentUsed >= targetDistance) {
				usedCount++;
				recentUsed = arr[index];
			}
		}

		return usedCount >= horseCount;
	}
}
