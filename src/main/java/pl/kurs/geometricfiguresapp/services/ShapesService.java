package pl.kurs.geometricfiguresapp.services;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidTypeIdException;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;

import com.sun.jdi.ClassType;
import pl.kurs.geometricfiguresapp.ObjectMapperHolder;
import pl.kurs.geometricfiguresapp.classes.Circle;
import pl.kurs.geometricfiguresapp.classes.Rectangle;
import pl.kurs.geometricfiguresapp.interfaces.IShape;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.util.*;

public class ShapesService {

    ObjectMapper objectMapper = ObjectMapperHolder.INSTANCE.getObjectMapper();

    public IShape getLargestArea(List<IShape> shapeList) {
        return Optional.ofNullable(shapeList)
                .orElseThrow(() -> new NullPointerException("Przekazano pustą liste"))
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(IShape::getArea))
                .orElseThrow(() -> new NoSuchElementException("Przekazano pustą liste elementow"));
    }

    public <T extends IShape> IShape getLargestPerimeterOfType (List<IShape> shapeList, Class<T> type)  {
        if (type.equals(IShape.class)){
            throw new IllegalArgumentException("Niewlasciwy typ figury");
        }

        return  Optional.ofNullable(shapeList)
                .orElseThrow(() -> new NullPointerException("Przekazano pustą liste"))
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> x.getClass().equals(type))
                .max(Comparator.comparing(IShape::getPerimeter))
                .orElseThrow(() -> new NoSuchElementException("Nie znaleziono elementu"));


    }

    public void exportJson (List<IShape> shapeList, String path) throws NullPointerException, IOException {
        if(shapeList==null | path==null ){
            throw new NullPointerException("Null input parameter provided");
        }



        ArrayNode arrayNode = objectMapper.createArrayNode();
        for (IShape iShape : shapeList) {
//            if(iShape!=null)                                      Opcja bez zapisywania nulla do jsona, jeśli isntnieje na liście
//            {JsonNode jn = objectMapper.valueToTree(iShape);
//            arrayNode.add(jn);}
            JsonNode jn = objectMapper.valueToTree(iShape);
            arrayNode.add(jn);
        }

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), arrayNode);


    }
    public List<IShape> importJson (String path) throws IOException {
        JsonNode jn1 = objectMapper.readTree(new File(path));

        try {
            return objectMapper.readValue(new File(path), objectMapper.getTypeFactory().constructCollectionType(
                    List.class, IShape.class));
        } catch(InvalidTypeIdException e){
            throw new IOException("Nie rozpoznano typu");
        }


    }

}
