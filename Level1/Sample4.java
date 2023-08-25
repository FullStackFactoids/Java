public class Sample4 {
    public static void main(String[] args) {
        Dog myDog = new Dog(); // Creating a new Dog object
        System.out.println(myDog.sound()); // Output: bow wow
    }
}

class Animal {

    public String sound() {
        return "Some sound";
    }
}

class Dog extends Animal {

    @Override
    public String sound() {
        return "bow wow";
    }


}