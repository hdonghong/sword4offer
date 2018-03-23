/**
 * JumpFloorII class
 *
 * 题目描述
 * 变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author hdonghong
 * @date 2018/03/23
 */
public class JumpFloorII {
    public int JumpFloorII(int target) {
        /*
            参考别人的分析：
            关注第一次跳几级台阶（->表示跳，如3 -> 2，表示3级台阶第一次跳两阶）
            f(1) = 1
            f(2) = f(2 -> 1) + f(2 -> 2)
            f(3) = f(3 -> 1) + f(3 -> 2) + f(3 -> 3)
            ...
            f(n) = f(n -> 1) + f(n -> 2) + f(n -> 3) + ... + f(n -> n)
                 = f(n-1) + f(n-2) + f(n-3) + ... f(0)
            f(n-1) = f(n-2) + f(n-3) + ... f(0)
            则
            f(n) = 2 * f(n-1)
         */
        /*
        if (target == 0 || target == 1) return 1;
        else {
            return 2 * JumpFloorII(target-1);
        }
        */

        // 更屌的思考：除了最后一个台阶，其它每个台阶都有跳与不跳两种选择，总选择有：2^(n-1)
        return 1 << (target-1);

    }

    public static void main(String[] args) {
        System.out.println(new JumpFloorII().JumpFloorII(3));
    }
}
