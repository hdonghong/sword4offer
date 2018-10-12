/**
 * NumberOf1Between1AndN_Solution class<br/>
 *
 * 题目描述
 * 整数中1出现的次数（从1到n整数中1出现的次数）
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了
 * 一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 * @author hdonghong
 * @since 2018/03/30
 */
public class NumberOf1Between1AndN_Solution {

    /**
     * 假设有值：31234，拆成：1-1234，1235-31234
     * 先求 1235-31234
     * 分成，10000-19999 与 1235-11234 11235-21234 21235-31234
     * 递归求 1234
     */
    public int NumberOf1Between1AndN_Solution(int n) {

        if (n <= 0) {
            return 0;
        }

        return NumberOf1(n + "");
    }

    private int NumberOf1(String n) {
        int length = n.length();
        if (length < 1) return 0;

        // 首位数字
        int first = n.charAt(0) - '0';
        if (length == 1) return first > 0 ? 1 : 0;

        // 先算10000-19999
        int firstNumTotal = 0;
        String otherNum = n.substring(1);
        if (first > 1) {
            firstNumTotal = powTen(length - 1);
        } else if (first == 1 && otherNum.length() > 0) {
            // 考虑数字是11234而不是31234的情况
            firstNumTotal = Integer.parseInt(otherNum) + 1;
        }

        // 再算1235-11234 11235-21234 21235-31234
        int otherNumTotal = first * (length - 1) * powTen(length - 2);

        // 最后递归算1234
        int recursiveNumTotal = NumberOf1(otherNum);

        return firstNumTotal + otherNumTotal + recursiveNumTotal;
    }

    private int powTen(int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOf1Between1AndN_Solution().NumberOf1Between1AndN_Solution(98));
        // 20

        System.out.println(new NumberOf1Between1AndN_Solution().NumberOf1Between1AndN_Solution(1));
        // 1

        System.out.println(new NumberOf1Between1AndN_Solution().NumberOf1Between1AndN_Solution(10));
        // 2

        System.out.println(new NumberOf1Between1AndN_Solution().NumberOf1Between1AndN_Solution(2));
        // 1
    }

}
