import java.lang.instrument.Instrumentation;
import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

public class Sample9 {
    public static void main(String[] args) {
        System.out.println("Sample9 main method executed.");
    }
}

class MyAgent {
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("MyAgent premain method executed. " +
                "Initializing bytecode transformer.");
        inst.addTransformer(new MyClassFileTransformer());
    }
}

class MyClassFileTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        if (className.equals("Sample9")) {
            System.out.println("Sample9 class is being loaded!");
        }
        return classfileBuffer;
    }
}
