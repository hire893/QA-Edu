package figur;

public class Square extends Geometry {

    public double getCoordinatX() {
        return coordX;
    }

    public void setCoordinatX(double coordinatX) {
        this.coordX = coordinatX;
    }

    public double getCoordinatY() {
        return coordY;
    }

    public void setCoordinatY(double coordinatY) {
        this.coordY = coordinatY;
    }


    public Square(double coordinatX, double coordinatY, double side) {
        this.coordX = coordinatX;
        this.coordY = coordinatY;
        this.side = side;
    }

    @Override
    public void move(int stepX, int stepY) {
        coordX += stepX;
        coordY += stepY;
    }

    @Override
    public double area() {
        double area = side * side;
        return area = Math.rint(100.0 * area) / 100.0;
    }

//    @Override
//    public double area(double a, double b, double c) {
//        double area = c * c;
//        return area;
//    }

    @Override
    public void resize(double resizeCoeff) {
        side *= resizeCoeff;
    }
}
