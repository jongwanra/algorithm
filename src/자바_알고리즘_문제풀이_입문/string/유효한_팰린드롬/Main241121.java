package 자바_알고리즘_문제풀이_입문.string.유효한_팰린드롬;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/01-08
 *
 * 요약
 * 앞에서 읽을 때와 뒤에서 읽을 때 회문인 문자열 팰린드롬이라고 한다.
 * 팰린드롬이면 YES 아니면 NO 출력
 *
 * 제약 조건
 * 알파벳만 회문 검사 나머지 무시
 * 대소문자 구분 X
 *
 *
 * 1. 알파벳 제외 문자 전부 제거
 * * foundtimestudyYdutsemitDnuof
 * 2. LinkedList를 이용해서 양쪽에서 빼낸 결과를 비교한다.
 */
public class Main241121 {
	public static void main(String[] args) {
		Main241121 main = new Main241121();
		Scanner scanner = new Scanner(System.in);
		System.out.println(main.solution(scanner.nextLine()));

	}
	private String solution(String str) {
		List<Character> list = new LinkedList<>();

		// 1. 알파벳 제외 문자 전부 제거
		for(int index = 0; index < str.length(); index++) {
			if(Character.isAlphabetic(str.charAt(index))) {
				list.add(Character.toUpperCase(str.charAt(index)));
			}
		}


		while(list.size() >= 2) {
			Character firstChar = list.remove(0);
			Character lastChar = list.remove(list.size() - 1);
			if(!firstChar.equals(lastChar)) {
				return "NO";
			}
		}

		return "YES";
	}

	private String lectureSolution(String s) {
		s = s.toUpperCase().replaceAll("^[A-Z]", "");
		String tmp = new StringBuilder(s).reverse().toString();

		return s.equals(tmp) ? "YES" : "NO";
	}
}
