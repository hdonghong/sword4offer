import java.util.ArrayList;

/**
 * FindContinuousSequence class<br/>
 *
 * @author hdonghong
 * @since 2018/10/19
 */
public class FindContinuousSequence {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        if (sum <= 0) return null;

        ArrayList<ArrayList<Integer>> rets = new ArrayList<>();
        int small = 0;
        int big = 2;
        while (small < big) {
            int tempSum = 0;
            small++;
            while (tempSum != sum && small < big) {
                tempSum = 0;
                ArrayList<Integer> ret = new ArrayList<>();
                for (int i = small; i <= big; i++) {
                    tempSum += i;
                    ret.add(i);
                }
                if (tempSum < sum) {
                    big++;
                } else if (tempSum > sum) {
                    small++;
                } else {
                    rets.add(ret);
                }
            }
        }

        return rets;
    }

    public static void main(String[] args) {
        System.out.println(new FindContinuousSequence().FindContinuousSequence(100));
        System.out.println(new FindContinuousSequence().FindContinuousSequence(1));
    }
}
