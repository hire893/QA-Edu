package games;

public class Matrix {

    public static int[][] createMatrix(int x) {
        int a = 1;
        int[][] array = new int[x][x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                array[i][j] = a++;
                if (a > 9)
                    a = 1;
            }
        }
        return array;
    }


}





