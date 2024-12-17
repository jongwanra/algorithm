package 자바_알고리즘_문제풀이_입문.string.문자열_압축;

import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/01-11
 *
 * 요약
 * 대문자인 문자열을 입력받아, 바로 오른쪽에 반복횟수를 포기하는 방법으로 문자열을 변경한다.
 * 문자열의 길이는 100 미만.
 *
 * 문제 접근 방법
 * 1. 반복문을 돌면서 특정 문자를 가르킨다.
 * 2. 2중 포문으로 반복되는 갯수를 반환 받는다.
 * 3. 반환받은 갯수를 1 제외하고 붙힌다.
 */
public class Main241124 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Main241124 main = new Main241124();
		System.out.println(main.lectureSolution(scanner.nextLine()));
	}

	// 다음 문자의 인덱스가 아니라, 반복 개수를 반환하도록 구현해보자.
	private String solution2(String s) {
		int index = 0;
		StringBuilder sb = new StringBuilder();

		while(index < s.length()) {
			final char t = s.charAt(index);
			sb.append(t);

			final int repeatedCount = fetchRepeatedCount(s, index, t);
			if(repeatedCount > 1) {
				sb.append(repeatedCount);
			}

			index += repeatedCount;
		}
 		return sb.toString();
	}

	private int fetchRepeatedCount(String s, int currentIndex, char t) {
		int count = 0;
		while(currentIndex < s.length()) {
			if(s.charAt(currentIndex) != t) {
				break;
			}
			count++;
			currentIndex++;
		}

		return count;
	}

	private String solution(String s) {
		int index = 0;
		StringBuilder sb = new StringBuilder();

		while(index < s.length()) {
			final char targetCharacter = s.charAt(index);
			sb.append(s.charAt(index));
			// 다른 문자의 인덱스를 가져온다.
			final int nextCharacterIndex = findNextCharacterIndex(s, index, targetCharacter);

			if(nextCharacterIndex == -1) {
				int count = s.length() - index;
				if(count > 1) {
					sb.append(count);
				}
				break;
			}
			int diffIndex = nextCharacterIndex - index;

			if(diffIndex > 1) {
				sb.append(diffIndex);
			}
			index = nextCharacterIndex;
		}
		return sb.toString();
	}

	private int findNextCharacterIndex(String s, int index, char targetCharacter) {
		// 현재의 문자와 다른 경우의 인덱스를 가져온다. 없으면 -1

		while(index < s.length()) {
			if(targetCharacter != s.charAt(index)) {
				return index;
			}
			index++;
		}
		return -1;
	}


	private String lectureSolution(String s) {
		s = s + " "; // 알고리즘 통하기 위한 마지막 빈문자 추가

		StringBuilder sb = new StringBuilder();
		int cnt = 1;
		for(int i = 0; i < s.length() - 1; i++) {
			if(s.charAt(i) == s.charAt(i+1)) {
				cnt++;
			}else {
				sb.append(s.charAt(i));
				if(cnt > 1){
					sb.append(cnt);
					cnt = 1; // 초기화
				}
			}
		}

		return sb.toString();
	}

}
