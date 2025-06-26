package algorithm.array.가위_바위_보;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/02-03
 *
 * 문제 설명
 * 총 N 번의 게임 진행, A가 이기면 A 출력, B가 이기면 B 출력, 비길 경우 D 출력
 * 1: 가위, 2: 바위: 3: 보
 *
 * 게임 횟수: n
 * 두 번째 줄에 A가 낸 정보
 * 세 번째 줄에 B가 낸 정보
 *
 * 접근 방법
 * 1. 입력 받기
 * 2. 가위바위보 메서드 구현
 */
public class Main241126 {
	public static void main(String[] args) {
		Main241126 main = new Main241126();
		Scanner scanner = new Scanner(System.in);

		final int n = scanner.nextInt(); // 게임 횟수
		int[] arrA = new int[n];
		int[] arrB = new int[n];

		for(int index = 0; index < n; index++) {
			arrA[index] = scanner.nextInt();
		}

		for(int index = 0; index < n; index++) {
			arrB[index] = scanner.nextInt();
		}

		List<Character> answer = main.solution2(n, arrA, arrB);

		for (Character ans : answer) {
			System.out.println(ans);
		}

	}

	private List<Character> solution(int n, int[] arrA, int[] arrB) {
		List<Character> answer = new ArrayList<>();
		for(int index = 0; index < n; index++) {
			// 비길 경우
			if(arrA[index] == arrB[index]) {
				answer.add('D');
				continue;
			}
			// 1: 가위, 2: 바위: 3: 보
			// A가 가위
			if(arrA[index] == 1) {
				// B: 바위
				if(arrB[index] == 2) {
					answer.add('B');
				}
				// B: 보
				else {
					answer.add('A');
				}

			}
			// A가 바위
			else if(arrA[index] == 2 ) {
				// B: 가위
				if(arrB[index] == 1) {
					answer.add('A');
				}else {
					// B: 보
					answer.add('B');
				}
			}
			// A가 보
			else {
				// B: 바위
				if(arrB[index] == 2) {
					answer.add('A');
				}else {
					// B:
					answer.add('B');
				}
			}
		}
		return answer;
	}


	// switch 문으로 풀어보자.
	private List<Character> solution2(int n, int[] arrA, int[] arrB) {
		List<Character> answer = new ArrayList<>();
		for(int index = 0; index < n; index++) {
			// 비김
			if(arrA[index] == arrB[index]) {
				answer.add('D');
				continue;
			}
			switch (arrA[index]){
				// 가위
				case 1:
					// B: 바위
					if(arrB[index] == 2) answer.add('B');
					// B: 보
					else answer.add('A');
					break;
				// 바위
				case 2:
					// B: 가위
					if(arrB[index] == 1) answer.add('A');
					else answer.add('B');
					break;
				// 보
				default:
					if(arrB[index] == 2) answer.add('A');
					else answer.add('B');
					break;
			}

		}
		return answer;
	}

	// a를 기준으로  풀어보자.
	// 1: 가위, 2: 바위: 3: 보
	private List<Character> solution3(int n, int[] arrA, int[] arrB) {
		List<Character> answer = new ArrayList<>();
		for(int index = 0; index < n; index++) {
			// 비김
			if(arrA[index] == arrB[index]) {
				answer.add('D');
				continue;
			}
			if(arrA[index] == 1 && arrB[index] == 3) {
				answer.add('A');
			}else if(arrA[index] == 2 && arrB[index] == 1) {
				answer.add('A');
			}else if(arrA[index] == 3 && arrB[index] == 2) {
				answer.add('A');
			}else {
				answer.add('B');
			}

		}
		return answer;
	}
}
