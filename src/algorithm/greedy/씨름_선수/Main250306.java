package algorithm.greedy.씨름_선수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * 문제
 * https://cote.inflearn.com/contest/10/problem/09-01
 *
 * 지원자 N명
 * 키워 몸무게가 모두 높은 친구가 있으면 선발한다.
 *
 * 문제 접근 방법
 * Person을 만든다.
 * 비교한다.
 */
public class Main250306 {
	static class Person implements Comparable<Person> {
		int height;
		int weight;

		public Person(int height, int weight)  {
			this.height = height;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Person{" +
				"height=" + height +
				", weight=" + weight +
				'}';
		}

		@Override
		public int compareTo(Person o) {
			if(this.height == o.height) {
				if(this.weight == o.weight) {
					return 0;
				}
				return this.weight < o.weight ? -1: 1;
			}

			return this.height < o.height ? -1 : 1;
		}
	}

	public static void main(String[] args) throws IOException {
		Main250306 main = new Main250306();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(br.readLine());
		final Person[] people = new Person[n];

		for(int index = 0; index < n; index++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			people[index] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		System.out.println(main.solution(n, people));
	}

	private int solution(int n, Person[] people) {
		int answer = n;

		// 우선 키로 전부 정렬해버리자.
		// 그러면 몸무게로만 비교할 수 있기 때문

		List<Person> personList = Arrays.stream(people)
			.sorted()
			.collect(Collectors.toList());


		for(int index = 0; index < personList.size(); index++) {
			Person person = personList.get(index);
			for(int compare = index + 1; compare < personList.size(); compare++){
				if(personList.get(compare).weight > person.weight){
					answer--;
					break;
				}
			}

		}

		return answer;
	}
}
