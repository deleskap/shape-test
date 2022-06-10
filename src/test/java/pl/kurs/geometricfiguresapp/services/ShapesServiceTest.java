package pl.kurs.geometricfiguresapp.services;

import com.sun.nio.sctp.AbstractNotificationHandler;
import org.junit.Before;
import org.junit.Test;
import pl.kurs.geometricfiguresapp.classes.Circle;
import pl.kurs.geometricfiguresapp.classes.Rectangle;
import pl.kurs.geometricfiguresapp.classes.Square;
import pl.kurs.geometricfiguresapp.interfaces.IShape;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class ShapesServiceTest {

    ShapesService shapesService = new ShapesService();

    Circle c1= new Circle(3);
    Circle c2 = new Circle(4);
    Circle c3 = new Circle(5);
    Rectangle r1 = new Rectangle(3,4);
    Rectangle r2 = new Rectangle(3,5);
    Rectangle r3 = new Rectangle(2,5);
    Square s1 = new Square(3);
    Square s2 = new Square(4);
    Square s3 = new Square(9);
    List<IShape> list1 = List.of(c1,c2,c3,r1,r2,r3,s1,s2,s3);


    @Test
    public void shouldReturnFigureWithLargestArea() {
        IShape returnedShape = shapesService.getLargestArea(list1);
        assertEquals(s3,returnedShape);
    }

    @Test
    public void shouldThrowNullPointerExceptionForNullArgument() {
        String str=null;
        try {
            shapesService.getLargestArea(null);
        } catch (NullPointerException e) {
            str =e.getMessage();
        }
        assertEquals(str,"Przekazano pustą liste");

    }

    @Test
    public void shouldThrowNullPointerExceptionForListOfNull() {
        String str=null;
        List<IShape> list = Collections.emptyList();

        try {
            shapesService.getLargestArea(list);
        } catch (NoSuchElementException e) {
            str =e.getMessage();
        }
        assertEquals(str,"Przekazano pustą liste elementow");

    }



}