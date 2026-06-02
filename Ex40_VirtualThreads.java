// Exercise 40: Virtual Threads (Java 21)
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Ex40_VirtualThreads {

    static final int COUNT = 100_000;

    public static void main(String[] args) throws InterruptedException {
        // ── Virtual Threads ──────────────────────────────────────────────────
        AtomicInteger vCounter = new AtomicInteger();
        CountDownLatch vLatch  = new CountDownLatch(COUNT);

        long vStart = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            Thread.startVirtualThread(() -> {
                vCounter.incrementAndGet();
                vLatch.countDown();
            });
        }
        vLatch.await();
        long vTime = System.currentTimeMillis() - vStart;
        System.out.println("Virtual threads (" + COUNT + "): "
                + vCounter.get() + " completed in " + vTime + " ms");

        // ── Platform (OS) Threads — capped at 1 000 to avoid OOM ────────────
        int platformCount = 1_000;
        AtomicInteger pCounter = new AtomicInteger();
        CountDownLatch pLatch  = new CountDownLatch(platformCount);

        long pStart = System.currentTimeMillis();
        for (int i = 0; i < platformCount; i++) {
            new Thread(() -> {
                pCounter.incrementAndGet();
                pLatch.countDown();
            }).start();
        }
        pLatch.await();
        long pTime = System.currentTimeMillis() - pStart;
        System.out.println("Platform threads (" + platformCount + "): "
                + pCounter.get() + " completed in " + pTime + " ms");

        System.out.println("\nConclusion: Virtual threads are far more lightweight.");
        System.out.println("100 000 virtual threads finish in similar time to "
                + platformCount + " platform threads.");
    }
}
