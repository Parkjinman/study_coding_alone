package studyExem;

public class DeadlockExample {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void methodA() {
        synchronized (lock1) {
            System.out.println("Thread A: Holding lock 1...");
            try { Thread.sleep(100); } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread A: Waiting for lock 2...");
            synchronized (lock2) {
                System.out.println("Thread A: Acquired lock 2!");
            }
        }
    }

    public void methodB() {
        synchronized (lock2) {
            System.out.println("Thread B: Holding lock 2...");
            try { Thread.sleep(100); } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread B: Waiting for lock 1...");
            synchronized (lock1) {
                System.out.println("Thread B: Acquired lock 1!");
            }
        }
    }

    public static void main(String[] args) {
        DeadlockExample example = new DeadlockExample();

        Thread threadA = new Thread(example::methodA);
        Thread threadB = new Thread(example::methodB);

        threadA.start();
        threadB.start();
    }
}
