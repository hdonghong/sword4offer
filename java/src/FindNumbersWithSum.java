import java.util.ArrayList;

/**
 * FindNumbersWithSum class<br/>
 *
 * 和为S的两个数字
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 * @author hdonghong
 * @since 2018/10/15
 */
public class FindNumbersWithSum {

    // 头尾指针，往中靠拢
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (array == null) {
            return ret;
        }

        int small = 0;
        int big = array.length - 1;
        while (small < big) {
            int temp = array[small] + array[big];
            if (temp > sum) big--;
            else if (temp < sum) small++;
            else {
                ret.add(array[small]);
                ret.add(array[big]);
                return ret;
            }
        }
        return ret;
    }

    // 题目加强可变成求和为S的连续序列（不一定只有2个）
    // 求解方式仍然是两个指针，只不过变成前后指针。
}
