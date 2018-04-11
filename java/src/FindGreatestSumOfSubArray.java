/**
 * FindGreatestSumOfSubArray class<br/>
 *
 * 题目描述
 * 连续子数组的最大和
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:
 * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题
 * 很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它
 * 呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为
 * 止)。你会不会被他忽悠住？(子向量的长度至少是1)
 * @author hdonghong
 * @date 2018/04/11
 */
public class FindGreatestSumOfSubArray {

    /** 分治 */
    /*
    public int FindGreatestSumOfSubArray(int[] array) {
        return FindGreatestSumOfSubArray(array, 0, array.length-1);
    }

    private int FindGreatestSumOfSubArray(int[] array, int left, int right) {
        // 如果只有一个，直接返回
        if (left == right) {
            return array[left];
        }

        // 求左右边最大
        int mid = (left + right) >> 1;
        int leftMax = FindGreatestSumOfSubArray(array, left, mid);
        int rightMax = FindGreatestSumOfSubArray(array, mid+1, right);

        // 跨越边界最大
        int currLeftBorder = 0, currRightBorder = 0;
        int leftBorderMax = Integer.MIN_VALUE, rightBorderMax = Integer.MIN_VALUE;
        for (int i = mid; i >= 0; i--) {
            currLeftBorder += array[i];
            if (currLeftBorder > leftBorderMax)
                leftBorderMax = currLeftBorder;
        }
        for (int i = mid+1; i <= right; i++) {
            currRightBorder += array[i];
            if (currRightBorder > rightBorderMax)
                rightBorderMax = currRightBorder;
        }
        return max3(leftMax, rightMax, leftBorderMax+rightBorderMax);
    }

    private int max3(int a, int b, int c) {
        return a > b ? a > c ? a : c : b > c ? b : c;
    }
    */

    /**
     *
     使用动态规划
     F（i）：以array[i]为末尾元素的子数组的和的最大值，子数组的元素的相对位置不变
     F（i）=max（F（i-1）+array[i] ， array[i]）
     res：所有子数组的和的最大值
     res=max（res，F（i））

     如数组[6, -3, -2, 7, -15, 1, 2, 2]
     初始状态：
         F（0）=6
         res=6
     i=1：
         F（1）=max（F（0）-3，-3）=max（6-3，3）=3
         res=max（F（1），res）=max（3，6）=6
     i=2：
         F（2）=max（F（1）-2，-2）=max（3-2，-2）=1
         res=max（F（2），res）=max（1，6）=6
     i=3：
         F（3）=max（F（2）+7，7）=max（1+7，7）=8
         res=max（F（2），res）=max（8，6）=8
     i=4：
         F（4）=max（F（3）-15，-15）=max（8-15，-15）=-7
         res=max（F（4），res）=max（-7，8）=8
     以此类推
     最终res的值为8
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length < 1)
            throw new RuntimeException("xxx");

        int currMax = array[0];
        int result = array[0];

        for (int i = 1; i < array.length; i++) {
            currMax = Math.max(currMax+array[i], array[i]);
            result = Math.max(currMax, result);
        }

        return result;
    }
}
