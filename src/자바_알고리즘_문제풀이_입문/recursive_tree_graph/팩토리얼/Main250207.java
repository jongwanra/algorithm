package 자바_알고리즘_문제풀이_입문.recursive_tree_graph.팩토리얼;

/**
 * 문제
 * 자연수 N이 입력되면 N!를 구하는 프로그램을 작성하세요.
 * 예를 들어 5! = 5 * 4 * 3 * 2 * 1 = 120 입니다.
 *
 * 문제 접근 방법
 * 재귀를 이용해서 푼다.
 */
public class Main250207 {
	private int solution(int n) {
		if(n == 1) {
			return 1;
		}

		return n * solution(n - 1);

	}
	public static void main(String[] args) {
		Main250207 main = new Main250207();
		System.out.println(main.solution(5));
	}
}
