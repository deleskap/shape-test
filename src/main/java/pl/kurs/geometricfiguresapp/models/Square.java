package pl.kurs.geometricfiguresapp.models;

import com.fasterxml.jackson.annotation.JsonTypeName;
import pl.kurs.geometricfiguresapp.interfaces.IShape;

import java.util.Objects;

@JsonTypeName("square")
public class Square implements IShape {
    private double a;

    public Square() {
    }

    public Square(double a) {
        this.a = a;

    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    @Override
    public double getArea() {
        return a * a;
    }

    @Override
    public double getPerimeter() {

        return 4 * a;
    }

    @Override
    public String toString() {
        return "Square{" +
                "a=" + a +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(square.a, a) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }
}
