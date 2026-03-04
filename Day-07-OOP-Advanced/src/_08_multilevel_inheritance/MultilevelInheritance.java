package _08_multilevel_inheritance;

// Level 1
class LivingBeing {
    void breathe() {
        System.out.println("Living  being is breathing");
    }

    void grow() {
        System.out.println("Living being is growing");
    }
}

// Level 2
class Animal extends LivingBeing {
    String name;

    Animal(String name) {
        this.name = name;
    }

    void eat() {
        System.out.println(name  + " is eating");
    }

    void move() {
        System.out.println(name + " is moving");
    }
}

// Level 3
class Dog extends Animal {
    String breed;

    Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }

    void bark() {
        System.out.println(name + " (" + breed + ") is barking");
    }

    void displayInfo() {
        System.out.println("=== Dog Information ===");
        System.out.println("Name: " + name);
        System.out.println("Breed: " + breed);
    }
}

// Level 4
class Puppy extends Dog {
    int ageMonths;

    Puppy(String name, String breed, int ageMonths) {
        super(name, breed);
        this.ageMonths = ageMonths;
    }

    void play() {
        System.out.println(name + " the puppy is playing");
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Age: " + ageMonths + " months");
        System.out.println("Status: Puppy");
    }
}

public class MultilevelInheritance {
    public static void main(String[] args) {
        Puppy puppy = new Puppy("Max", "Golden Retriever", 3);

        puppy.displayInfo();
        System.out.println();

        // Can use methods from ALL levels
        puppy.breathe();    // From LivingBeing
        puppy.grow();       // From LivingBeing
        puppy.eat();        // From Animal
        puppy.move();       // From Animal
        puppy.bark();       // From Dog
        puppy.play();       // From Puppy
    }
}
