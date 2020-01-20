import java.util.ArrayList;
import java.util.*;

public class StackOfPlates {
    public int capacity;
    public ArrayList<Stack<Integer>> stacks = new ArrayList<>();
    int stackLevel = 0;
    int top = 0;

    public StackOfPlates(int capacity) {
        this.capacity = capacity;
        stacks.add(new Stack<Integer>());
    }

    public void push(int data) {
        if (this.stacks.get(stackLevel).size() > this.capacity) {
            stackLevel++;
            stacks.add(new Stack<Integer>());
            this.stacks.get(stackLevel).push(data);
        } else {
            this.stacks.get(stackLevel).push(data);
        }
    }

    public int pop() {
        if (this.stacks.get(stackLevel).size() == 1) {
            int temp = stacks.get(stackLevel).pop();
            stacks.remove(stackLevel);
            stackLevel--;
            return temp;
        }
        return stacks.get(stackLevel).pop();

    }

    public int popAt(int index) {
        int level = (int) (index / capacity);
        int temp = stacks.get(level).elementAt(index - level * capacity);
        stacks.get(level).remove(index - level * capacity);
        return temp;
    }

    @Override
    public String toString() {
        return Arrays.toString(stacks.toArray());
    }

    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        StackOfPlates s = new StackOfPlates(size);
        for (int i = 0; i < 20; i++) {
            s.push(i);
        }
        System.out.println(s.toString());
        s.popAt(Integer.parseInt(args[1]));
        System.out.println(s.toString());

    }
}