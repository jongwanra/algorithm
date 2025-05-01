package 자바_알고리즘_문제풀이_입문.stack_queue.응급실;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/05-08
 *
 * 제일 앞에 있는 환자를 뽑는다.
 * 대기 목록에서 꺼낸 환자 보다 위험도가 높은 환자가 존재하면 제일 뒤로 다시 넣는다.
 * 대기 목록의 m 번째 환자는 몇 번째로 진료를 받는지 출력하자.
 *
 * 문제 접근 방법
 * Queue 자료구조를 이용한다.
 *
 * 시간 복잡도: O(n^2)
 * 공간 복잡도: O(n)
 */
import java.util.*;
import java.io.*;

public class Main250501 {
	static class Patient {
		int nth;
		int risk;

		public Patient(int nth, int risk) {
			this.nth = nth;
			this.risk = risk;
		}

		public boolean isTarget(int m) {
			return nth == m;
		}

		public boolean isRiskBiggerThan(int risk) {
			return this.risk > risk;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int n = Integer.parseInt(st.nextToken());
		final int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		StringTokenizer stArr = new StringTokenizer(br.readLine());
		for(int index = 0; index < n; index++) {
			arr[index] = Integer.parseInt(stArr.nextToken());
		}

		Main250501 main = new Main250501();
		System.out.println(main.solution(n, m, arr));

	}

	private int solution(int n, int m, int[] arr) {
		int answer = 0;
		Deque<Patient> queue = new ArrayDeque<>();
		for(int index = 0; index < n; index++) { // O(n)
			Patient patient = new Patient(index, arr[index]);
			queue.offer(patient);
		}

		// O(n^2): queue에서 하나 뽑고, 나머지를 포문에서 비교하기 때문에 O(n^2)이다.
		while(!queue.isEmpty()) {
			Patient targetPatient = queue.poll();
			if(doesExistRiskPatient(targetPatient, queue)) {
				queue.offer(targetPatient);
				continue;
			}

			answer++;
			if(targetPatient.isTarget(m)) {
				break;
			}

		}

		return answer;
	}

	private boolean doesExistRiskPatient(Patient target, Deque<Patient> queue) {
		for(Patient current: queue ) {
			if(target.isRiskBiggerThan(current.risk)) {
				return true;
			}
		}
		return false;
	}
}
