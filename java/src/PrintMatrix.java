import java.util.ArrayList;

/**
 * PrintMatrix class<br/>
 *
 * 顺时针打印矩阵
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵：
 * 1    2   3   4
 * 5    6   7   8
 * 9    10  11  12
 * 13   14  15  16
 * 则依次打印出数字 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * 1    2
 * 3    4
 * -> 1,2,4,3
 *
 * 1    2   3
 * 4    5   6
 * 7    8   9
 * -> 1,2,3,6,9,8,7,4,5
 *  right =  2; bottom = 2; left = 0; top = 1;
 *  right =  1; bottom = 1; left = 1; top = 2;
 * @author hdonghong
 * @since 2018/03/27
 */
public class PrintMatrix {
    ArrayList<Integer> result = new ArrayList<>();
    int total;
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if (!(matrix == null || matrix.length < 1 || matrix[0].length < 1)) {
            int iLength = matrix.length;
            int jLength = matrix[0].length;
            total = iLength * jLength;
            rotate(matrix, jLength - 1, iLength - 1, 0, 1);
        }
        return result;
    }

    private void rotate(int[][] matrix, int right, int bottom, int left, int top) {
        if (result.size() >= total) return;

        // 先往右边走
        for (int i = top - 1, j = left; j <= right && result.size() < total; j++) {
            result.add(matrix[i][j]);
        }

        // 然后往下走
        for (int i = top, j = right; i <= bottom && result.size() < total; i++) {
            result.add(matrix[i][j]);
        }

        // 再往左边走
        for (int i = bottom, j = right - 1; j >= left && result.size() < total; j--) {
            result.add(matrix[i][j]);
        }

        // 最后往上走
        for (int i = bottom - 1, j = left; i >= top && result.size() < total; i--) {
            result.add(matrix[i][j]);
        }

        rotate(matrix, --right, --bottom, ++left, ++top);
    }

    public static void main(String[] args) {
        PrintMatrix printMatrix = new PrintMatrix();
        System.out.println(printMatrix.printMatrix(new int[][]{
                {1}
        }));

        printMatrix = new PrintMatrix();
        System.out.println(printMatrix.printMatrix(new int[][]{
                {1, 2},
                {3, 4},
        }));

        printMatrix = new PrintMatrix();
        System.out.println(printMatrix.printMatrix(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        }));

        printMatrix = new PrintMatrix();
        System.out.println(printMatrix.printMatrix(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        }));

        printMatrix = new PrintMatrix();
        System.out.println(printMatrix.printMatrix(new int[][]{
                {1, 2, 3, 4, 5},
        }));
    }
}
