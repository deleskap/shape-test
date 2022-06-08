package pl.kurs.geometricfiguresapp.classes;

import pl.kurs.geometricfiguresapp.interfaces.IShape;

public class Square implements IShape {
    private double a;

    public Square(double a) {
        this.a = a;
    }
    public String getType(){
        return this.getClass().getSimpleName();
    }


    public double getA() {
        return a;
    }

    @Override
    public double getArea() {
        return a*a;
    }

    @Override
    public double getPerimeter() {

        return 4*a;
    }

    @Override
    public String toString() {
        return "Square{" +
                "a=" + a +
                '}';
    }
}
