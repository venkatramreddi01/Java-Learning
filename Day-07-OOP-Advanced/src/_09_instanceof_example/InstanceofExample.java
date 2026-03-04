package _09_instanceof_example;

class Animal{
    void makeSound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Woof!");
    }

    void fetch() {
        System.out.println("Dog is fetching");
    }
}

class Cat extends Animal {
    void makeSound() {
        System.out.println("Meow!");
    }

    void scratch() {
        System.out.println("Cat is scratching");
    }
}

class Bird extends Animal {
    void makeSound() {
        System.out.println("Chirp!");
    }

    void fly() {
        System.out.println("Bird is flying");
    }
}

public class InstanceofExample {

    static void identifyAnimal(Animal animal) {
        System.out.println("\n=== Identifying Animal ===");

        // Check type using instanceof
        if (animal instanceof Dog) {
            System.out.println("This is a Dog!");
            Dog dog = (Dog) animal;  // Downcasting
            dog.makeSound();
            dog.fetch();
        } else if (animal instanceof Cat) {
            System.out.println("This is a Cat!");
            Cat cat = (Cat) animal;
            cat.makeSound();
            cat.scratch();
        } else if (animal instanceof Bird) {
            System.out.println("This is a Bird!");
            Bird bird = (Bird) animal;
            bird.makeSound();
            bird.fly();
        } else {
            System.out.println("Unknown animal type");
            animal.makeSound();
        }

        // All are animals
        if (animal instanceof Animal) {
            System.out.println("(And yes, it IS an Animal!)");
        }
    }

    public static void main(String[] args) {
        Animal animal1 = new Dog();
        Animal animal2 = new Cat();
        Animal animal3 = new Bird();

        identifyAnimal(animal1);
        identifyAnimal(animal2);
        identifyAnimal(animal3);
    }
}
