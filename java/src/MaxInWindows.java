import java.util.ArrayList;
import java.util.LinkedList;

/**
 * MaxInWindows class<br/>
 *
 * 题目描述
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大-。例如，
 * 如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个
 * 滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 *
 * @author hdonghong
 * @since 2018/10/29
 */
public class MaxInWindows {

    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (num == null || num.length < size || size == 0) {
            return ret;
        }

        // 队列存下标
        LinkedList<Integer> q = new LinkedList<>();
        int j = 1;
        for (int i = 0, len = num.length; i < len; i++, j++) {
            if (!q.isEmpty() && num[i] > num[q.getLast()]) {
                int s = size;
                while (s > 1 && !q.isEmpty() && num[i] > num[q.getLast()]) {
                    q.removeLast();
                    s--;
                }
            }
            q.add(i);
            if (q.getLast() - q.getFirst() >= size) {
                q.removeFirst();
            }
            if (j % size == 0) {
                ret.add(num[q.peek()]);
                j--;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new MaxInWindows().maxInWindows(
                new int[]{2,3,4,2,6,2,5,1}, 3
        ));
    }
}
