package 자바_알고리즘_문제풀이_입문.string.문자_찾기;

import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/01-01
 *
 * 접근
 * 1. 문자열 1개 입력 받음.
 * 2. 문자열을 반복문 돌면서 몇 개 존재 하는지 찾음(대/소문자 구분 X)
 */
public class Main241115 {
	private int solution(String str, char t) {
		str = str.toLowerCase();
		t  = Character.toLowerCase(t);

		int result = 0;
		for (char ch : str.toCharArray()) {
			if(ch == t){
				result++;
			}
		}

		return result;
	}

	private int lectureSolution(String str, char t) {
		int answer = 0;

		str = str.toUpperCase();
		t = Character.toUpperCase(t); // 아 이런 방식이 있구나
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == t) {
				answer++;
			}
		}
		return answer;
	}

	private int lectureSolution2(String str, char t) {
		int answer = 0;

		str = str.toUpperCase();
		t = Character.toUpperCase(t);

		for(char s: str.toCharArray()){
			if(s == t) {
				answer++;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Main241115 main = new Main241115();
		Scanner scanner = new Scanner(System.in);

		// 문자열 입력
		String str = scanner.nextLine();
		char ch = scanner.nextLine().charAt(0);

		System.out.println(main.lectureSolution(str, ch));
		System.out.println(main.lectureSolution(str, ch));
	}
}
