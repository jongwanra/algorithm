package 자바_알고리즘_문제풀이_입문.string.단어_뒤집기;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/01-04
 * 문제 접근
 * 1. StringBuilder를 활용해서 reverse가 가능한 걸로 알고 있다.
 */
public class Main241119 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final int n = Integer.valueOf(scanner.nextLine());
		String[] words = new String[n];
		for(int index = 0; index < n; index++) {
			words[index] = scanner.nextLine();
		}
		Main241119 main = new Main241119();

		String[] answers = main.solution2(n, words);
		for (String answer : answers) {
			System.out.println(answer);
		}

	}

	private String[] solution(int n, String[] words) {
		String[] answers = new String[n];
		for(int index = 0; index < n; index++) {
			answers[index] = new StringBuilder(words[index]).reverse().toString();
		}
		return answers;
	}

	// leftPoint, rightPoint를 가지고 Swap을 통해서 reverse하는 걸로 구현해보자.
	private String[] solution2(int n, String[] words) {
		String[] answers = new String[n];
		for(int index = 0; index < n; index++) {
			char[] targetWord = words[index].toCharArray();
			int lt = 0;
			int rt = targetWord.length - 1;

			while(lt < rt) {
				char tmp = targetWord[lt];
				targetWord[lt] = targetWord[rt];
				targetWord[rt] = tmp;
				lt++;
				rt--;
			}

			answers[index] = String.valueOf(targetWord);

		}
		return answers;
	}

}
