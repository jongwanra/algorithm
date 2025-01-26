package study;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueStudy {
	public static void main(String[] args) {
		// 낮은 숫자가 우선인 우선 순위 큐
		Queue<Integer> minHeap = new PriorityQueue<>();
		minHeap.offer(1);
		minHeap.offer(10);
		minHeap.offer(200);

		System.out.println("minHeap.peek() = " + minHeap.peek());

		// 높은 숫자가 우선인 우선 순위 큐
		Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		maxHeap.offer(1);
		maxHeap.offer(10);
		maxHeap.offer(200);

		System.out.println("maxHeap.peek() = " + maxHeap.peek());

	}
}
