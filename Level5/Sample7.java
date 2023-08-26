import java.util.concurrent.locks.StampedLock;

public class Sample7 {
    private int data = 0;
    private final StampedLock lock = new StampedLock();

    public static void main(String[] args) {
        Sample7 sample = new Sample7();
        sample.optimisticReadDemo();
        sample.nonReentrantDemo();
    }

    public void optimisticReadDemo() {
        long stamp = lock.tryOptimisticRead();
        int readData = data;
        if (lock.validate(stamp)) {
            System.out.println("Optimistic Read: Safe to read data = " + readData);
        } else {
            System.out.println("Optimistic Read: Not safe to read");
        }
    }

    public void nonReentrantDemo() {
        long writeLock = lock.writeLock();
        try {
            data = 100;
            // Attempting to acquire the write lock again (reentrancy test)
            long anotherWriteLock = lock.writeLock();
        } catch (Exception e) {
            System.out.println("StampedLock doesn't support reentrancy: " + e.getMessage());
        } finally {
            lock.unlock(writeLock);
        }
    }
}
