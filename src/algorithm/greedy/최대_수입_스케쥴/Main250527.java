package algorithm.greedy.최대_수입_스케쥴;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/09-04
 *
 * D일 안에 와서 강연을 하면 M만큼의 강연료를 주기로 함.
 * 하루에 하나의 기업에서만 강연을 할 수 있다.
 *
 * 문제 접근 방법
 * 1. Lecture Class 구현
 * 2. Priority Queue를 이용하여 구현하는데, dDay가 높고 비용이 비싼 경우부터 추출한다.
 * 3일차에는 3일차 때 가장 비싼 강연을 고를 수 있다.
 * 2일차에는 3일차를 포함한 2일차까지의 가장 비싼 강연을 고를 수 있다.
 * 1일차에는 3,2일차를 포함한 가장 비싼 강연을 고를 수 있다.
 *
 */
import java.util.*;
import java.io.*;
import java.util.stream.*;
public class Main250527 {
	static class Lecture implements Comparable<Lecture> {
		int amount;
		int dDay;

		public Lecture(int amount, int dDay) {
			this.amount = amount;
			this.dDay = dDay;
		}

		@Override
		public int compareTo(Lecture t) {
			// 날짜 순 내림차순 정렬
			// 날짜가 동일하면 가격이 비싼 순
			return t.dDay - this.dDay;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		List<Lecture> lectures = new ArrayList<>(n);

		for(int index = 0; index < n; index++) {
			String[] inputs = br.readLine().split(" ");
			final int amount = Integer.parseInt(inputs[0]);
			final int dDay = Integer.parseInt(inputs[1]);

			lectures.add(new Lecture(amount, dDay));
		}


		Main250527 main = new Main250527();
		System.out.println(main.solution(n, lectures));


	}

	private int solution(int n, List<Lecture> lectures) {
		int answer = 0;

		List<Lecture> sortedLectures = lectures.stream().sorted().collect(Collectors.toList());
		final int maxDDay = sortedLectures.get(0).dDay;
		Queue<Integer> pQ = new PriorityQueue<>(Comparator.reverseOrder());

		int index = 0;
		for(int curDDay = maxDDay; curDDay >= 1; curDDay--) {
			while(index < sortedLectures.size() && sortedLectures.get(index).dDay == curDDay) {
				pQ.offer(sortedLectures.get(index).amount);
				index++;
			}

			if(!pQ.isEmpty()) {
				answer += pQ.poll();
			}

		}



		return answer;
	}
}
