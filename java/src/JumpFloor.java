/**
 * JumpFloor class
 *
 * 题目描述
 * 跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author hdonghong
 * @date 2018/03/22
 */
public class JumpFloor {
    public int JumpFloor(int target) {
        /*
            假设第一次跳1阶，则总次数为1+JumpFloor(target-1)
            假设第一次跳2阶，则总次数为1+JumpFloor(target-2)
            总跳法为：JumpFloor(target-1) + JumpFloor(target-2)
            实际上是斐波那契数列
         */
        // 递归的方式
        /*
        if (target <= 0) return 0;
        else if (target == 1) return 1;
        else if (target == 2) return 2;
        else return JumpFloor(target - 1) + JumpFloor(target-2);
        */

        // 迭代
        if (target <= 0) return 0;
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
