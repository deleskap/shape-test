package pl.kurs.geometricfiguresapp.interfaces;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import pl.kurs.geometricfiguresapp.models.Circle;
import pl.kurs.geometricfiguresapp.models.Rectangle;
import pl.kurs.geometricfiguresapp.models.Square;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Circle.class, name = "circle"),
        @JsonSubTypes.Type(value = Rectangle.class, name = "rectangle"),
        @JsonSubTypes.Type(value = Square.class, name = "square")})
public interface IShape {
    double getArea();

    double getPerimeter();
}
