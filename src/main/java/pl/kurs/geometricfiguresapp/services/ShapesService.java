package pl.kurs.geometricfiguresapp.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import pl.kurs.geometricfiguresapp.ObjectMapperHolder;
import pl.kurs.geometricfiguresapp.interfaces.IShape;


import java.io.File;
import java.io.IOException;
import java.util.*;

public class ShapesService {

    ObjectMapper objectMapper = ObjectMapperHolder.INSTANCE.getObjectMapper();

    public IShape getLargestArea(List<IShape> shapeList) {
        return Optional.ofNullable(shapeList)
                .orElseThrow(() -> new NullPointerException("List is null"))
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(IShape::getArea))
                .orElseThrow(() -> new NoSuchElementException("Element not found"));
    }

    public <T extends IShape> IShape getLargestPerimeterOfType (List<IShape> shapeList, Class<T> type)  {
        if (type==null & shapeList==null){
            throw new NullPointerException("Null parameters provided");
        } else if (type==null) {
            throw new NullPointerException("Type is null");
        } else if (type.equals(IShape.class)) {
            throw new IllegalArgumentException("Uncorrect type of figure");
        }

        return  Optional.ofNullable(shapeList)
                .orElseThrow(() -> new NullPointerException("List is null"))
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> x.getClass().equals(type))
                .max(Comparator.comparing(IShape::getPerimeter))
                .orElseThrow(() -> new NoSuchElementException("Element not found"));


    }

    public void exportJson (List<IShape> shapeList, String path) throws NullPointerException, IOException {
        if(shapeList==null | path==null ){
            throw new NullPointerException("Null input parameter provided");
        }

        ArrayNode arrayNode = objectMapper.createArrayNode();
        for (IShape iShape : shapeList) {
//            if(iShape!=null)          Opcja bez zapisywania nulla do jsona, jeśli isntnieje na liście
//            {JsonNode jn = objectMapper.valueToTree(iShape);
//            arrayNode.add(jn);}
            JsonNode jn = objectMapper.valueToTree(iShape);
            arrayNode.add(jn);
        }

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), arrayNode);


    }
    public List<IShape> importJson (String path) throws IOException {
        try {
            return objectMapper.readValue(new File(path), objectMapper.getTypeFactory().constructCollectionType(
                    List.class, IShape.class));
        } catch(Exception e){
            throw new IOException("Invalid input file");
        }


    }

}
