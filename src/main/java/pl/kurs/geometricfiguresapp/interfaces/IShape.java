package pl.kurs.geometricfiguresapp.interfaces;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import pl.kurs.geometricfiguresapp.classes.Circle;
import pl.kurs.geometricfiguresapp.classes.Rectangle;
import pl.kurs.geometricfiguresapp.classes.Square;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Circle.class, name = "circle"),
        @JsonSubTypes.Type(value = Rectangle.class, name = "rectangle"),
        @JsonSubTypes.Type(value = Square.class, name = "square")})
public interface IShape {
    double getArea ();
    double getPerimeter();
}
