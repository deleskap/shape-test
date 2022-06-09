package pl.kurs.geometricfiguresapp.classes;

import com.fasterxml.jackson.annotation.JsonTypeName;
import pl.kurs.geometricfiguresapp.interfaces.IShape;

@JsonTypeName("square")
public class Square implements IShape {
    private double a;
//    private String type;

    public Square() {
    }

    public Square(double a) {
        this.a = a;
//        this.type= this.getClass().getSimpleName();
    }

//
//    public String getType(){
//        return this.getClass().getSimpleName();
//    }


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
