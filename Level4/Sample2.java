import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class Sample2 {
    public static void main(String[] args) {
        // SoftReference
        SoftReference<String> softRef = new SoftReference<>(new String("Soft Reference"));
        System.out.println("SoftReference before GC: " + softRef.get());
        System.gc();
        System.out.println("SoftReference after GC (may still exist if memory isn't low): " + softRef.get());

        // WeakReference with ReferenceQueue
        ReferenceQueue<String> queue = new ReferenceQueue<>();
        WeakReference<String> ref = new WeakReference<>(new String("data"), queue);
        System.out.println("WeakReference with ReferenceQueue before GC: " + ref.get());
        System.gc();
        Reference<? extends String> refFromQueue = queue.poll();
        if (refFromQueue != null) {
            System.out.println("WeakReference object is available in reference queue after GC");
        } else {
            System.out.println("WeakReference object is not available in reference queue");
        }

        // PhantomReference
        PhantomReference<String> phantomRef = new PhantomReference<>(new String("Phantom Reference"), queue);
        System.out.println("PhantomReference before GC: " + phantomRef.get()); // Always null
        System.gc();
        refFromQueue = queue.poll();
        if (refFromQueue != null) {
            System.out.println("PhantomReference object is available in reference queue after GC");
        } else {
            System.out.println("PhantomReference object is not available in reference queue");
        }
    }
}
