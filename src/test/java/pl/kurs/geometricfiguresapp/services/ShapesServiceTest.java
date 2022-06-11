package pl.kurs.geometricfiguresapp.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import pl.kurs.geometricfiguresapp.models.Circle;
import pl.kurs.geometricfiguresapp.models.Rectangle;
import pl.kurs.geometricfiguresapp.models.Square;
import pl.kurs.geometricfiguresapp.interfaces.IShape;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;

public class ShapesServiceTest {

    ShapesService shapesService = new ShapesService();
    final Circle c1 = new Circle(3);
    final Circle c2 = new Circle(4);
    final Circle c3 = new Circle(5);
    final Rectangle r1 = new Rectangle(3, 4);
    final Rectangle r2 = new Rectangle(3, 5);
    final Rectangle r3 = new Rectangle(2, 5);
    final Square s1 = new Square(3);
    final Square s2 = new Square(4);
    final Square s3 = new Square(9);
    final List<IShape> list1 = List.of(c1, c2, c3, r1, r2, r3, s1, s2, s3);
    final String jsonExportPath = "src/test/resources/exporttest.json";
    final File file1 = new File(jsonExportPath);
    final String jsonImportPath = "src/test/resources/importtest.json";
    final String jsonImportPath2 = "src/test/resources/importtest2.json";




    //getLargestArea()
    @Test
    public void shouldReturnFigureWithLargestAreaInGetLargestAreaMethod() {
        assertSame(s3, shapesService.getLargestArea(list1));
    }

    @Test
    public void shouldThrowNullPointerExceptionForNullArgumentInGetLargestAreaMethod() {
        assertThrows("List is null",
                NullPointerException.class,
                () -> shapesService.getLargestArea(null));
    }

    @Test
    public void shouldThrowNullPointerExceptionForListOfNullInGetLargestAreaMethod() {

        assertThrows("Element not found",
                NoSuchElementException.class,
                () -> shapesService.getLargestArea(Collections.emptyList()));
    }

    //getLargestPerimeterOfType
    @Test
    public void shouldReturnCircleOfRadius5InGetLargestPerimeterMethod() {
        IShape returnedShape = shapesService.getLargestPerimeterOfType(list1, Circle.class);
        assertEquals(c3,returnedShape);
    }

    @Test
    public void shouldReturnSquareOfLength9InGetLargestPerimeterMethod() {
        IShape returnedShape = shapesService.getLargestPerimeterOfType(list1, Square.class);
        assertEquals(s3,returnedShape);
    }

    @Test
    public void shouldReturnRectangle3X5InGetLargestPerimeterMethod() {
        IShape returnedShape = shapesService.getLargestPerimeterOfType(list1, Rectangle.class);
        assertEquals(r2,returnedShape);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForIShapeClassParameterInGetLargestPerimeterMethod() {
//        String str=null;
//        try{
//            shapesService.getLargestPerimeterOfType(list1, IShape.class);
//        } catch(IllegalArgumentException e) {
//            str = e.getMessage();
//        }
//        assertEquals("Uncorrect type of figure",str);
        assertThrows("Uncorrect type of figure",
                IllegalArgumentException.class,
                () -> shapesService.getLargestPerimeterOfType(list1, IShape.class));
    }

    @Test
    public void shouldThrowNullPointerExceptionWhenListIsNullInGetLargestPerimeterMethod() {
       assertThrows("List is null",
               NullPointerException.class,
               ()-> shapesService.getLargestPerimeterOfType(null, Circle.class));
    }

    @Test
    public void shouldThrowNoSuchElementExceptionWhenListIsEmptyInGetLargestPerimeterMethod() {
        assertThrows("Element not found",
                NoSuchElementException.class,
                ()-> shapesService.getLargestPerimeterOfType(Collections.emptyList(), Circle.class));
    }


    @Test
    public void shouldThrowNullPointerExceptionWhenTypeIsNullInGetLargestPerimeterMethod() {
        assertThrows("Type is null",
                NullPointerException.class,
                ()-> shapesService.getLargestPerimeterOfType(list1, null));
    }

    @Test
    public void shouldThrowNullPointerExceptionWhenTypesAreNullInGetLargestPerimeterMethod() {
        assertThrows("Null parameters provided",
                NullPointerException.class,
                ()-> shapesService.getLargestPerimeterOfType(null, null));
    }

    // exportJson()
    @Test
    public void shouldThrowNullPointerExceptionForNullListInExportJsonMethod() {
        assertThrows("Null input parameter provided",
                NullPointerException.class,
                ()-> shapesService.exportJson(null, jsonExportPath));

    }

    @Test
    public void shouldThrowNullPointerExceptionForNullPathInExportJsonMethod() {
        assertThrows("Null input parameter provided",
                NullPointerException.class,
                ()->shapesService.exportJson(list1, null));
    }

    @Test
    public void shouldExportListToJsonAndCheckCorrectnessInExportJsonMethod() {
        JsonNode jn = null;
        ObjectMapper mapper = new ObjectMapper(); // pytanie, czy muszę tworzyć tu nowego ObjectMappera, czy mogę wykorzystać tego z ENUMA
        try {
            shapesService.exportJson(list1, jsonExportPath);
            jn = mapper.readTree(file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        file1.delete();

        assertEquals("square", jn.get(6).get("type").asText());
        assertEquals(3, jn.get(6).get("a").asDouble(), 0);
        assertEquals(9, jn.get(6).get("area").asDouble(), 0);
        assertEquals(12, jn.get(6).get("perimeter").asDouble(), 0);
    }

    @Test
    public void shouldImportListOfIShapeInImportJsonMethod(){
        List<IShape> importedList;
        Rectangle r=null;
        Square s=null;

        try {
            importedList = shapesService.importJson(jsonImportPath);
            r = (Rectangle) importedList.get(0);
            s = (Square) importedList.get(1);


        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(2.0, r.getA(),0);
        assertEquals(5.0, r.getB(),0);
        assertEquals(14.0, r.getPerimeter(),0);
        assertEquals(10.0, r.getArea(),0);
        assertEquals(3.0, s.getA(),0);
        assertEquals(12.0, s.getPerimeter(),0);
        assertEquals(9.0, s.getArea(),0);
    }

    @Test
    public void shouldThrowIOExceptionInImportJsonMethod(){
        assertThrows("Invalid input file",
                IOException.class,
                ()->shapesService.importJson(jsonImportPath2));
    }


}