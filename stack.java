public class stack {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    class Stack {
        private Node top;

        public Stack() {
            this.top = null;
        }

        // Push operation
        public void push(int value) {
            Node newNode = new Node(value);
            if (top == null) {
                top = newNode;
            } else {
                newNode.next = top;
                top = newNode;
            }
            System.out.println("Pushed " + value + " into the stack");
        }

        // Pop operation
        public int pop() {
            if (top == null) {
                System.out.println("Stack Underflow");
                return -1;
            } else {
                int value = top.data;
                top = top.next;
                System.out.println("Popped " + value + " from the stack");
                return value;
            }
        }

        // Peek operation
        public int peek() {
            if (top == null) {
                System.out.println("Stack is Empty");
                return -1;
            } else {
                return top.data;
            }
        }

        // Check if stack is empty
        public boolean isEmpty() {
            return (top == null);
        }

        public static void main(String[] args) {
            Stack stack = new Stack();
            stack.push(10);
            stack.push(20);
            stack.push(30);
            System.out.println("Top element: " + stack.peek());
            stack.pop();
            System.out.println("Top element after pop: " + stack.peek());
        }
    }

}
