public class Sample10 {
    public static void main(String[] args) {
        Parent p = new Parent();
        Child c = new Child();
        p.show();   // Output: This is the parent class method.
        c.show();   // Output: This is the child class method, overriding the parent class method.
    }
}

class Parent {
    void show() {
        System.out.println("This is the parent class method.");
    }
}

class Child extends Parent {
    @Override
    void show() {
        System.out.println("This is the child class method, overriding the parent class method.");
    }
}
