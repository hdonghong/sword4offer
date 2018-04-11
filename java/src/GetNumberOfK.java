/**
 * GetNumberOfK class<br/>
 *
 * 题目描述
 * 数字在排序数组中出现的次数
 * 统计一个数字在排序数组中出现的次数。
 * @author hdonghong
 * @date 2018/04/11
 */
public class GetNumberOfK {

    public int GetNumberOfK(int [] array , int k) {
        if (   array == null
            || array.length == 0
            || k < array[0]
            || k > array[array.length-1])
            return 0;
        int left = 0, right = array.length - 1;
        int mid = (left + right) >> 1;
        while (left <= right) {
            if (k > array[mid]) {
                left = mid + 1;
            } else if ( k < array[mid]) {
                right = mid - 1;
            } else {
                break;
            }
            mid = (left + right) >> 1;
        }
        if (k != array[mid]) return 0;

        int i = mid-1, j = mid+1;
        while (i >= 0 && k == array[i]) i--;
        while (j < array.length && k == array[j]) j++;

        return j-i-1;
    }

    public static void main(String[] args) {
        System.out.println(new GetNumberOfK().GetNumberOfK(new int[]{1,2,3,3,3,3,4,5},3));
    }
}
