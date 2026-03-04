package _03_method_overriding;

class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    void makeSound() {
        System.out.println(name + " makes a sound");
    }

    void eat() {
        System.out.println(name + " is eating");
    }

    void sleep() {
        System.out.println(name + " is sleeping");
    }
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }

    void makeSound() {
        System.out.println(name + " barks: Woof! Woof!");
    }

    void eat() {
        System.out.println(name + " is eating dog food");
    }

    void fetch() {
        System.out.println(name + " is fetching the ball");
    }
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }

    void makeSound() {
        System.out.println(name + " meows: Meow! Meow!");
    }

    void eat() {
        System.out.println(name + " is eating cat food");
    }

    void scratch() {
        System.out.println(name + " is scratching");
    }
}

class Cow extends Animal {
    Cow(String name) {
        super(name);
    }

    void makeSound() {
        System.out.println(name + " moos: Moo! Moo!");
    }
}

public class MethodOverriding {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy");
        dog.makeSound();
        dog.eat();
        dog.sleep();
        dog.fetch();

        System.out.println();

        Cat cat = new Cat("Whiskers");
        cat.makeSound();
        cat.eat();
        cat.sleep();
        cat.scratch();

        System.out.println();

        Cow cow = new Cow("Bessie");
        cow.makeSound();
        cow.eat();
        cow.sleep();
    }
}
