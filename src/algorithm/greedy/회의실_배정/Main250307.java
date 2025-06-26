package algorithm.greedy.회의실_배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/09-02
 *
 * 각 회의가 겹치지 않도록 사용할 수 있는 최대수의 회의를 차는 문제
 * 회의는 중간에 중단 불가.
 * 끝나는 것과 동시에 다음 회의 시작 가능.
 *
 * 문제 접근 방법
 * 주어지는 회의 수는 10만개 이다. 따라서 n^2의 알고리즘으로는 접근이 불가능하다.
 * 회의 시간이 짧은 순으로 정렬한 이후에 곂치지 않도록 배치하면 어떨까? (x)
 * 회의 시간이 짧은 순으로 하면 n^2로 밖에 접근 못해서 run time error가 발생
 * 회의 시간이 빨리 끝나는 순으로 정렬하자.
 *
 */
public class Main250307 {

	static class Time implements Comparable<Time> {
		int start;
		int end;

		@Override
		public String toString() {
			return "Time{" +
				"start=" + start +
				", end=" + end +
				'}';
		}




		public Time(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Time o) {

			int diffEnd = this.end - o.end;
			if(diffEnd == 0) {
				return this.start - o.start;
			}
			return diffEnd;
		}

	}
	public static void main(String[] args) throws IOException {
		Main250307 main = new Main250307();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		List<Time> times = new ArrayList<>();
		for(int index = 0; index < n; index++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Time time = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			times.add(time);
		}

		System.out.println(main.solution(n, times));

	}

	private int solution(int n, List<Time> times) {
		int answer = 0;
		List<Time> sorted = times.stream().sorted().collect(Collectors.toList());
		int lastEndedTime = Integer.MIN_VALUE;
		for (Time time : sorted) {
			if(time.start >= lastEndedTime) {
				lastEndedTime = time.end;
				answer++;
			}
		}

		return answer;
	}
}
