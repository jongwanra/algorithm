package study.data_structure;

public class MinHeapMain {
	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap();
		minHeap.offer(5);
		minHeap.offer(4);
		minHeap.offer(3);
		minHeap.offer(2);
		minHeap.offer(1);

		System.out.println(minHeap.getNodes());

		for (int index = 0; index < 5; index++) {
			int removed = minHeap.poll();
			System.out.println("minHeap = " + minHeap.getNodes());
			System.out.println("removed = " + removed);
		}
	}
}
