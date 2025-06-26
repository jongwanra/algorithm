package algorithm.stack_queue.괄호문자제거;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 문제 링크: https://cote.inflearn.com/contest/10/problem/05-02
 * 문제 접근 방법
 * Stack을 이용해 구현한다.
 * 닫는 괄호가 나올 때 까지 계속 push한다.
 * 닫는 괄호가 나오면 여는 괄호가 나올 때까지 pop한다.
 * Stack에 남은걸 출력한다.
 */
public class Main250126 {
	private String solution(String str) {
		Deque<Character> stack = new ArrayDeque<>();

		for (char c : str.toCharArray()) {
			if (c != ')') {
				stack.push(c);
				continue;
			}

			// 닫는 괄호인 경우 여는 괄호가 나올때까지 pop한다.
			while (stack.pop() != '(')
				;

		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) throws IOException {
		Main250126 main = new Main250126();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(main.solution(br.readLine()));
	}
}
