package games;

public class Snail {
    public static int[][] calculateSnail(int size) {
        int[][] ar1 = new int[size][size];

        int currentNum = size * size;
        int direction;
        int finI = size - 1;
        int startI = 0;
        int startJ = 0;
        int finJ = size - 1;
        if (size % 2 == 0) direction = 1;
        else direction = 3;
        while (currentNum >= 1) switch (direction) {
            //right ++
            case 1: {
                for (int i = startJ; i <= finJ; i++) {
                    ar1[finI][i] = currentNum;
                    currentNum--;
                }
                finI--;
                direction = 2;
                break;
            }
            //up ++
            case 2: {
                for (int i = finI; i >= startI; i--) {
                    ar1[i][finJ] = currentNum;
                    currentNum--;
                }
                finJ--;
                direction = 3;
                break;
            }
            //left ++
            case 3: {
                for (int i = finJ; i >= startJ; i--) {
                    ar1[startI][i] = currentNum;
                    currentNum--;
                }
                startI++;
                direction = 4;
                break;
            }
            //down
            case 4: {
                for (int i = startI; i <= finI; i++) {
                    ar1[i][startJ] = currentNum;
                    currentNum--;
                }
                startJ++;
                direction = 1;
                break;
            }
        }
        for (int[] anAr1 : ar1) {
            for (int j = 0; j < ar1.length; j++) {
                System.out.printf("%2d", anAr1[j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        return ar1;
    }
}