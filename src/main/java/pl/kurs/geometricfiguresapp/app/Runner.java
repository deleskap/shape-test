package pl.kurs.geometricfiguresapp.app;


import pl.kurs.geometricfiguresapp.models.Circle;
import pl.kurs.geometricfiguresapp.models.Rectangle;
import pl.kurs.geometricfiguresapp.models.Square;
import pl.kurs.geometricfiguresapp.interfaces.IShape;
import pl.kurs.geometricfiguresapp.services.ShapesService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        ShapesService shapesService = new ShapesService();

        Circle c1 = new Circle(3);
        Circle c2 = new Circle(4);
        Circle c3 = new Circle(5);
        Rectangle r1 = new Rectangle(3, 4);
        Rectangle r2 = new Rectangle(3, 5);
        Rectangle r3 = new Rectangle(2, 5);
        Square s1 = new Square(3);
        Square s2 = new Square(4);
        Square s3 = new Square(9);

        List<IShape> list1 = new ArrayList<>();
        list1.add(c1);
        list1.add(c2);
        list1.add(c3);
        list1.add(null);
        list1.add(r1);
        list1.add(r2);
        list1.add(r3);
        list1.add(s1);
        list1.add(s2);
        list1.add(s3);


        List<IShape> list2 = null;
        List<IShape> list3 = new ArrayList<>();
        list3.add(null);

        try {
            shapesService.exportJson(list1, "src/main/resources/exporttest1.json");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        try {
            List<IShape> imported1 = shapesService.importJson("src/main/resources/exporttest1.json");
            System.out.println(imported1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //new File("src/main/resources/exporttest1.json").delete();
        IShape largestAreaShape1 = shapesService.getLargestArea(list1);
        System.out.println("largestAreaShape1.getArea() = " + largestAreaShape1.getArea());
        System.out.println("largestAreaShape1.getPerimeter() = " + largestAreaShape1.getPerimeter());
    }
}
