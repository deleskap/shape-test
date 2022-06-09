package pl.kurs.geometricfiguresapp.app;

import pl.kurs.geometricfiguresapp.ObjectMapperHolder;
import pl.kurs.geometricfiguresapp.classes.Circle;
import pl.kurs.geometricfiguresapp.classes.Rectangle;
import pl.kurs.geometricfiguresapp.classes.Square;
import pl.kurs.geometricfiguresapp.interfaces.IShape;
import pl.kurs.geometricfiguresapp.services.ShapesService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws IOException {
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


        shapesService.exportJson(list1,"src/main/resources/exporttest.json");
        List<IShape> imported = shapesService.importJson("src/main/resources/exporttest.json");
        System.out.println(imported);
//        imported.get(0).getArea();
//        Circle circle = (Circle) imported.get(0);
//
//        System.out.println("c1.getR() = " + c1.getR());
//
//
//        System.out.println("circle.getR() = " + circle.getR());
//        System.out.println("circle.getArea() = " + circle.getArea());
//        System.out.println("circle.getPerimeter() = " + circle.getPerimeter());

//        IShape largestAreaShape1 = shapesService.getLargestArea(list1);
//        System.out.println("largestAreaShape1.getArea() = " + largestAreaShape1.getArea());
//        System.out.println("largestAreaShape1.getPerimeter() = " + largestAreaShape1.getPerimeter());

//        IShape largestAreaShape2 = shapesService.getLargestArea(list2);
//        System.out.println("largestAreaShape2.getArea() = " + largestAreaShape2.getArea());
//        System.out.println(
//        "largestAreaShape2.getPerimeter() = " + largestAreaShape2.getPerimeter());

//        IShape largestAreaShape3 = shapesService.getLargestArea(list3);
//        System.out.println("largestAreaShape3.getArea() = " + largestAreaShape3.getArea());
//        System.out.println("largestAreaShape3.getPerimeter() = " + largestAreaShape3.getPerimeter());

//        try {
//        IShape largestPerimeterShape = shapesService.getLargestPerimeterOfType(list1, IShape.class);
//        System.out.println("largestPerimeterShape.getPerimeter() = " + largestPerimeterShape.getPerimeter());}
//        catch (RuntimeException e) {
//            e.printStackTrace();
//        }

//
//        IShape largestPerimeterShape2 = shapesService.getLargestPerimeterOfType(list3, Circle.class);
//        System.out.println("largestPerimeterShape2.getPerimeter() = " + largestPerimeterShape2.getPerimeter());
    }
}
