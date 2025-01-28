package 자바_알고리즘_문제풀이_입문.stack_queue.후위식_연산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 문제 링크: https://cote.inflearn.com/contest/10/problem/05-04
 * 문제 접근 방법
 * 숫자일 경우 stack에 push 한다.
 * 연산자가 들어올 경우 pop을 2번 하여 숫자를 뽑고  두 개의 숫자와 연산식을 더한 값을 stack에 다시 push 한다.
 * 마지막 값을 pop 하여 결과를 출력한다.
 */
public class Main250128 {
	private int solution(String str) {
		Deque<Integer> stack = new ArrayDeque<>();

		for (char c : str.toCharArray()) {
			if (isOperation(c)) {
				Integer backwardNum = stack.pop();
				Integer forwardNum = stack.pop();
				if (c == '+') {
					stack.push(forwardNum + backwardNum);
					continue;
				}
				if (c == '-') {
					stack.push(forwardNum - backwardNum);
					continue;
				}
				if (c == '*') {
					stack.push(forwardNum * backwardNum);
					continue;
				}
				stack.push(forwardNum / backwardNum);
				continue;
			}

			stack.push(Integer.parseInt(String.valueOf(c)));
		}

		return stack.pop();
	}

	private boolean isOperation(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/';
	}

	public int lectureSolution(String str) {
		Stack<Integer> stack = new Stack<>();
		for (char x : str.toCharArray()) {
			if (Character.isDigit(x)) {
				stack.push(x - '0');
				continue;
			}

			int rt = stack.pop();
			int lt = stack.pop();

			if (x == '+') {
				stack.push(lt + rt);
			} else if (x == '-') {
				stack.push(lt - rt);
			} else if (x == '*') {
				stack.push(lt * rt);
			} else {
				stack.push(lt / rt);
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) throws IOException {
		Main250128 main = new Main250128();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(main.solution(br.readLine()));
	}
}
