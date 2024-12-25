package 자바_알고리즘_문제풀이_입문.two_pointers_sliding_window.최대_길이_연속부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://cote.inflearn.com/contest/10/problem/03-06
 * 문제 접근 방법
 * 변수 lp, rp, changedCnt(0을 1로 바꾼 개수), answer, currentCnt를 둔다.
 * rp는 changedCnt가 k를 만족할 때까지 반복문을 돌면서 개수를 answer에 기록한다.
 * 이후 lp는 changedCnt가 이뤄난 첫 번째 지점으로 이동하면서 changedCnt와 currentCnt를 감소시킨다.
 */
public class Main241225 {
	private int solution(final int n, int k, int[] arr) {
		int answer = 0;
		int lp = 0;
		int changedCnt = 0;
		int currentCnt = 0;

		for(int rp = 0; rp < arr.length; rp++) {
			// System.out.println("rp: " + rp);
			if(arr[rp] == 1) {
				currentCnt++;
				// System.out.println("currentCnt: " + currentCnt + " changedCnt: " + changedCnt);
				continue;
			}
			if(arr[rp] == 0 && changedCnt < k) {
				currentCnt++;
				changedCnt++;
				// System.out.println("currentCnt: " + currentCnt + " changedCnt: " + changedCnt);
				continue;
			}
			// System.out.println("isSame changedCnt, k. currentCnt= " + currentCnt);
			// 여기에서는 changedCnt가 k와 동일한 경우에 동작
			answer = Math.max(answer, currentCnt);
			changedCnt++;
			while(lp < rp && arr[lp] == 1) {
				currentCnt--;
				lp++;
				// System.out.println("lp = " + lp + " currentCnt: " + currentCnt + " changedCnt: " + changedCnt);
			}
			if(arr[lp] == 0){
				changedCnt--;
				lp++;
				// System.out.println("currentCnt: " + currentCnt + " changedCnt: " + changedCnt);
			}
		}
		return answer;
	}

	// 강의에서 알려준 구현 방식대로 다시 풀어보기
	private int solution2(int n, int k, int[] arr) {
		int answer = 0;
		int lp = 0;
		int changedCnt = 0;

		for(int rp = 0; rp < n; rp++) {
			if(arr[rp] == 0) {
				changedCnt++;
			}
			if(changedCnt <= k) {
				answer = Math.max(answer, rp - lp + 1);
			}

			while(changedCnt > k) {
				if(arr[lp] == 0) {
					changedCnt--;
				}
				lp++;
			}
		}
		return answer;
	}

	private int lectureSolution(int n, int k, int[] arr) {
		int answer=0, cnt=0, lt=0;
		for(int rt=0; rt < n; rt++) {
			if(arr[rt]== 0) cnt++;
			while(cnt > k){
				if(arr[lt] == 0) cnt--;
				lt++;
			}

			answer = Math.max(answer, rt - lt + 1);
		}
		return answer;
	}
	public static void main(String[] args) throws IOException {
		Main241225 main = new Main241225();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] lineSplit = br.readLine().split(" ");
		final int n = Integer.parseInt(lineSplit[0]);
		final int k = Integer.parseInt(lineSplit[1]);

		int[] arr= new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int index = 0; index < n; index++){
			arr[index] = Integer.parseInt(st.nextToken());
		}
		System.out.println(main.solution2(n, k, arr));
	}
}
