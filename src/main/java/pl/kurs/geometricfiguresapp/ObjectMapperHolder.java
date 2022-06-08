package pl.kurs.geometricfiguresapp;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import pl.kurs.geometricfiguresapp.interfaces.IShape;
import pl.kurs.geometricfiguresapp.serializers.ShapeDeserializer;
import pl.kurs.geometricfiguresapp.serializers.ShapeSerializer;
import pl.kurs.geometricfiguresapp.services.ShapesService;

import java.text.SimpleDateFormat;

public enum ObjectMapperHolder {
    INSTANCE;
    private ObjectMapper objectMapper;

    ObjectMapperHolder() {
        this.objectMapper = create();
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    private static ObjectMapper create() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        mapper.configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS,false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        mapper.findAndRegisterModules();
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        ShapeSerializer shapeSerializer = new ShapeSerializer(IShape.class);
        SimpleModule sm1 = new SimpleModule();
        sm1.addSerializer(IShape.class, shapeSerializer);
        mapper.registerModule(sm1);

        ShapeDeserializer shapeDeserializer = new ShapeDeserializer(IShape.class);
        SimpleModule sm2 = new SimpleModule();
        sm2.addDeserializer(IShape.class, shapeDeserializer);
        mapper.registerModule(sm2);

        return mapper;
    }

}
