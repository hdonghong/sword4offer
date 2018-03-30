/**
 * NumberOf1Between1AndN_Solution class<br/>
 *
 * 题目描述
 * 整数中1出现的次数（从1到n整数中1出现的次数）
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了
 * 一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 * @author hdonghong
 * @date 2018/03/30
 */
public class NumberOf1Between1AndN_Solution {

    public int NumberOf1Between1AndN_Solution(int n) {

    }

    private int powTen(int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOf1Between1AndN_Solution().NumberOf1Between1AndN_Solution(99));
    }

}
