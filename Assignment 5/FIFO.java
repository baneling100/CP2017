// student name  : Woohyeon Baek
// student number: 2017-15782

public class FIFO {
    private Node5_1[] queue;
    private int front = 0, rear = 0;

    public FIFO(int size) { queue = new Node5_1[size]; }

    public void push(Node5_1 data) { queue[rear++] = data; }

    public Node5_1 pop() { return queue[front++]; }

    public int size() { return rear - front; }
}
