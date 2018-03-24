import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * ReOrderArray class<br/>
 *
 * 题目描述
 * 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author hdonghong
 * @date 2018/03/24
 */
public class ReOrderArray {
    public void reOrderArray(int [] array) {
        if (array == null || array.length == 0) return;

        int[] odd = new int[array.length];// 奇数
        int[] even = new int[array.length];// 偶数

        int iO = 0, iE = 0;
        for (int e : array) {
            if (e % 2 == 0) even[iE++] = e;
            else odd[iO++] = e;
        }
        System.arraycopy(even, 0, odd, iO, iE);
        System.arraycopy(odd, 0, array, 0, array.length);
//        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        new ReOrderArray().reOrderArray(new int[]{1,2,3,4,5,6,7});
    }
}
