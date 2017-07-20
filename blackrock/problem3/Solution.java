package blackrock.problem3;

public class Solution {
	static long findMax(int n, String treeString) {
		String[] treeArr = treeString.split(" ");
		int[] tree = new int[treeArr.length];
		for (int i = 0; i < treeArr.length; i++)
			if (treeArr[i].equals("#"))
				tree[i] = -1;
			else
				tree[i] = Integer.parseInt(treeArr[i]);
		Node root = new Node(tree[0]);
		for (int i = 0; i < (tree.length - 2 / 2) - 2; i++) {
			root.left.value = tree[(2 * i) + 1];
			root.right.value = tree[(2 * i) + 2];
		}
		long sumRoot = findOddLevelSum(root, true);
		long sumNonRoot = findOddLevelSum(root, false);
		if (sumRoot > sumNonRoot)
			return sumRoot;
		else
			return sumNonRoot;
	}

	static long findOddLevelSum(Node a, boolean oddLevel) {
		if (a == null || a.value == -1)
			return 0;
		long childSum = findOddLevelSum(a.left, !oddLevel) + findOddLevelSum(a.right, !oddLevel);
		if (oddLevel)
			return a.value + childSum;
		else
			return childSum;
	}

	static class Node {
		Node left;
		Node right;
		int value;

		public Node(int value) {
			this.value = value;
		}
	}
}
