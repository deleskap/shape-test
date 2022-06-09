package pl.kurs.geometricfiguresapp.classes;

import com.fasterxml.jackson.annotation.JsonTypeName;
import pl.kurs.geometricfiguresapp.interfaces.IShape;

import java.io.Serializable;


@JsonTypeName("rectangle")
public class Rectangle implements IShape{

    private double a;
    private double b;
//    private String type;

    public Rectangle() {
    }

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
//        this.type= this.getClass().getSimpleName();
    }

//    public String getType(){
//        return this.getClass().getSimpleName();
//    }


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
