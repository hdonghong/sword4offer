import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * MoreThanHalfNum_Solution class<br/>
 *
 * 题目描述
 * 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2
 * 在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * @author hdonghong
 * @date 2018/03/30
 */
public class MoreThanHalfNum_Solution {

    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int e : array) {
            Integer i;
            if ((i = map.get(e)) != null) {
                map.put(e, ++i);
            } else {
                map.put(e, 1);
            }
        }
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            if (map.get(key) > array.length>>1) {
                return key;
            }
        }
        return 0;

        // 大佬的思路：数组排序后，如果符合条件的数存在，则一定是数组中间那个数
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(new MoreThanHalfNum_Solution().MoreThanHalfNum_Solution(ints));
    }
}
