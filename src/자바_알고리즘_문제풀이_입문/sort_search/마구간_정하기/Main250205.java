package 자바_알고리즘_문제풀이_입문.sort_search.마구간_정하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/06-10
 *
 * 문제 접근 방법
 * n: 마구간 개수
 * c: 말의 마리 수
 *
 * 결정 알고리즘의 기준은 거리로 정한다.
 * 거리는 최소 좌표 / 최대 좌표를 기준으로 정한다.
 * 가능한지 여부에 따라 이분 검색으로 최소 거리를 측정한다.
 *
 */
public class Main250205 {
	public static void main(String[] args) throws IOException {
		Main250205 main = new Main250205();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		final int stallCount = Integer.parseInt(st.nextToken());
		final int horseCount = Integer.parseInt(st.nextToken());
		int[] arr = new int[stallCount];
		StringTokenizer arrSt = new StringTokenizer(br.readLine());
		for(int index = 0; index < stallCount; index++) {
			arr[index] = Integer.parseInt(arrSt.nextToken());
		}
		System.out.println(main.solution(stallCount, horseCount, arr));

	}

	private int solution(int stallCount, int horseCount, int[] arr) {
		int answer = 0;
		Arrays.sort(arr);
		int minDistance = 1;
		int maxDistance = arr[stallCount - 1] - arr[0];

		while(minDistance <= maxDistance) {
			final int targetDistance = (minDistance + maxDistance) / 2;
			if(isDistancePossible(arr, horseCount, targetDistance)) {
				answer = targetDistance;
				minDistance = targetDistance + 1;
				continue;
			}

			maxDistance = targetDistance - 1;
		}
		return answer;
	}

	private boolean isDistancePossible(int[] arr, int horseCount, int targetDistance) {
		int horsePlacedCount = 1;
		int lastHorsePlacedPos = 0;
		for(int index = 1; index < arr.length; index++) {
			if(horseCount == horsePlacedCount) {
				return true;
			}
			final int distance = arr[index] - arr[lastHorsePlacedPos];
			if(distance < targetDistance) {
				continue;
			}
			horsePlacedCount++;
			lastHorsePlacedPos = index;
		}

		return horseCount == horsePlacedCount;
	}
}
