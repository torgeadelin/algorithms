import java.util.EmptyStackException;
import java.util.Stack;

public class StackMin<T> {
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        @Override
        public String toString() {
            return data.toString();
        }

        public StackNode(T data) {
            this.data = data;
        }
    }

    private Stack<T> minStack = new Stack<T>();

    private StackNode<T> top;

    public T pop() throws Exception {
        if (top == null)
            throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        if (Integer.parseInt(this.minStack.peek().toString()) == Integer.parseInt(item.toString())) {
            this.minStack.pop();
        }
        return item;
    }

    public void push(T item) {
        StackNode<T> t = new StackNode<T>(item);
        t.next = top;
        top = t;
        if (this.minStack.isEmpty()) {
            this.minStack.push(t.data);
        }
        if (Integer.parseInt(this.minStack.peek().toString()) > Integer.parseInt(t.data.toString())) {
            this.minStack.push(t.data);
        }
    }

    public T peek() throws Exception {
        if (top == null)
            throw new EmptyStackException();
        return top.data;
    }

    public T min() throws Exception {
        if (this.minStack.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.minStack.peek();
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        StackMin<Integer> s = new StackMin<Integer>();
        s.push(1);
        s.push(3);
        s.push(5);
        s.push(-2);

        try {
            s.pop();
            System.out.println(s.min());
            System.out.println(s.peek());
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}