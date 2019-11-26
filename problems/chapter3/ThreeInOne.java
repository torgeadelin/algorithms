import java.util.EmptyStackException;
import java.lang.reflect.Array;

public class ThreeInOne<T> {
    private int stackSize;
    private int noOfStacks = 3;
    private T[] values;
    private int[] sizes;

    public ThreeInOne(Class<T> c, int stackSize) {
        @SuppressWarnings("unchecked")
        final T[] v = (T[]) Array.newInstance(c, stackSize * noOfStacks);
        this.values = v;

        this.sizes = new int[this.noOfStacks];
        this.stackSize = stackSize;
    }

    // push
    public void push(int stackNo, T data) throws Exception {
        if (isFull(stackNo)) {
            throw new Exception();
        }
        values[getTopIndex(stackNo)] = data;
        sizes[stackNo]++;
    }

    // pop
    public T pop(int stackNo) throws Exception {
        if (isEmpty(stackNo)) {
            throw new EmptyStackException();
        }
        T item = values[getTopIndex(stackNo)];
        values[getTopIndex(stackNo)] = null; // Clear
        sizes[stackNo]--;
        return item;
    }

    // peek
    public T peek(int stackNo) throws Exception {
        if (isEmpty(stackNo)) {
            throw new EmptyStackException();
        }
        return values[getTopIndex(stackNo)];
    }

    // topIndex
    public int getTopIndex(int stackNo) {
        return stackSize * stackNo + sizes[stackNo] - 1;
    }

    // isFull
    public boolean isFull(int stackNo) {
        return sizes[stackNo] == this.stackSize;
    }

    // isEmpty
    public boolean isEmpty(int stackNo) {
        return sizes[stackNo] == 0;
    }

}