package algorithm.sort_search.마구간_정하기;

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
 * 마구간 좌표가 중복되는 일은 없다.
 * C 마리의 말을 가지고 있다.
 * 마구간에는 한 마리의 말만 넣을 수 있다.
 * 가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치한다.
 *
 * 가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치해야 한다.
 * 거리를 기준점으로 Binary Search를 진행한다.
 *
 */
public class Main250206 {
	public static void main(String[] args) throws IOException {
		Main250206 main = new Main250206();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer stArr = new StringTokenizer(br.readLine());

		final int stallNum = Integer.parseInt(st.nextToken());
		final int horseNum = Integer.parseInt(st.nextToken());
		int[] arr = new int[stallNum];
		for(int index = 0; index < stallNum; index++) {
			arr[index] = Integer.parseInt(stArr.nextToken());
		}
		System.out.println(main.solution(stallNum, horseNum, arr));
	}

	private int solution(int stallNum, int horseNum, int[] stallCoordinates) {
		Arrays.sort(stallCoordinates);
		int leftDistance = 1;
		int rightDistance = stallCoordinates[stallNum - 1] - stallCoordinates[0];
		int answer = 0;

		while(leftDistance <= rightDistance) {
			final int distance = (leftDistance + rightDistance) / 2;

			if(isPossibleDistance(stallCoordinates, horseNum, distance)) {
				leftDistance = distance + 1;
				answer = distance;
				continue;
			}

			rightDistance = distance - 1;
		}

		return answer;
	}

	private boolean isPossibleDistance(int[] stallCoordinates, int horseNum, int distance) {
		int placedHorseCount = 1;
		int placedLastStallCoordinate = stallCoordinates[0];

		for(int index = 1; index < stallCoordinates.length; index++) {
			final int stallCoordinate = stallCoordinates[index];
			int currentDistance = stallCoordinate - placedLastStallCoordinate;
			if(currentDistance >= distance) {
				placedLastStallCoordinate = stallCoordinates[index];
				placedHorseCount++;
			}
		}
		return placedHorseCount >= horseNum;
	}
}
