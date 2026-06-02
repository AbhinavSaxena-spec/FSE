// Exercise 41: Executor Service and Callable
import java.util.*;
import java.util.concurrent.*;

public class Ex41_ExecutorServiceCallable {

    // A Callable task that computes the square of a number
    static class SquareTask implements Callable<Long> {
        private final int n;
        SquareTask(int n) { this.n = n; }

        @Override
        public Long call() throws Exception {
            // Simulate some work
            Thread.sleep(50);
            return (long) n * n;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int poolSize  = 4;
        int taskCount = 10;

        ExecutorService executor = Executors.newFixedThreadPool(poolSize);
        List<Future<Long>> futures = new ArrayList<>();

        System.out.println("Submitting " + taskCount + " Callable tasks to a pool of "
                + poolSize + " threads ...");

        for (int i = 1; i <= taskCount; i++) {
            futures.add(executor.submit(new SquareTask(i)));
        }

        executor.shutdown();   // no new tasks accepted

        System.out.printf("%n%-6s %s%n", "n", "n²");
        System.out.println("-".repeat(14));

        for (int i = 0; i < futures.size(); i++) {
            long result = futures.get(i).get();   // blocks until result ready
            System.out.printf("%-6d %d%n", (i + 1), result);
        }

        System.out.println("\nAll tasks completed.");
    }
}
