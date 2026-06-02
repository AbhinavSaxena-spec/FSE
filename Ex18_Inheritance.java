// Exercise 18: Inheritance Example
public class Ex18_Inheritance {

    static class Animal {
        void makeSound() {
            System.out.println("Some generic animal sound.");
        }
    }

    static class Dog extends Animal {
        @Override
        void makeSound() {
            System.out.println("Bark");
        }
    }

    public static void main(String[] args) {
        Animal a = new Animal();
        a.makeSound();            // Generic sound

        Dog d = new Dog();
        d.makeSound();            // Overridden: Bark

        // Polymorphism
        Animal poly = new Dog();
        poly.makeSound();         // Still "Bark" — dynamic dispatch
    }
}
