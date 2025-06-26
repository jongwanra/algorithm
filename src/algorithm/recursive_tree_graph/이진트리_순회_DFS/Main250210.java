package algorithm.recursive_tree_graph.이진트리_순회_DFS;

class Node {
	int data;
	Node lt;
	Node rt;

	public Node(int data) {
		this.data = data;
	}
}
public class Main250210 {
	Node root;
	private void dfs(Node node) {
		if(node == null) {
			return;
		}
		// 전위 순회 (부 왼 오)
		// System.out.println(node.data);
		dfs(node.lt);
		// 중위 순회 (왼 부 오)
		// System.out.println(node.data);
		dfs(node.rt);
		// 후위 순회 (왼 오 부)
		System.out.println(node.data);
	}
	public static void main(String[] args) {
		Main250210 tree = new Main250210();
		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);
		tree.root.rt.lt = new Node(6);
		tree.root.rt.rt = new Node(7);

		tree.dfs(tree.root);

	}
}
