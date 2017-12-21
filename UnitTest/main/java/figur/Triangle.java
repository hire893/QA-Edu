package figur;

public class Triangle extends Geometry {

    public Triangle(double firstX, double firstY, double sideA, double sideB, double sideC) {
        this.coordX = firstX;
        this.coordY = firstY;
        this.a = sideA;
        this.b = sideB;
        this.c = sideC;
    }

    @Override
    public void move(int stepX, int stepY) {
        coordX += stepX;
        coordY += stepY;
    }

//    @Override
//    public double area(double radius) {
//        return 0;
//    }

    @Override
    public double area() {
        double area = (a + b + c) / 2;
        return area = Math.rint(100.0 * area) / 100.0;
    }

    @Override
    public void resize(double resizeCoeff) {
        this.a *= resizeCoeff;
        this.b *= resizeCoeff;
        this.c *= resizeCoeff;
    }
}
