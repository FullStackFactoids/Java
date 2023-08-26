import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Sample6 {
    public static void main(String[] args) {

        // Create an InvocationHandler
        InvocationHandler handler = (proxy, method, methodArgs) -> {
            System.out.println("Method invoked: " + method.getName());
            return null;
        };

        // Create a dynamic proxy instance
        MyInterface proxyInstance = (MyInterface) Proxy.newProxyInstance(
                MyInterface.class.getClassLoader(),
                new Class<?>[]{MyInterface.class},
                handler
        );

        // Use the proxy instance
        proxyInstance.myMethod();  // This will print: "Method invoked: myMethod"
    }
}
interface MyInterface {
    void myMethod();
}