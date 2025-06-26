package algorithm.recursive_tree_graph.Tree_말단노드까지의_가장_짧은_경로_DFS;

class Node {
	Node lt, rt;
	int data;

	public Node(int data) {
		this.data = data;
	}
}

public class Main250212 {
	Node root;
	public static void main(String[] args) {
		Main250212 tree = new Main250212();
		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.lt.lt = new Node(4);

		System.out.println(tree.dfs(0, tree.root));

	}

	private int dfs(int depth, Node root) {
		 if(root == null) {
			// 완전 이진트리가 아니여서 들어온 경우 최댓값 반환
			return Integer.MAX_VALUE;
		 }
		if(root.lt == null && root.rt == null) {
			// 말단 노드인 경우 반환
			return depth;
		}
		return Math.min(dfs(depth+1, root.lt), dfs(depth+1, root.rt));
	}
}
