package queue;

public class Queue1 {

    private int[] data;
    private int front = 0, end = 0, capacity;

    public Queue1(int capacity) {
        this.capacity = capacity;
        data = new int[capacity];
    }

    public int size() {
        return (front - end) % (capacity + 1);
    }

    public void enqueue(int value) {
        if(size() == capacity) {
            throw new RuntimeException("Full");
        }
        front = front + 1;
        data[front % capacity] = value;
    }

    public int dequeue() {
        if(size() == 0) {
            throw new RuntimeException("empty");
        }
        end = end + 1;
        int pop = data[end];
        data[end % capacity] = 0;
        return pop;
    }

    public void peek() {
        System.out.println(data[end]);
    }

    public void display() {
        for(int i=0; i < data.length; i++) {
            System.out.print(data[i] + ", ");
        }
        System.out.println("");
        System.out.println("size: " + size());
        System.out.println("front: " + front);
        System.out.println("end: " + end);

    }

    public static void  main(String args[]) {
        Queue1 queue = new Queue1(5);
        queue.enqueue(10);
        queue.enqueue(12);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(8);
        queue.enqueue(7);
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(5);
        queue.display();
        queue.enqueue(11);
    }
}