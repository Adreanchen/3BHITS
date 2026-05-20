package at.htlhl.threadDemo;

public class ThreadDemo {

    public ThreadDemo() {
        Thread t1 = new Thread(new CounterRunnable(1));
        t1.start();

        Thread t2 = new Thread(new CounterRunnable(2));
        t2.start();

        // Interrupt the running threads
        try {
            Thread.sleep(6000);
        } catch (InterruptedException irex) {
            irex.printStackTrace();
        }
        t1.interrupt();
        t2.interrupt();
    }

    public static void main(String[] args) {
        new ThreadDemo();
    }

    public static int generateRandomTime() {
        int min = 300;
        int max = 1500;
        return (int) (Math.floor(Math.random() * (max - min + 1) + min));
    }

    private class CounterRunnable implements Runnable {

        int runnableId;

        public CounterRunnable(int runnableId) {

            this.runnableId = runnableId;
        }

        @Override
        public void run() {
            int i = 0;

            while (!Thread.currentThread().isInterrupted() && i < 10) {
                i++;
                System.out.println("Thread: " + runnableId + ", Counter: " + i);
                try {
                    Thread.sleep(generateRandomTime());
                } catch (InterruptedException irex) {
                    System.out.println("Thread was interrupted: " + irex.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
