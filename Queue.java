// 1. Queue
class Queue {
    private int[] arr;
    private int front, rear, size, capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Add an element to the queue
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }
        rear = (rear + 1) % capacity; // Wrap around if at the end of the array
        arr[rear] = item;
        size++;
    }

    // Remove an element from the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1; // Return an invalid value
        }
        int item = arr[front];
        front = (front + 1) % capacity; // Wrap around if at the end of the array
        size--;
        return item;
    }

    // Peek at the first element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1; // Return an invalid value
        }
        return arr[front];
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }
}
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListQueue {
    private Node front, rear;

    public LinkedListQueue() {
        front = rear = null;
    }

    // Add an element to the queue
    public void enqueue(int item) {
        Node newNode = new Node(item);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    // Remove an element from the queue
    public int dequeue() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return -1; // Return an invalid value
        }
        int item = front.data;
        front = front.next;

        if (front == null) {
            rear = null; // If the queue is empty, set rear to null as well
        }
        return item;
    }

    // Peek at the first element
    public int peek() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return -1; // Return an invalid value
        }
        return front.data;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }
}


