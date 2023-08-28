// native.c

// Step 3: Write the C Implementation
// Implement the native method in C.

#include <jni.h>
#include <stdio.h>
#include "NativeInterface.h"  // This header file will be generated in Step 2

JNIEXPORT void JNICALL Java_NativeInterface_callNativeMethod(JNIEnv *env, jobject obj) {
    printf("Native method called\n");
}

// Step 4: Compile the C Code
// Compile the C code into a shared library. The exact command depends on your OS:
// Linux: gcc -shared -o libnativeLibrary.so -I${JAVA_HOME}/include -I${JAVA_HOME}/include/linux native.c
// Mac: gcc -shared -o libnativeLibrary.dylib -I${JAVA_HOME}/include -I${JAVA_HOME}/include/darwin native.c
//      For Java versions 9 and above, use the javac tool with the -h option:
//      javac -h . Sample1.java
// Windows: gcc -shared -o nativeLibrary.dll -I"%JAVA_HOME%\include" -I"%JAVA_HOME%\include\win32" native.c

// Step 5: Run the Java Code
// Before running the Java code, ensure the JVM can find the shared library:
// java -Djava.library.path=. Sample1
