package study.data_structure;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
	private List<Integer> nodes;

	public List<Integer> getNodes() {
		return nodes;
	}

	public MinHeap() {
		this.nodes = new ArrayList<>();
		this.nodes.add(null);
	}

	public void offer(int value) {
		nodes.add(value);
		int currentIndex = nodes.size() - 1;

		while (nodes.get(currentIndex) < nodes.get(getParentNodeIndex(currentIndex))) {
			int parentIndex = getParentNodeIndex(currentIndex);
			swap(currentIndex, parentIndex);

			currentIndex = parentIndex;
		}
	}

	public int poll() {
		int deletedRoot = nodes.get(1);
		int lastIndex = nodes.size() - 1;
		nodes.set(1, nodes.get(lastIndex));
		nodes.remove(lastIndex);
		int currentIndex = 1;
		while (true) {
			final int rightChildIndex = getRightChildIndex(currentIndex);
			final int leftChildIndex = getLeftChildIndex(currentIndex);

			if (leftChildIndex >= nodes.size() || rightChildIndex >= nodes.size()) {
				break;
			}
			int targetChildIndex =
				nodes.get(leftChildIndex) < nodes.get(rightChildIndex) ? leftChildIndex : rightChildIndex;

			if (nodes.get(targetChildIndex) >= nodes.get(currentIndex)) {
				break;
			}
			swap(targetChildIndex, currentIndex);
			currentIndex = targetChildIndex;
		}

		return deletedRoot;

	}

	private void swap(int indexA, int indexB) {
		int tmp = nodes.get(indexA);
		nodes.set(indexA, nodes.get(indexB));
		nodes.set(indexB, tmp);
	}

	private int getRightChildIndex(int currentIndex) {
		return currentIndex * 2 + 1;
	}

	private int getLeftChildIndex(int currentIndex) {
		return currentIndex * 2;
	}

	private int getParentNodeIndex(int currentIndex) {
		if (isRootNode(currentIndex)) {
			return 1;
		}
		return currentIndex / 2;
	}

	private boolean isRootNode(int currentIndex) {
		return currentIndex == 1;
	}

}
