package 자바_알고리즘_문제풀이_입문.array.소수_에라토스테네스_체;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/02-05
 *
 * 문제 접근 방법
 * 1. 자연수 N만큼 돌면서 소수를 찾는다.(소수는 나 자신으로 밖에 나눌 수 없는 수)
 * 2. 이때, 각 수의 제곱근 까지만 돌아서 소수이면 1을 증가 시킨다.
 */
public class Main241127 {

	public static void main(String[] args) {
		Main241127 main = new Main241127();
		Scanner scanner = new Scanner(System.in);
		System.out.println(main.solution2(scanner.nextInt()));
	}

	private int solution(int n) {
		int answer = 0;
		for(int num = 2; num < n; num++) {
			boolean isPrime = true;
			for(int compareNum = 2; compareNum <= Math.sqrt(num); compareNum++) {
				if(num % compareNum == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				answer++;
			}

		}
		return answer;
	}

	// 에라토스테네스의 체로 다시 한 번 풀어보자.
	// 자연수는 200,000 까지가 최대 인데, 메모리 제한은 256mb
	// 20만에 대한 boolean[]  -> 1 * 200_000 = 200,000 byte -> 200kb -> 0.2mb
	private int solution2(int n) {
		int answer = 0;

		boolean[] arr = new boolean[n];
		// 초기화
		for(int index = 2; index < n; index++) {
			arr[index] = true;
		}

		for(int num = 2; num < n; num++) {
			if(arr[num]) {
				answer++;
				for(int jNum = num + num; jNum < n; jNum += num){
					arr[jNum] = false;
				}
			}
		}

		return answer;
	}

}
