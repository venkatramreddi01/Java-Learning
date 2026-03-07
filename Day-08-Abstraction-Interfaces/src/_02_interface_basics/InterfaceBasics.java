package _02_interface_basics;

// Interface
interface Drawable {
    void draw();    // public abstract by default
    void erase();
}

// Another interface
interface Colorable {
    void setColor(String color);
    void fillColor();
}

// Class implementing one interface
class Circle implements Drawable {

    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }

    @Override
    public void erase() {
        System.out.println("Erasing a circle");
    }
}

// class implementing multiple interfaces
class Rectangle implements Drawable, Colorable {
    String color;

    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }

    @Override
    public void erase() {
        System.out.println("Erasing the rectangle");
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void fillColor() {
        System.out.println("Filling rectangle with " + color + " color");
    }
}

public class InterfaceBasics {
    public static void main(String[] args) {
        Drawable circle = new Circle();
        circle.draw();
        circle.erase();

        System.out.println();

        Rectangle rect = new Rectangle();
        rect.draw();
        rect.setColor("Red");
        rect.fillColor();
        rect.erase();
    }
}
