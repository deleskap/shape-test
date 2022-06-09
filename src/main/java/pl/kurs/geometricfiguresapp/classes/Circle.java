package pl.kurs.geometricfiguresapp.classes;

import com.fasterxml.jackson.annotation.JsonTypeName;
import pl.kurs.geometricfiguresapp.interfaces.IShape;


@JsonTypeName("circle")
public class Circle implements IShape {

    private double r;


    public Circle() {
    }

    public Circle(double r) {
        this.r = r;
//        this.type= this.getClass().getSimpleName();
    }


//    public String getType(){
//        return this.getClass().getSimpleName();
//    }

    public double getR() {
        return r;
    }


    @Override
    public double getArea() {
        return Math.PI*r*r;
    }

    @Override
    public double getPerimeter() {
        return 2*Math.PI*r;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "r=" + r +
                '}';
    }
}
