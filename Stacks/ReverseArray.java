/**
 * Questions :- Reverse a array using stack
 * ReverseArray
 */

public class ReverseArray {

    static int[] reverseArray(int arr[]) {
        int[] revArr = new int[5];
        Stack stk = new Stack(6);
        for (int i : arr) {
            stk.push(i);
        }
        for (int i = 0; i < revArr.length; i++) {
            int popItem = stk.pop();
            revArr[i] = popItem;
        }
        return revArr;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        int revArr[] = reverseArray(arr);
        System.out.print("Reverse array :");
        for (int i : revArr) {
            System.out.print(i);
        }
    }
}

class Stack {
    int size;
    int stk[];
    int top = -1;

    // making stack here to use to reverse the array
    Stack(int size) {
        this.size = size;
        stk = new int[size];
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == size - 1;
    }

    int peek() {
        System.out.println(stk[top]);
        return stk[top];
    }

    int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty, no item to pop");
            return -1;
        } else {
            return stk[top--];
        }
    }

    void push(int data) {
        if (isFull()) {
            System.out.println("Stack overflow, stack is full");
        } else {
            stk[++top] = data;
        }
    }
}
