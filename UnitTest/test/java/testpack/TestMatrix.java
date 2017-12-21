package testpack;
import games.Matrix;
import org.junit.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestMatrix {

    private int x = 5;
    //private int count = 0;
    int[][] array = Matrix.createMatrix(x); //

    @Test
    public void checkMaxValueArray() {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        assertTrue("Expected: the biggest value in array is 9, and Actual result is: " + max, max == 9);
    }

    @Test
    public void checkMinValueArray() {
        int min = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] < min) {
                    min = array[i][j];
                }
            }
        }
        assertFalse("Expected: the lowest value in array is not 1, and Actual result is: " + min, min != 1);
    }

    @Test
    public void checkNumberOfElements() {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                count = count + 1;
            }
        }
        assertFalse("Expected: number of elements of array: 25, actual: " + count, count != 25);
    }
}



