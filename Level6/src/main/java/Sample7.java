import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

public class Sample7 {
    public static void main(String[] args) {
        Class<?> dynamicType = new ByteBuddy()
                .subclass(Object.class)
                .method(ElementMatchers.named("toString"))
                .intercept(FixedValue.value("Hello from ByteBuddy!"))
                .make()
                .load(Sample7.class.getClassLoader())
                .getLoaded();

        try {
            System.out.println(dynamicType.newInstance().toString());
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
