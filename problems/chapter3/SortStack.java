import java.util.*;

public class SortStack {
    public Stack<Integer> sort(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();
        int max = Integer.MIN_VALUE;
        int size = stack.size();
        for (int i = 0; i < size; i++) {

            while (!stack.isEmpty()) {
                if (stack.peek() > max) {
                    max = stack.peek();
                }
                temp.push(stack.pop());
            }

            int j = 0;
            boolean flag = false;
            while (j < size - i) {
                if (temp.peek() == max && !flag) {
                    temp.pop();
                    flag = true;
                } else {
                    stack.push(temp.pop());
                }
                j++;
            }

            temp.push(max);
            max = Integer.MIN_VALUE;

        }
        return temp;

    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(5);
        stack.push(10);
        stack.push(1);
        stack.push(-3);

        SortStack s = new SortStack();
        stack = s.sort(stack);
        System.out.println(Arrays.toString(stack.toArray()));

    }
}
