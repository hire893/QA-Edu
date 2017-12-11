package games;

public class Snail {
    public static int[][] calculateSnail(int size){
        int [][] ar1 = new int[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
            ar1[i][j] = 5;
            System.out.print(ar1[i][j]);}
            System.out.println(" ");
        }

        return ar1;
    }
}
