import java.util.*;

public class MyQueue {
    Stack<Integer> enqStack = new Stack<>();
    Stack<Integer> deqStack = new Stack<>();

    public MyQueue() {
    }

    public void enqueue(int data) {
        enqStack.push(data);
    }

    public int dequeue() {
        int size = enqStack.size();
        for (int i = 0; i < size - 1; i++) {
            deqStack.push(enqStack.pop());
        }
        size = deqStack.size();
        int temp = enqStack.pop();
        for (int i = 0; i < size; i++) {
            enqStack.push(deqStack.pop());
        }
        return temp;
    }

    @Override
    public String toString() {
        return Arrays.toString(enqStack.toArray());
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        for (int i = 0; i < 10; i++) {
            q.enqueue(i);
        }
        System.out.println(q);

        for (int i = 0; i < 5; i++) {
            q.dequeue();
        }
        System.out.println(q);
        for (int i = 10; i < 20; i++) {
            q.enqueue(i);
        }
        System.out.println(q);

    }
}