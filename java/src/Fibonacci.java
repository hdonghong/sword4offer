/**
 * Fibonacci class
 *
 * 题目描述
 * 斐波那契数列
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * n<=39
 * @author hdonghong
 * @date 2018/03/22
 */
public class Fibonacci {

    public int Fibonacci(int n) {
        int i = 0;
        int j = 1;
        /*
        if (n == 0) return i;
        else if (n == 1) return j;
        else if (n < 0) throw new RuntimeException("???");

        for (int k = 2; k < n; k++) {
            j += i;
            i = j - i;
        }
        return i+j;*/

        // 别人的
        /*
        while (n-- > 0) {
            j += i;
            i = j - i;
        }
        return i;
        */

        // 递归，不推荐，写着玩
        return Fibonacci(0, 1, n);
    }

    public static int Fibonacci(int i, int j, int n) {
        if (n == 0) return 0;
        else if (n == 1) return j;
        else return Fibonacci(j, i + j, --n);
    }
}
