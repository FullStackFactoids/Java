public class Sample2 {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        System.out.println(myDog.sound()); // Output: bow
    }
}

interface Animal {
    String sound();
}

class Dog implements Animal {

    public String sound() {
        return "bow wow";
    }
}
