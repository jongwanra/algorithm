package 자바_알고리즘_문제풀이_입문.recursive_tree_graph.재귀함수를_이용한_이진수_출력;

/**
 * 문제
 * 10진수 N이 입력되면 2진수로 변환하여 출력하는 프로그램을 작성하자.
 *
 * 입력: 11
 * 출력: 1011
 *
 * 문제 접근 방법
 * 재귀함수를 이용해서 10진수를 2진수로 변환한다.
 */
public class Main250206 {
	private String solution(int num) {
		// 종료 조건
		if(num == 1) {
			return "1";
		}

		return solution(num / 2) + num % 2;
	}

	public static void main(String[] args) {
		Main250206 main = new Main250206();
		System.out.println(main.solution(11));
	}
}
