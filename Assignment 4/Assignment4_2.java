/*
name: Woohyeon Baek
student number: 2017-15782
 */

public class Assignment4_2 {
	public Node4_1 root;

	public Assignment4_2(String s1, String s2) {
		if(s1.isEmpty()) return;
		int length = s2.length();
		root = new Node4_1();
		int n = makeTree(root, s1, 0);
		FIFO queue = new FIFO(length);
		queue.push(root);
		for(int i = 0; i < length; i++) {
			Node4_1 node = queue.pop();
			node.character = s2.charAt(i);
			if(node.left != null) queue.push(node.left);
			if(node.right != null) queue.push(node.right);
		}
	}

	public String report_bits_preorder() { return report_bits_preorder(root).toString(); }

	private StringBuilder report_bits_preorder(Node4_1 node) {
		StringBuilder str = new StringBuilder();
		if(node != null) {
			str.append(booleanToChar(node.left != null));
			str.append(booleanToChar(node.right != null));
			str.append(report_bits_preorder(node.left));
			str.append(report_bits_preorder(node.right));
		}
		return str;
	}

	public String report_bits_levelorder() {
		StringBuilder order = new StringBuilder();
		if(root != null) {
			int n = treeSize(root);
			FIFO queue = new FIFO(n);
			queue.push(root);
			for(int i = 0; i < n; i++) {
				Node4_1 node = queue.pop();
				order.append(booleanToChar(node.left != null));
				order.append(booleanToChar(node.right != null));
				if(node.left != null) queue.push(node.left);
				if(node.right != null) queue.push(node.right);
			}
		}
		return order.toString();
	}

	public String report_preorder() { return report_preorder(root).toString(); }

	private StringBuilder report_preorder(Node4_1 node) {
		StringBuilder str = new StringBuilder();
		if(node != null) {
			str.append(node.character);
			str.append(report_preorder(node.left));
			str.append(report_preorder(node.right));
		}
		return str;
	}

	public String report_levelorder() {
		StringBuilder order = new StringBuilder();
		if(root != null) {
			int n = treeSize(root);
			FIFO queue = new FIFO(n);
			queue.push(root);
			for(int i = 0; i < n; i++) {
				Node4_1 node = queue.pop();
				order.append(node.character);
				if(node.left != null) queue.push(node.left);
				if(node.right != null) queue.push(node.right);
			}
		}
		return order.toString();
	}

	private int makeTree(Node4_1 node, String s, int n) {
		int m;
		if(s.charAt(n) == '1') {
			node.left = new Node4_1();
			m = makeTree(node.left, s, n + 2);
		}
		else m = n + 2;
		if(s.charAt(n+1) == '1') {
			node.right = new Node4_1();
			m = makeTree(node.right, s, m);
		}
		return m;
	}

	private int treeSize(Node4_1 node) {
		if(node == null) return 0;
		return treeSize(node.left) + treeSize(node.right) + 1;
	}

	private char booleanToChar(boolean x) { return x ? '1' : '0'; }
}