import java.util.ArrayList;
import java.util.List;

/**
 * MovingCount class<br/>
 *
 * 机器人的运动范围
 * 题目描述
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），
 * 因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 * @author hdonghong
 * @since 2018/11/03
 */
public class MovingCount {

    public int movingCount(int threshold, int rows, int cols) {
        boolean[] visited = new boolean[rows * cols];
        return movingCount(threshold, rows, cols, 0, 0, visited, 0);
    }

    private int movingCount(int threshold, int rows, int cols, int row, int col, boolean[] visited, int count) {
        if (row >= 0 && row < rows
         && col >= 0 && col < cols
         && !visited[row * cols + col]
         && cal(row, col) <= threshold) {

            ++count;
            visited[row * cols + col] = true;

            count = movingCount(threshold, rows, cols, row, col - 1, visited, count);
            count = movingCount(threshold, rows, cols, row, col + 1, visited, count);
            count = movingCount(threshold, rows, cols, row - 1, col, visited, count);
            count = movingCount(threshold, rows, cols, row + 1, col, visited, count);
        }
        return count;
    }

    private int cal(int a, int b) {
        int ret = 0;
        while (a != 0) {
            ret += a % 10;
            a /= 10;
        }
        while (b != 0) {
            ret += b % 10;
            b /= 10;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new MovingCount().cal(35, 38));
    }
}
