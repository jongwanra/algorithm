package 자바_알고리즘_문제풀이_입문.array.점수_계산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://cote.inflearn.com/contest/10/problem/02-07
 *
 * 문제 접근 방법
 * O(n) for문 한 번으로 접근 하자.
 * totalCount, currentCount를 둔다.
 * prevScore로 증가분을 표기한다.
 */
public class Main241128 {
	public static void main(String[] args) throws IOException {
		Main241128 main = new Main241128();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] scores = new int[n];
		for(int index = 0; index < n; index++) {
			scores[index] = Integer.parseInt(st.nextToken());
		}
		System.out.println(main.solution(n, scores));
	}

	private int solution(int n, int[] scores) {
		int totalCount = 0;
		int prevScore = 0;

		for(int index =0; index < n; index++) {
			if(scores[index] == 1){
				++prevScore;
				totalCount += prevScore;
			}else {
				prevScore = 0;
			}
		}

		return totalCount;
	}
}
