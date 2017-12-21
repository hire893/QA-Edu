package testpack;

import figur.Square;
import org.junit.*;

import static org.junit.Assert.*;

public class TestSquare {
    private static Square square1;
    private static final double x = 0;
    private static final double y = 0;
    private static final double side = 5;

    @BeforeClass
    public static void CreateCircle() {
        square1 = new Square(0, 0, 5);
    }

    @Before
    public void SetStartCondition() {
        square1.setCoordX(x);
        square1.setCoordY(y);
        square1.setSide(side);
    }


    @Test
    public void checkMoveMethodSquareForX() {
        square1.move(5, 3);
        assertTrue("Expected result is 5, actual result is" + square1.getCoordX(), square1.getCoordX() == 5);
    }

    @Test
    public void checkMoveMethodSquareForY() {
        square1.move(5, 3);
        assertTrue("Expected result is 3, actual result is" + square1.getCoordY(), square1.getCoordY() == 3);
    }

    @Test
    public void checkAreaMethodForSquare() {
        square1.area();
        assertTrue("Expected result is 25, actual result is: " + square1.area(), square1.area() == 25);
    }

//    @Test
//    public void checkResizeMethodForSquare() {
//        square1.resize(0.5);
//        assertTrue("Expected result is 2.5, actual result is: " + square1.getSide(), square1.getSide() == 2.5);
//    }

    @Test
    public void checkResizeMethodForSquare() {
        square1.resize(0.5);
        assertEquals("Expected is :2.5, and Actual is " + square1.getSide(), 2.5, square1.getSide(), 0.01);
    }


    @AfterClass
    public static void Delete() {
        square1 = null;
    }
}
