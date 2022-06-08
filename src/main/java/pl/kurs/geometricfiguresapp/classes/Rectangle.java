package pl.kurs.geometricfiguresapp.classes;

import pl.kurs.geometricfiguresapp.interfaces.IShape;

import java.io.Serializable;

public class Rectangle implements IShape{
    private double a;
    private double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public String getType(){
        return this.getClass().getSimpleName();
    }


    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    @Override
    public double getArea() {
        return a*b;
    }

    @Override
    public double getPerimeter() {

        return 2*(a+b);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
