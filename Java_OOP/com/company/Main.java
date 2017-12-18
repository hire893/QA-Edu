package com.company;

import figur.Geometry;
import figur.Square;
import figur.Triangle;
import figur.Circle;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Random x = new Random();
        Geometry[] arrayFigure = new Geometry[10];
        for (int i = 0; i < 10; i++) {
            int rand = random.nextInt(3);
            switch (rand) {
                case 0:
                    arrayFigure[i] = new Circle(x.nextInt(10), x.nextInt(10), x.nextInt(10));
                    System.out.println(arrayFigure[i]);
                    System.out.println("Радиус круга: " + arrayFigure[i].getRadius());
                    System.out.println("Площадь круга: " + arrayFigure[i].area());
                    System.out.println("Координаты начальной точки X = " + arrayFigure[i].getCoordX() + "; Y = " + arrayFigure[i].getCoordY());
                    System.out.println("----------------------------------------------------------------------");
                    break;
                case 1:
                    arrayFigure[i] = new Square(x.nextInt(10), x.nextInt(10), x.nextInt(10));
                    System.out.println(arrayFigure[i]);
                    System.out.println("Сторона квадрата: " + arrayFigure[i].getSide());
                    System.out.println("Площадь квадрата: " + arrayFigure[i].area());
                    System.out.println("Координаты начальной точки X = " + arrayFigure[i].getCoordX() + "; Y = " + arrayFigure[i].getCoordY());
                    System.out.println("----------------------------------------------------------------------");
                    break;
                case 2:
                    arrayFigure[i] = new Triangle(x.nextInt(10), x.nextInt(10), x.nextInt(10), x.nextInt(10), x.nextInt(10));
                    System.out.println(arrayFigure[i]);
                    System.out.println("Стороны треугольника: a=" + arrayFigure[i].getA() + " b=" + arrayFigure[i].getB() + " c= " + arrayFigure[i].getC());
                    System.out.println("Площадь треугольника: " + arrayFigure[i].area());
                    System.out.println("Координаты начальной точки X = " + arrayFigure[i].getCoordX() + "; Y = " + arrayFigure[i].getCoordY());
                    System.out.println("----------------------------------------------------------------------");
                    break;
            }
        }
        System.out.println("Ресайз!!! Умножаем стороны фигур на случайный коэффициент от 0 до 1");
        for (int i = 0; i < 10; i++) {
            arrayFigure[i].resize(Math.random());
            System.out.println("Площадь измененной фигуры: " + arrayFigure[i].area());
        }
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arrayFigure[j].area() < arrayFigure[j + 1].area()) {
                    Geometry tmp = arrayFigure[j];
                    arrayFigure[j] = arrayFigure[j + 1];
                    arrayFigure[j + 1] = tmp;
                }
            }
        }
        System.out.println("----------Отсортированный массив фигур-----------");
        for (int i = 0; i < 10; i++) {
            System.out.println("Фигура: " + arrayFigure[i] + " Площадь измененной фигуры: " + arrayFigure[i].area());
        }
    }
}
