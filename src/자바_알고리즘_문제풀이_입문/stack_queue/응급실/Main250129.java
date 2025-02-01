package 자바_알고리즘_문제풀이_입문.stack_queue.응급실;


import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 문제 링크: https://cote.inflearn.com/contest/10/problem/05-08
 * 문제 접근 방법
 * Queue로 문제 접근 한다.
 * 1. Queue에 전부 넣는다.
 * 2. Queue에서 poll() 이후에, 위험도 여부를 정한다.
 *
 */

class Patient {
	private int risk;
	private boolean isTarget;

	public Patient(int risk) {
		this.risk = risk;
		this.isTarget = false;
	}

	public void specifyTarget() {
		this.isTarget = true;
	}

	public boolean isBiggerRiskThan(Patient targetPatient) {
		return this.risk > targetPatient.risk;
	}

	public boolean isTarget() {
		return isTarget;
	}
}

public class Main250129 {
	private int solution(int n, int m, int[] arr){
		int answer = 0;
		List<Patient> patients = Arrays.stream(arr)
			.boxed()
			.map(Patient::new)
			.collect(Collectors.toList());

		patients.get(m).specifyTarget();

		Queue<Patient> patientQueue = new ArrayDeque<>(patients);

		while(!patientQueue.isEmpty()) {
			Patient targetPatient = patientQueue.poll();

			// 해당 위험도보다 더 큰 환자가 있는지 찾기.
			if(doesHaveBiggerRiskPatient(patientQueue, targetPatient)) {
				patientQueue.offer(targetPatient);
				continue;
			}

			answer++;
			if(targetPatient.isTarget()) {
				break;
			}
		}

		return answer;
	}

	private boolean doesHaveBiggerRiskPatient(Queue<Patient> patientQueue, Patient targetPatient) {
		for (Patient patient : patientQueue) {
			if(patient.isBiggerRiskThan(targetPatient)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		Main250129 main = new Main250129();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int n = Integer.parseInt(st.nextToken());
		final int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		StringTokenizer arrSt = new StringTokenizer(br.readLine());
		for(int index = 0 ; index < n; index++){
			arr[index] = Integer.parseInt(arrSt.nextToken());
		}

		System.out.println(main.solution(n, m, arr));
	}
}
