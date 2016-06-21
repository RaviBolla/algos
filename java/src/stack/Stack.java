package stack;

/**
 * Created by ravibol on 4/18/16.
 */
public class Stack {
    int data[], peek, capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
    }
}
