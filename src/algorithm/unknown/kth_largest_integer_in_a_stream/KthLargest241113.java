package algorithm.unknown.kth_largest_integer_in_a_stream;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://neetcode.io/problems/kth-largest-integer-in-a-stream
 * 문제 접근
 * 1. PriorityQueue를 이용하여 maxHeap을 구현.
 */
public class KthLargest241113 {
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
	private final int k;
	private Queue<Integer> pendingQueue = new ArrayDeque<>();

	public KthLargest241113(int k, int[] nums) {
		for (int num : nums) {
			maxHeap.add(num);
		}
		this.k = k;
	}

	public int add(int val) {

		// 먼저 추가
		maxHeap.add(val);

		for(int index = 0; index < k - 1; index++){
			pendingQueue.offer(maxHeap.poll());
		}

		// k번째를 꺼낸다.
		int result = maxHeap.peek();

		while (!pendingQueue.isEmpty()) {
			maxHeap.add(pendingQueue.poll());
		}

		return result;

	}

	public static void main(String[] args) {
		// first case
		// KthLargest241113 kthLargest = new KthLargest241113(3, new int[]{1, 2, 3, 3});
		// System.out.println(kthLargest.add(3));;   // return 3
		// System.out.println(kthLargest.add(5));;   // return 3
		// System.out.println(kthLargest.add(6));;   // return 3
		// System.out.println(kthLargest.add(7));;   // return 5
		// System.out.println(kthLargest.add(8));;   // return 6

		KthLargest241113 kthLargest = new KthLargest241113(3, new int[] {4, 5, 8, 2});
		System.out.println("kthLargest.add(3) = " + kthLargest.add(3));
		System.out.println("kthLargest.add(5) = " + kthLargest.add(5));
		System.out.println("kthLargest.add(10) = " + kthLargest.add(10));
		System.out.println("kthLargest.add(9) = " + kthLargest.add(9));
		System.out.println("kthLargest.add(4) = " + kthLargest.add(4));


	}
}
