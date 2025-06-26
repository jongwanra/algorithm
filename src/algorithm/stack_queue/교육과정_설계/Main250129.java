package algorithm.stack_queue.교육과정_설계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 문제 링크: https://cote.inflearn.com/contest/10/problem/05-07
 * 문제 접근 방법
 * Queue를 이용해서 문제에 접근하자.
 * 정상적으로 반목문이 종료될 경우 YES
 * Queue가 먼저 비어버릴 경우 NO를 출력한다.
 */
public class Main250129 {
	private String solution(String orderedSubjects, String subjects) {
		Queue<Character> queue = new ArrayDeque<>();
		for(char subject: subjects.toCharArray()){
			queue.offer(subject);
		}
		int matchedCount = 0;
		final int subjectsSize = orderedSubjects.length();

		for(char orderedSubject: orderedSubjects.toCharArray()){
			while(!queue.isEmpty() && matchedCount < subjectsSize) {
				if(queue.poll() == orderedSubject){
					matchedCount++;
					break;
				}

			}
		}
		return matchedCount == subjectsSize ? "YES" : "NO";
	}

	private String solution2(String requiredSubjects, String subjects) {
		Queue<Character> queue = new ArrayDeque<>();

		for(char requiredSubject: requiredSubjects.toCharArray()){
			queue.offer(requiredSubject);
		}

		for(char subject: subjects.toCharArray()) {
			if(queue.isEmpty()) {
				break;
			}
			if (queue.peek() == subject) {
				queue.poll();
			}
		}

		return queue.isEmpty() ? "YES": "NO";

	}
	public static void main(String[] args) throws IOException {
		Main250129 main = new Main250129();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(main.solution2(br.readLine(), br.readLine()));
	}
}
