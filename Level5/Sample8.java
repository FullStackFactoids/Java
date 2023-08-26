public class Sample8 {
    public static void main(String[] args) {
        Sample8 sample = new Sample8();
        sample.doWorkWithoutException();
        sample.doWorkWithException();
    }

    public void doWorkWithoutException() {
        System.out.println("Executing method without exception...");
        try {
            System.out.println("Inside try block. No exception thrown.");
        } catch (Exception e) {
            System.out.println("This won't be executed.");
        } finally {
            cleanup();
        }
    }

    public void doWorkWithException() {
        System.out.println("\nExecuting method with exception...");
        try {
            System.out.println("Inside try block. About to throw an exception.");
            throw new RuntimeException("Sample exception");
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            cleanup();
        }
    }

    private void cleanup() {
        System.out.println("Inside finally block: Performing cleanup tasks.");
    }
}
