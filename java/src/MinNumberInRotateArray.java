/**
 * MinNumberInRotateArray class
 *
 * 题目描述
 * 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。 例如
 * 数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @author hdonghong
 * @date 2018/03/21
 */
public class MinNumberInRotateArray {

    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0) return 0;
        /* 最笨的方法；没有意义
        int result = array[0];
        for (int e : array) {
            if (result > e) {
                result = e;
            }
        }
        return reault;
        */
        /* 优化一点：
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] < array[i]) {
                return array[i + 1];
            }
        }

        return array[0];
        */

        // 二分
        int left = 0;
        int right = array.length - 1;
        int mid  = 0;
        while (left < right) {
            if (right - left == 1) {
                mid = right;
                break;
            }

            mid = (left + right) / 2;
            if (array[mid] == array[left] && array[mid] == array[right]) {
                // 无法确定最小元素在哪一边，迭代查找
                int result = array[left];
                for (int i = left + 1; i < right; i++) {
                    if (result > array[i]) {
                        result = array[i];
                    }
                }
                return result;
            }
            if (array[mid] >= array[left]) {
                // mid处于第一个递增序列，最小元素在mid右边
                left = mid;
            } else {
                // mid处于第二个递增序列，最小元素在mid左边
                right = mid;
            }
        }
        return array[mid];

    }

    public static void main(String[] args) {
        MinNumberInRotateArray m = new MinNumberInRotateArray();
        int[] array = {3, 4, 5, 5, 5, 1, 2};
//        int[] array = {6501,6828,6963,7036,7422,7674,8146,8468,8704,8717,9170,9359,9719,9895,9896,9913,9962,154,293,334,492,1323,1479,1539,1727,1870,1943,2383,2392,2996,3282,3812,3903,4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335};
        System.out.println(m.minNumberInRotateArray(array));
    }
}
