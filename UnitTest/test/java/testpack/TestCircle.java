package testpack;

import figur.Circle;
import org.junit.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class TestCircle {
    private static Circle circle1;
    private static double x = 0;
    private static double y = 0;
    private static double r = 5;

    @BeforeClass
    public static void CreateCircle() {
        circle1 = new Circle(x, y, r);
    }

    @Before
    public void SetStartCondition() {
        circle1.setCoordX(x);
        circle1.setCoordY(y);
        circle1.setRadius(r);
    }

    //    @After
//    public void DeleteCircle() {
//        circle1 = null;
//    }
    @Test
    public void checkMoveMethodforCircleforX() {
        circle1.move(5, 3);
        assertTrue("Expected result is 5, actual result is" + circle1.getCoordX(), circle1.getCoordX() == 5);
    }

    @Test
    public void checkMoveMethodforCircleforY() {
        circle1.move(5, 3);
        assertTrue("Expected result is 3, actual result is" + circle1.getCoordY(), circle1.getCoordY() == 3);
    }

    @Test
    public void checkAreaMethodforCircle() {
        circle1.area();
        assertTrue("Expected result is 78.5, actual result is " + circle1.area(), circle1.area() == 78.5);
    }

    @Test
    public void checkResizeMethodforCircle() {
        circle1.resize(0.5);
        assertTrue("Expected result is 2.5, actual result is " + circle1.getRadius(), circle1.getRadius() == 2.5);
    }

    @Test
    public void checkNegativeResizeMethodforCircle() {
        circle1.resize(1.01);
        assertFalse("Expected result: method not working", circle1.getRadius() == 5.05);
    }
}
