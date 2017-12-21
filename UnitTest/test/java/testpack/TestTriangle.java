package testpack;

import figur.Triangle;
import org.junit.*;

import static org.junit.Assert.*;

public class TestTriangle {
    private static Triangle tri1;
    private static final double x = 0;
    private static final double y = 0;
    private static final double a = 3;
    private static final double b = 5;
    private static final double c = 4;

    @BeforeClass
    public static void CreateTriangle() {
        tri1 = new Triangle(x, y, a, b, c);
    }

    @Before
    public void SetStartCondition() {
        tri1.setCoordX(x);
        tri1.setCoordY(y);
        tri1.setA(a);
        tri1.setB(b);
        tri1.setC(c);
    }

    @AfterClass
    public static void DeleteTriangle() {
        tri1 = null;
    }

    @Test
    public void checkMoveForTriangle() {
        double[] ar1 = new double[]{5.0, 4.0};
        tri1.move(5, 4);
        double[] triMove = new double[]{tri1.getCoordX(), tri1.getCoordY()};
        assertArrayEquals("invalid coordinat after moving", ar1, triMove, 0.01);
    }

    @Test
    public void checkAreaForTriangle() {
        assertTrue("Expected result is: 6, and Actual result is:" + tri1.area(), tri1.area() == 6);
    }

}
