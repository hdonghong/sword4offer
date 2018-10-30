/**
 * GetUglyNumberSolution class<br/>
 *
 * 丑数
 * 题目描述
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * @author hdonghong
 * @since 2018/10/30
 */
public class GetUglyNumberSolution {

    public int GetUglyNumber_Solution(int index) {
        if (index < 1) {
            return 0;
        }
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int nextUglyIdx = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;

        while (nextUglyIdx < index) {
            int ugly = Math.min(uglyNumbers[index2] * 2,
                    Math.min(uglyNumbers[index3] * 3, uglyNumbers[index5] * 5));
            uglyNumbers[nextUglyIdx] = ugly;

            while (uglyNumbers[index2] * 2 <= ugly) {
                index2++;
            }
            while (uglyNumbers[index3] * 3 <= ugly) {
                index3++;
            }
            while (uglyNumbers[index5] * 5 <= ugly) {
                index5++;
            }

            nextUglyIdx++;
        }

        return uglyNumbers[nextUglyIdx - 1];
    }

    public static void main(String[] args) {
        System.out.println(new GetUglyNumberSolution().GetUglyNumber_Solution(3));
        System.out.println(new GetUglyNumberSolution().GetUglyNumber_Solution(4));
        System.out.println(new GetUglyNumberSolution().GetUglyNumber_Solution(5));
        System.out.println(new GetUglyNumberSolution().GetUglyNumber_Solution(6));
        System.out.println(new GetUglyNumberSolution().GetUglyNumber_Solution(7));
        System.out.println(new GetUglyNumberSolution().GetUglyNumber_Solution(8));
        System.out.println(new GetUglyNumberSolution().GetUglyNumber_Solution(10));
    }
}
