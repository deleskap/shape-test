package pl.kurs.geometricfiguresapp.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import pl.kurs.geometricfiguresapp.classes.Circle;
import pl.kurs.geometricfiguresapp.classes.Rectangle;
import pl.kurs.geometricfiguresapp.classes.Square;
import pl.kurs.geometricfiguresapp.interfaces.IShape;

import java.io.IOException;

public class ShapeSerializer extends StdSerializer<IShape> {

    public ShapeSerializer(Class<IShape> t) {
        super(t);
    }

    @Override
    public void serialize(IShape shape, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("type", shape.getClass().getSimpleName());






        if(shape.getClass().equals(Square.class)){
            jsonGenerator.writeNumberField("length", ((Square) shape).getA());
        }

        if(shape.getClass().equals(Circle.class)){
            jsonGenerator.writeNumberField("radius", ((Circle) shape).getR());
        }

        if(shape.getClass().equals(Rectangle.class)){
            jsonGenerator.writeNumberField("length", ((Rectangle) shape).getA());
            jsonGenerator.writeNumberField("width", ((Rectangle) shape).getB());
        }

        jsonGenerator.writeNumberField("area", shape.getArea());
        jsonGenerator.writeNumberField("perimeter", shape.getPerimeter());

        jsonGenerator.writeEndObject();
    }
}
