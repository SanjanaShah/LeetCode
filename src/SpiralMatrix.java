/*
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * Example:
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * @author Sanjana Shah
 */
import java.lang.*;
public class SpiralMatrix {
//    static int[][] spiralFill(int m, int n) {
//        int[][] a = new int[n][n];
//        int val = 1;
//        int k = 0, l = 0;
//        while (k < m && l < n) {
//            for (int i = l; i < n; ++i) {
//                a[k][i] = val++;
//            }
//            k++;
//            for (int i = k; i < m; ++i) {
//                a[i][n - 1] = val++;
//            }
//            n--;
//            if (k < m) {
//                for (int i = n - 1; i >= l; --i) {
//                    a[m - 1][i] = val++;
//                }
//                m--;
//            }
//            if (l < n) {
//                for (int i = m - 1; i >= k; --i) {
//                    a[i][l] = val++;
//                }
//                l++;
//            }
//        }
//        return a;
//    }

//    i used two variables, directionX and directionY. Changed it to +1 or -1 depending on which direction i want to go
//    then add that to x and y
//    matrix[x+directonX][y+directionY= num++
//            if () directionX = -directionX
//if () directionY = -directionY

    static int[][] spiralFill(int n) {
        int[][] arr = new int[n][n];
        int value = 1;
        int directionX = 0, directionY = 1;
        int colsCompleted = 0, rowsCompleted = 0;
        int x = 0, y = 0;
        while(value <= Math.pow(n, 2)) {
            arr[x][y] = value;
            value++;
            x += directionX;
            y += directionY;

            if(y == n - rowsCompleted - 1 && directionY == 1) {
                //System.out.println("down");
                rowsCompleted++;
                directionX = 1;
                directionY = 0;
            } else if(x == n - colsCompleted - 1 && directionX == 1) {
                //System.out.println("back");
                colsCompleted++;
                directionX = 0;
                directionY = -1;
            } else if(y == rowsCompleted - 1 && directionY == -1) {
                //System.out.println("up");
                //rowsCompleted++;
                directionX = -1;
                directionY = 0;
            } else if(x == colsCompleted && directionX == -1) {
                //System.out.println("forward");
                //colsCompleted++;
                directionX = 0;
                directionY = 1;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        SpiralMatrix sm = new SpiralMatrix();
        int[][] a = sm.spiralFill(10);

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(a[i][j] >= 100)
                    System.out.print(a[i][j] + " ");
                else if(a[i][j] >= 10)
                    System.out.print(a[i][j] + "  ");
                else
                    System.out.print(a[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
