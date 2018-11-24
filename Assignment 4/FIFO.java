/*
name: Woohyeon Baek
student number: 2017-15782
 */

public class FIFO {

    private Node4_1[] queue;
    private int front, rear;

    public FIFO(int maxSize) {
        queue = new Node4_1[maxSize];
        front = rear = 0;
    }
    public void push(Node4_1 data) { queue[rear++] = data; }
    public Node4_1 pop() { return queue[front++]; }
}
