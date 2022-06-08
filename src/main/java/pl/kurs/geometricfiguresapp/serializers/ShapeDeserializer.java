package pl.kurs.geometricfiguresapp.serializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import pl.kurs.geometricfiguresapp.classes.Circle;
import pl.kurs.geometricfiguresapp.classes.Rectangle;
import pl.kurs.geometricfiguresapp.classes.Square;
import pl.kurs.geometricfiguresapp.interfaces.IShape;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.Optional;

public class ShapeDeserializer extends StdDeserializer<IShape> {
    public ShapeDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public IShape deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode jn = jsonParser.getCodec().readTree(jsonParser);


        String type = jn.get("type").asText();

        if(type.equals("Circle")){
            double r = jn.get("radius").asDouble();
            return new Circle(r);
        }
        else if (type.equals("Rectangle")){
            double a = jn.get("length").asDouble();
            double b = jn.get("width").asDouble();
            return new Rectangle(a,b);
        }
        else if(type.equals("Square")){
            double a = jn.get("length").asDouble();
            return new Square(a);
        }
        else
        throw new IOException("Bledne dane w JSON");
    }
}
