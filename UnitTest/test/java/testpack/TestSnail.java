package testpack;

import org.junit.*;
import games.Snail;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestSnail {
    public int x = 7;
    int max = 0;
    int[][] arSnail = new int[x][x];

    @Test
    public void checkNumberSnailElements() {

        arSnail = Snail.calculateSnail(x);
        for (int i = 0; i < arSnail.length; i++) {
            for (int j = 0; j < arSnail.length; j++) {
                if (max < arSnail[i][j]) {
                    max = arSnail[i][j];
                }
            }
        }
        assertTrue("Expected result is: the biggest element is x^2, and actual result is:" + max, max == x * x);
    }
}
