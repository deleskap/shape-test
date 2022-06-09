package pl.kurs.geometricfiguresapp.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import pl.kurs.geometricfiguresapp.ObjectMapperHolder;
import pl.kurs.geometricfiguresapp.classes.Circle;
import pl.kurs.geometricfiguresapp.classes.Rectangle;
import pl.kurs.geometricfiguresapp.classes.Square;
import pl.kurs.geometricfiguresapp.interfaces.IShape;

import java.io.IOException;

import static com.fasterxml.jackson.core.JsonToken.START_OBJECT;

public class ShapeSerializer extends StdSerializer<IShape> {

    public ShapeSerializer(Class<IShape> t) {
        super(t);
    }

//    @Override
//    public void serializeWithType(IShape value, JsonGenerator gen, SerializerProvider serializers, TypeSerializer typeSer) throws IOException {
//        WritableTypeId typeId = typeSer.typeId(value, START_OBJECT);
//        typeSer.writeTypePrefix(gen, typeId);
//        serialize(value, gen, serializers); // call your customized serialize method
//        typeSer.writeTypeSuffix(gen, typeId);
//    }




    @Override
    public void serialize(IShape shape, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {


        jsonGenerator.writeStartObject();


//        if(shape.getClass().equals(Square.class)){
//            jsonGenerator.writeNumberField("length", ((Square) shape).getA());
//        }
//
//        if(shape.getClass().equals(Circle.class)){
//            jsonGenerator.writeNumberField("radius", ((Circle) shape).getR());
//        }
//
//        if(shape.getClass().equals(Rectangle.class)){
//            jsonGenerator.writeNumberField("length", ((Rectangle) shape).getA());
//            jsonGenerator.writeNumberField("width", ((Rectangle) shape).getB());
//        }
//
//        jsonGenerator.writeNumberField("area", shape.getArea());
//        jsonGenerator.writeNumberField("perimeter", shape.getPerimeter());

        jsonGenerator.writeEndObject();
    }




}
