//Experiment No.6
// Interface for Stack operations
interface StackInterface {
    void push(int element);
    int pop();
    int peek();
    void displayStack();
}

// Interface for Queue operations
interface QueueInterface {
    void enqueue(int element);
    int dequeue();
    void displayQueue();
}

// Class implementing both Stack and Queue interfaces
class StackQueue implements StackInterface, QueueInterface {
    private int[] stack = new int[10];
    private int[] queue = new int[10];
    private int top = -1;
    private int front = 0;
    private int rear = -1;

    // Stack methods
    public void push(int element) {
        if (top < stack.length - 1) {
            stack[++top] = element;
            System.out.println(element + " pushed to stack.");
        } else {
            System.out.println("Stack is full!");
        }
    }

    public int pop() {
        if (top >= 0) {
            int poppedElement = stack[top--];
            System.out.println(poppedElement + " popped from stack.");
            return poppedElement;
        } else {
            System.out.println("Stack is empty!");
            return -1;
        }
    }

    public int peek() {
        if (top >= 0) {
            return stack[top];
        } else {
            System.out.println("Stack is empty!");
            return -1;
        }
    }

    public void displayStack() {
        if (top >= 0) {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("Stack is empty!");
        }
    }

    // Queue methods
    public void enqueue(int element) {
        if (rear < queue.length - 1) {
            queue[++rear] = element;
            System.out.println(element + " enqueued to queue.");
        } else {
            System.out.println("Queue is full!");
        }
    }

    public int dequeue() {
        if (front <= rear) {
            int dequeuedElement = queue[front++];
            System.out.println(dequeuedElement + " dequeued from queue.");
            return dequeuedElement;
        } else {
            System.out.println("Queue is empty!");
            return -1;
        }
    }

    public void displayQueue() {
        if (front <= rear) {
            System.out.print("Queue elements: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("Queue is empty!");
        }
    }
}

// Test class
public class StackQueueTest {
    public static void main(String[] args) {
        StackQueue sq = new StackQueue();

        // Stack operations
        sq.push(10);
        sq.push(20);
        sq.displayStack();
        sq.pop();
        sq.displayStack();

        // Queue operations
        sq.enqueue(30);
        sq.enqueue(40);
        sq.displayQueue();
        sq.dequeue();
        sq.displayQueue();
    }
}