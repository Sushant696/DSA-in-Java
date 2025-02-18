package practiceQuestion;

class Stacks {

    int array[];
    int top = -1;
    int size;

    public Stacks(int size) {
        this.size = size;
        array = new int[size];
    }

    void push(int data) {
        if (isFull()) {
            System.out.println("the stack is full");
        } else {
            array[++top] = data;
        }
    }

    int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        }
        return array[top--];
    }

    boolean isEmpty() {

        return top == -1;
    }

    boolean isFull() {
        return top == size - 1;
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("The stack is empty");
            return -1;
        }
        if (isFull()) {
            System.out.println("The stack is full");
            return -1;
        }
        System.out.println(array[top]);
        return array[top];
    }

    public static void main(String[] args) {
        Stacks stk = new Stacks(5);
        stk.peek();
        stk.push(12);
        stk.peek();
        stk.push(23);
        stk.peek();
        stk.pop();
        stk.pop();
        stk.push(33);
        stk.peek();
        stk.pop();
        stk.pop();

        stk.push(45);
        stk.peek();
        stk.push(52);
        stk.pop();
        stk.pop();
        stk.push(45);
    }
}
