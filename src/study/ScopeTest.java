package study;

public class ScopeTest {
	public static void main(String[] args) {
		int sum = 0;
		extracted(sum);

		System.out.println("sum = " + sum); // 0
	}

	private static void extracted(int sum) {
		for(int i = 0; i < 10; i++) {
			sum = sum + 1;
		}
		System.out.println("sum = " + sum); // 10
	}
}


// 메모리 구조
// stack, heap, ...


// stack -> 자료구조
// 1, 2, 3, 4, 5


// main() -> extracted()
