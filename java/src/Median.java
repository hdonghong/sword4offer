import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Median class<br/>
 *
 * 数据流中的中位数
 * 题目描述
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读
 * 取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 *
 * @author hdonghong
 * @since 2018/10/29
 */
public class Median {

    PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> min = new PriorityQueue<>();

    public void Insert(Integer num) {
        if (num == null) {
            return;
        }

        if (((max.size() + min.size()) & 1) == 0) {
        // 表示是偶数：% 2 == 0
        // 要保证min的最小元素大于max的最大元素
            min.add(num);
            max.add(min.poll());
        } else {
            max.add(num);
            min.add(max.poll());
        }
    }

    public Double GetMedian() {
        int size = max.size() + min.size();
        if (size == 0) {
            return null;
        }

        Double ret;
        if ((size & 1) == 1) {
        // 表示：size % 2 == 1
            ret = max.peek().doubleValue();
        } else {
            ret = (max.peek() + min.peek()) / 2.0;
        }
        return ret;
    }

    public static void main(String[] args) {
        Median median = new Median();
        for (int i = 1; i <= 10; i++) {
            median.Insert(i);
            System.out.println("当前最大数是：" + i + "中位数是：" + median.GetMedian());
        }
    }
}
