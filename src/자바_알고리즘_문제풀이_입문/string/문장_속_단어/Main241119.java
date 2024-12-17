package 자바_알고리즘_문제풀이_입문.string.문장_속_단어;

import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/01-03
 * 접근 방법
 * 1. split을 통해 String[] 로 만든다.
 * 2. 길이가 가장 긴 result를 기록한다. (동일한 길이의 단어일 경우 이미 기록한 단어 우선)
 */
public class Main241119 {
	// split을 이용해서 구현해보자.
	private String solution(String sentence) {
		String[] splitSentence = sentence.split(" ");
		String result = "";
		for (String word : splitSentence) {
			if(result.length() < word.length()) {
				result = word;
			}
		}
		return result;
	}
	// indexOf, Substring으로도 구현해보자.
	private String solution2(String sentence) {
		String answer = "";
		while(true) {
			final int blankSpaceIndex = sentence.indexOf(" ");
			if(blankSpaceIndex == -1) {
				if(answer.length() < sentence.length()) {
					answer = sentence;
				}
				break;
			}

			String targetWord = sentence.substring(0, blankSpaceIndex);
			if(answer.length() < targetWord.length()) {
				answer = targetWord;
			}
			sentence = sentence.substring(blankSpaceIndex + 1);
		}
		return answer;
	}
	private String lectureSolution(String str) {
		String answer = "";
		int m= Integer.MIN_VALUE;
		int pos;

		// 이런 방식으로 while 조건문을 사용할 수 있구나.
		// (pos = str.indexOf(" ")) != -1
		while ((pos = str.indexOf(" ")) != -1) {
			String targetWord = str.substring(0, pos);
			if(targetWord.length() > m) {
				m = targetWord.length();
				answer = targetWord;
			}
			str = str.substring(pos + 1);
		}

		if(str.length() > answer.length()) {
			answer = str;
		}
		return answer;
	}
	public static void main(String[] args) {
		Main241119 main = new Main241119();
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		System.out.println(main.solution2(input));;

	}
}
