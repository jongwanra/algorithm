package 자바_알고리즘_문제풀이_입문.stack_queue.쇠막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 문제 링크: https://cote.inflearn.com/contest/10/problem/05-05
 * 문제 접근 방법
 * () 인접한 소괄호는 레이저를 나타낸다. 레이저일 경우에는 stack의 남은 연 괄호 갯수를 카운팅한다. (잘린 막대 수)
 * )가 인접하지 않은 경우 막대가 끝난걸 의미한다. 끝난 막대 카운트를 + 1 해주고  연 막대에 대해서 pop 한다.
 */


public class Main250128 {
	static class Element {
		public int distance;
		public Element(int distance) {
			this.distance = distance;
		}

		public boolean isLaser(int distance) {
			return this.distance + 1 == distance;
		}
	}

	private int solution(String str) {
		int answer = 0;
		Deque<Element> stack = new ArrayDeque<>();
		for(int distance = 0; distance < str.length(); distance++) {
			final char x = str.charAt(distance);

			if(x == '(') {
				stack.push(new Element(distance));
				continue;
			}


			Element popped = stack.pop();
			// 레이저인 경우
			if(popped.isLaser(distance)) {
				answer += stack.size();
				continue;
			}

			// 인접하지 않은 경우 막대기가 끝난 걸로 인지.
			answer += 1;

		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		Main250128 main = new Main250128();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(main.solution(br.readLine()));
	}


}
