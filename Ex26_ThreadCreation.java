// Exercise 26: Thread Creation – Two threads printing messages
public class Ex26_ThreadCreation {

    static class MessageThread implements Runnable {
        private final String threadName;
        private final int    count;

        MessageThread(String name, int count) {
            this.threadName = name;
            this.count      = count;
        }

        @Override
        public void run() {
            for (int i = 1; i <= count; i++) {
                System.out.println("[" + threadName + "] Message " + i);
                try { Thread.sleep(100); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MessageThread("Thread-Alpha", 5));
        Thread t2 = new Thread(new MessageThread("Thread-Beta",  5));

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Both threads finished.");
    }
}
