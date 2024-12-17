package 자바_알고리즘_문제풀이_입문.string.가장_짧은_문자거리;

import java.time.Period;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/01-10
 *
 * 문제
 * 문자열:s, 문자 t가 주어졌을 떄 각 문자가 문자 t와 떨어진 최소 거리 출력
 * (전부 소문자로 가정)
 *
 * 문제 접근 방법
 * 1. 최소 거리를 담을 배열을 만든다.
 * 2. indexOf를 통해 대상이 되는 index를 찾는다.(반복)
 * 3. Min을 반복해서 넣는다.
 *
 */
public class Main241123 {
	public static void main(String[] args) {
		Main241123 main = new Main241123();
		Scanner scanner = new Scanner(System.in);
		String[] s = scanner.nextLine().split(" ");
		int[] answers = main.solution2(s[0], s[1].charAt(0));
		for (int answer : answers) {
			System.out.print(answer + " ");
		}
	}

	// 1. 최소 거리를 담은 배열을 만든다.
	// 2. 대상으로부터의 모든 거리의 최소값들을 구한다.
	private int[] solution(String s, char t) {
		int[] distances = new int[s.length()];

		// 초기화
		for(int index = 0; index < s.length(); index++) {
			distances[index] = Integer.MAX_VALUE;
		}



		for(int index = 0; index < s.length(); index++) {
			if(s.charAt(index) != t) {
				continue;
			}

			final int currentTargetIndex = index;
			for(int j = 0; j < s.length(); j++) {
				final int distance = Math.abs(currentTargetIndex - j);
				distances[j] = Math.min(distances[j], distance);
			}
		}
		return distances;
	}


	// 1. 왼쪽에서 부터 반복문을 돌면서, 대상 문자로 부터 오른쪽으로 최소 거리를 구한다.
	// 2. 오른쪽에서 부터 반복문을 돌면서, 대상 문자로 부터 왼쪽으로 최소 거리를 구한다.(이때 비교하면서 최소값을 넣는다.)
	private int[] solution2(String s, char t){
		int[] distances = new int[s.length()];
		// 최대값으로 초기화
		for(int index = 0; index < s.length(); index++) {
			distances[index] = Integer.MAX_VALUE;
		}

		// 왼쪽에서부터 대상의 오른쪽 거리를 구한다.
		int distance = Integer.MAX_VALUE;
		for(int index = 0; index < s.length(); index++) {
			if(s.charAt(index) == t){
				distance = 0;
			}

			distances[index] = distance;

			// 다음 거리 증가분
			if(distance != Integer.MAX_VALUE){
				distance++;
			}
		}

		distance = Integer.MAX_VALUE;

		for(int index = s.length() - 1; index >= 0; index--) {
			if(s.charAt(index) == t) {
				distance = 0;
			}

			distances[index] = Math.min(distances[index], distance);

			// 다음 거리 증가분
			if(distance != Integer.MAX_VALUE) {
				distance++;
			}
		}
		return distances;
	}

	private int[] lectureSolution(String s, char t ){
		int[] answer= new int[s.length()];
		int p = 1000;
		for(int i = 0; i< s.length(); i++) {
			if(s.charAt(i) == t){
				p = 0;
				answer[i] = p;
			}else {
				p++;
				answer[i] = p;
			}
		}

		p = 1000;
		for(int i = s.length() - 1; i >= 0; i--){
			if(s.charAt(i) == t) {
				p = 0;
			}else {
				p++;
				answer[i] = Math.min(answer[i], p);
			}
		}
		return answer;
	}
}
