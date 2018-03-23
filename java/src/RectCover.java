/**
 * RectCover class
 *
 * 题目描述
 * 矩形覆盖
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * @author hdonghong
 * @date 2018/03/23
 */
public class RectCover {
    public int RectCover(int target) {
        // 解题思路：考斐波那契数列，同跳1/2级台阶
        /*
        if (target < 0) throw new RuntimeException("??");
        else if (target == 0 ||
                target == 1 ||
                target == 2) return target;
        else {
            return RectCover(target - 1) + RectCover(target - 2);
        }
        */

        // 迭代
        if (target < 0) throw new RuntimeException("??");
        else if (target == 0) return target;
        else {
            int i = 1;
            int j = 2;
            while (target-- > 1) {
                j += i;
                i = j - i;
            }
            return i;
        }

    }
}
