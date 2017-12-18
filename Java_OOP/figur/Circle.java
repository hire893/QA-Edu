package figur;

public class Circle extends Geometry {

    public double getRadius() {
        return radius;
    }


    public void setRadius(double radius) {
        this.radius = radius;
    }


    public double getCoordX() {
        return coordX;
    }


    public void setCoordX(double coordX) {
        this.coordX = coordX;
    }


    public double getCoordY() {
        return coordY;
    }


    public void setCoordY(double coordY) {
        this.coordY = coordY;
    }

    private double radius;
    private double coordX;
    private double coordY;
    final double pi = 3.14;

    public Circle(double coordX, double coordY, double radius) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.radius = radius;
    }

    @Override
    public void move(int stepX) {
        coordX = coordX + stepX;
    }

    @Override
    public double area() {
        this.radius = radius;
        double area = pi * radius * radius;
        return area = Math.rint(100.0 * area) / 100.0;
    }

    @Override
    public void resize(double resizeKoef) {
        radius = radius * resizeKoef;
    }
}
