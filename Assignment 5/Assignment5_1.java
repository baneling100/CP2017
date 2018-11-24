// student name  : Woohyeon Baek
// student number: 2017-15782

public class Assignment5_1 {
	public Node5_1 root;
	private String preorder;
	private int loc[], next;

	public Assignment5_1(String preorder, String inorder) {
		if(preorder.isEmpty()) return;

		root = new Node5_1();
		root.label = preorder.charAt(0);

		this.preorder = preorder;
		loc = new int[65536];
		int length = inorder.length();
		for(int i = 0; i < length; i++) loc[inorder.charAt(i)] = i;
		next = 1;

		makeTree(root, 0, loc[root.label], inorder.length());
	}

	private void makeTree(Node5_1 curr, int left, int mid, int right) {
		if(next >= preorder.length()) return;

		int t = loc[preorder.charAt(next)];

		if(left <= t && t < mid) {
			curr.left = new Node5_1();
			curr.left.label = preorder.charAt(next++);
			makeTree(curr.left, 0, t, mid);
			if(next >= preorder.length()) return;
			t = loc[preorder.charAt(next)];
		}

		if(mid + 1 <= t && t < right) {
			curr.right = new Node5_1();
			curr.right.label = preorder.charAt(next++);
			makeTree(curr.right, mid + 1, t, right);
		}
	}

	public String report() {
		if(root == null) return "";

		StringBuilder ansStr = new StringBuilder();
		FIFO queue = new FIFO(preorder.length());

		queue.push(root);
		int cnt = 0;

		while(queue.size() > 0) {
			cnt++;

			StringBuilder str = new StringBuilder();
			int size = queue.size();

			for(int i = 0; i < size; i++) {
				Node5_1 curr = queue.pop();

				if(curr.left != null) queue.push(curr.left);
				if(curr.right != null) queue.push(curr.right);

				if(cnt % 2 == 1) str.append(curr.label);
				else str.insert(0, curr.label);
			}

			ansStr.append(str);
		}

		return ansStr.toString();
	}
	
	public Node5_1 get() { return root; }
}