package _04_multiple_interfaces;

interface Flyable {
    void fly();
    void land();
}

interface Swimmable {
    void swim();
}

interface Walkable {
    void walk();
}

// Duck can fly, swim, and walk
class Duck implements Flyable, Swimmable, Walkable {
    String name;

    Duck(String name) {
        this.name = name;
    }


    @Override
    public void fly() {
        System.out.println(name + " the duck is flying");
    }

    @Override
    public void land() {
        System.out.println(name + " the duck is landing");
    }

    @Override
    public void swim() {
        System.out.println(name + " the duck is swimming");
    }

    @Override
    public void walk() {
        System.out.println(name + " the duck is walking");
    }
}

// Fish can only swim
class Fish implements Swimmable {
    String species;

    Fish(String species) {
        this.species = species;
    }

    @Override
    public void swim() {
        System.out.println(species + " is swimming");
    }
}

// Birds can fly and walk
class Sparrow implements Flyable, Walkable {

    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }

    @Override
    public void land() {
        System.out.println("Sparrow is landing on branch");
    }

    @Override
    public void walk() {
        System.out.println("Sparrow is hopping");
    }
}

public class MultipleInterfaces {
    public static void main(String[] args) {
        Duck duck = new Duck("Donald");
        duck.fly();
        duck.swim();
        duck.walk();
        duck.land();

        System.out.println();

        Fish fish = new Fish("Goldfish");
        fish.swim();

        System.out.println();

        Sparrow sparrow = new Sparrow();
        sparrow.fly();
        sparrow.walk();
        sparrow.land();
    }
}
