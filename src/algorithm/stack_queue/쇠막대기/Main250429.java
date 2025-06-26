package algorithm.stack_queue.쇠막대기;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/05-05
 *
 * 잘라진 쇠막대기의 총 개수를 구해야 함.
 *
 * 문제 접근 방법
 * stack 자료구조를 사용하여 접근한다.
 * 여는 괄호와 닫는 괄호가 인접한 경우 레이저 발생 stack 내부 카운팅
 * 여는 괄호와 닫는 괄호가 인접하지 않은 경우 stack에서 삭제하고 카운팅 + 1
 *
 * 시간 복잡도: O(n)
 * 공간 복잡도: O(n)
 */


import java.util.*;
import java.io.*;
public class Main250429 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Main250429 main = new Main250429();
		System.out.println(main.solution(s));
	}

	private int solution(String s) {
		int answer = 0;
		final int length = s.length();
		Deque<Integer> posStack = new ArrayDeque<>();
		for(int index = 0; index < length; index++) {
			final char target = s.charAt(index);
			if(target == '(') {
				posStack.push(index);
				continue;
			}
			if(posStack.isEmpty()) {
				continue;
			}

			final int compareIndex = posStack.pop();
			if(index - compareIndex == 1) {
				answer += posStack.size();
			}else {
				answer += 1;
			}
		}
		return answer;
	}
}
