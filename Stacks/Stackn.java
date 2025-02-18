
public class Stackn {

    int[] stk;
    int top = -1;
    int size;

    Stackn(int size) {
        this.size = size;
        stk = new int[size];
    }

    void push(int data) {
        if (isFull()) {
            System.out.println("Stack overflow");
        } else {
            stk[++top] = data;
        }
    }

    int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stk[top--];
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == size - 1;
        // as the top is incremented in every data pushed into the array so if top is
        // equal to last index then it's full
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
        System.out.println(stk[top]);
        return stk[top];
    }

    public static void main(String[] args) {
        Stackn stck = new Stackn(2);
        stck.push(12);
        stck.push(22);
        stck.push(32);
        stck.pop();
        stck.peek();
    }
}
