/*
name: Woohyeon Baek
student number: 2017-15782
 */

public class Assignment4_1 {
	public Node4_1 root;

	public Assignment4_1(String line1, String line2) {
		if(line1.isEmpty()) return;
		int length = line1.length();
		FIFO queue = new FIFO(length);
		root = new Node4_1();
		queue.push(root);
		int j = 0;
		for(int i = 0; i < length; i++) {
			Node4_1 node = queue.pop();
			node.label = line1.charAt(i);
			if(node.label == '0') {
				node.character = line2.charAt(j++);
				node.left = new Node4_1();
				node.right = new Node4_1();
				queue.push(node.left);
				queue.push(node.right);
			}
		}
	}

	public Node4_1 getRoot() { return root; }
}