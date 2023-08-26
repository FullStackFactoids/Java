import java.util.concurrent.locks.StampedLock;

public class Sample4 {
    private int value = 0;
    private final StampedLock lock = new StampedLock();

    public static void main(String[] args) {
        Sample4 sample = new Sample4();

        // Optimistic Read
        long stamp = sample.lock.tryOptimisticRead();
        int readValue = sample.value;
        if (!sample.lock.validate(stamp)) {
            // If the optimistic read fails, acquire a full read lock
            stamp = sample.lock.readLock();
            try {
                readValue = sample.value;
            } finally {
                sample.lock.unlockRead(stamp);
            }
        }
        System.out.println("Optimistic Read Value: " + readValue);

        // Write
        stamp = sample.lock.writeLock();
        try {
            sample.value = 23;
        } finally {
            sample.lock.unlockWrite(stamp);
        }
        System.out.println("Value after write: " + sample.value);

        // Convert write lock to read lock
        long ws = sample.lock.writeLock();
        sample.lock.unlockWrite(ws);
        long rs = sample.lock.readLock();
        try {
            System.out.println("Value after converting write lock to read lock: " + sample.value);
        } finally {
            sample.lock.unlockRead(rs);
        }
    }
}
