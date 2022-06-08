package pl.kurs.geometricfiguresapp.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jdi.ClassType;
import pl.kurs.geometricfiguresapp.ObjectMapperHolder;
import pl.kurs.geometricfiguresapp.classes.Circle;
import pl.kurs.geometricfiguresapp.classes.Rectangle;
import pl.kurs.geometricfiguresapp.interfaces.IShape;


import java.io.File;
import java.io.IOException;
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

    public void exportJson (List<IShape> shapeList, String path) throws IOException {

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(path),shapeList);


    }
    public List<IShape> importJson (String path) throws IOException {
        JsonNode jn1 = objectMapper.readTree(new File(path));
        List<IShape> importList= objectMapper.readValue(new File(path), new TypeReference<List<IShape>>() {});

        return importList;
    }

}
