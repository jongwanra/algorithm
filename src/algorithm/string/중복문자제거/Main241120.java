package algorithm.string.중복문자제거;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://cote.inflearn.com/contest/10/problem/01-06
 *
 * 요약
 * 소문자 문자열 중 중복 문자 제거 이후 출력
 * 문자열 길이 <= 100
 *
 * 문제 접근 방법
 * 1. 입력한 순서를 보장해주는 LinkedHashSet을 이용해서 문제를 접근해본다.

 */
public class Main241120 {
	public static void main(String[] args) {
		Main241120 main = new Main241120();
		Scanner scanner = new Scanner(System.in);

		System.out.println(main.solution(scanner.nextLine()));


	}

	private String solution(String input) {
		Set<Character> uniqueCharSet = new LinkedHashSet<>();
		for(int index = 0; index < input.length(); index++) {
			uniqueCharSet.add(input.charAt(index));
		}
		StringBuilder sb = new StringBuilder();
		for (Character c : uniqueCharSet) {
			sb.append(c);
		}
		return sb.toString();
	}

	// 중복 제거를 indexOf method를 통해 접근
	// 현재 가리키는 알파벳의 위치와 이전에 해당 알파벳이 처음 등장했을 때의 위치가 같을 경우 중복이 아니라고 판단.
	private String lectureSolution(String str) {
		String answer = "";
		for(int i = 0; i < str.length(); i++) {
			char target = str.charAt(i);
			// System.out.println(target + " " + i + " " + str.indexOf(target));
		    if(str.indexOf(target) == i) {
				answer += target;
			}
		}
		return answer;
	}
}
