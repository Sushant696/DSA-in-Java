package MultiThreading;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {

    public static void main(String[] args) {
        int a[] = {105, 48, 4, 81, 8, 4, 68, 810};
        CompletableFuture<Integer> sum = CompletableFuture.supplyAsync(() -> sum(a));
        CompletableFuture<Integer> square = sum.thenApplyAsync(result -> result * result);
        CompletableFuture<Void> printres = square.thenAcceptAsync(result -> System.out.println(result));

        System.out.println("tttttttltttttttt");
        printres.join();

    }

    static int sum(int a[]) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
        }
        try {
            Thread.sleep(90000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }
}
