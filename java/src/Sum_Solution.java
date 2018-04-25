/**
 * Sum_Solution class<br/>
 *
 * 求1+2+3+...+n
 * 题目描述
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @author hdonghong
 * @date 2018/04/25
 */
public class Sum_Solution {

    public int Sum_Solution(int n) {
        return add(0, n);
    }

    public int add(int sum, int n) {
        sum += n;
        boolean b = (n > 0 && (sum = add(sum, --n)) > 0);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Sum_Solution().Sum_Solution(100));
    }
}
