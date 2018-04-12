import sun.font.TrueTypeFont;

import java.util.ArrayList;

/**
 * GetLeastNumbers_Solution class<br/>
 *
 * 最小的K个数
 *
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * @author hdonghong
 * @date 2018/04/12
 */
public class GetLeastNumbers_Solution {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        // 首先想到的是快排 O(nlgn + k)，或是遍历 O(kn)
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length < 1 || k > input.length)
            return list;

        quickSort(input, 0, input.length-1);
        for (int i = 0; i < k; i++)
            list.add(input[i]);
        return list;
    }

    private static void quickSort(int[] input, int lo, int hi) {
        int i = lo, j = hi + 1;
        int v = input[lo];
        while (true) {
            while (input[++i] < v) if (i >= hi) break;
            while (input[--j] >= v) if (j <= lo) break;
            if (i >= j) break;
            input[i] += input[j];
            input[j] = input[i] - input[j];
            input[i] = input[i] - input[j];
        }
        if (lo < j) {
            input[lo] += input[j];
            input[j] = input[lo] - input[j];
            input[lo] = input[lo] - input[j];
            quickSort(input, lo, j-1);
        }
        if (j+1 < hi) {
            quickSort(input, j + 1, hi);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GetLeastNumbers_Solution()
                .GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8}, 4));
    }
}
