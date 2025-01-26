package 자바_알고리즘_문제풀이_입문.stack_queue.올바른_괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 문제 링크: https://cote.inflearn.com/contest/10/problem/05-01
 * 문제 접근 방법
 * Stack을 이용해 구현한다.
 * 여는 괄호일 경우 Stack에 푸쉬한다.
 * 닫는 괄호일 경우 Stack에서 여는 괄호를 빼낸다.
 * 이 때 반복문을 도는 동안 Stack이 빈 경우, 반복문이 끝나고 Stack이 비어 있지 않은 경우 쌍이 맞지 않다고 판단한다.
 */
public class Main250126 {
	private String solution(String str) {
		Deque<Character> stack = new ArrayDeque<>();

		for (char c : str.toCharArray()) {
			if (c == '(') {
				stack.push(c);
				continue;
			}

			// 닫는 괄호일 경우
			if (stack.isEmpty()) {
				return "NO";
			}
			stack.pop();
		}

		return stack.isEmpty() ? "YES" : "NO";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Main250126 main = new Main250126();
		System.out.println(main.solution(br.readLine()));
	}
}
