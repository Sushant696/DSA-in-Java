package practiceQuestion;

public class QFromStack {

    static Stacks s1 = new Stacks(5);
    static Stacks s2 = new Stacks(5);
    static int arr[] = {1, 2, 3, 45};


    /*
    * 

    //* pop costly method
    static void enqueue(int data) {
        //*  Move all elements from s1 to s2 
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        //* Push item into s1
        s1.push(data);

        //* Push everything back to s1  
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    static int dequeue() {

        if (s1.isEmpty()) {
            System.out.println("Qeueu is empty");
            return -1;
        }
        return s1.pop();
    }
     */
    // pop costly 
    static int dequeue() {
        System.out.println(arr.length);
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("queue is empty");
            return -1;
        }

        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    static void enqueue(int data) {
        s1.push(data);
    }

    public static void main(String[] args) {
        enqueue(1);
        enqueue(2);
        enqueue(3);
        System.out.println(dequeue());
        System.out.println(dequeue());
        System.out.println(dequeue());

    }
}
