// Sample1.java

// Step 1: Write Java Code with Native Method
// This Java class contains a native method and loads the library using System.loadLibrary.

public class Sample1 {
    public static void main(String[] args) {
        NativeInterface nativeInterface = new NativeInterface();
        nativeInterface.callNativeMethod();
    }
}

class NativeInterface {
    // Declare the native method
    public native void callNativeMethod();

    // Load the native library
    static {
        System.loadLibrary("nativeLibrary");
    }
}

// Step 2: Generate C Header
// - Compile this Java class to get the .class file:
//   javac Sample1.java
// - Then, generate the C header file:
//   For JDK 8: javah NativeInterface
//   For JDK 9 and later: javac -h . Sample1.java
