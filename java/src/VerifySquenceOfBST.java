/**
 * VerifySquenceOfBST class<br/>
 *
 * 二叉搜索树的后序遍历序列
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 *
 * 题解：
 * 尾部是根，确定根后遍历序列，找到第一个大于根的数，
 * 该数的左边是左子树，遍历右子树，保证右子树所有值大于根
 *
 * @author hdonghong
 * @since 2018/11/03
 */
public class VerifySquenceOfBST {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length < 1) {
            return false;
        }

        return verifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    private boolean verifySquenceOfBST(int[] sequence, int lo, int hi) {
        if (hi - lo < 2) {
            return true;
        }
        if (hi - lo == 2) {
            // 312
            return !(sequence[lo] > sequence[hi] && sequence[hi - 1] < sequence[hi]);
        }
        int rootVal = sequence[hi];
        int mid = lo;
        while (mid < hi && sequence[mid] < rootVal) {
            mid++;
        }
        for (int i = mid; i < hi; i++) {
            if (sequence[i] < rootVal) {
                return false;
            }
        }
        return verifySquenceOfBST(sequence, lo, mid - 1)
                &&
               verifySquenceOfBST(sequence, mid, hi - 1);
    }

    public static void main(String[] args) {
        System.out.println(new VerifySquenceOfBST().VerifySquenceOfBST(
                new int[]{3, 6, 5, 4, 9, 8, 7}
        ));
        System.out.println(new VerifySquenceOfBST().VerifySquenceOfBST(
                new int[]{3, 6}
        ));
        System.out.println(new VerifySquenceOfBST().VerifySquenceOfBST(
                new int[]{4, 8, 6, 12, 16, 14, 10}
        ));
        System.out.println(new VerifySquenceOfBST().VerifySquenceOfBST(
                    new int[]{4, 6, 12, 8, 16, 14, 10}
        ));
        // 不符合的只有312这种情况
        System.out.println(new VerifySquenceOfBST().VerifySquenceOfBST(
                new int[]{1, 3, 2}
        ));
        System.out.println(new VerifySquenceOfBST().VerifySquenceOfBST(
                new int[]{1, 2, 3}
        ));
        System.out.println(new VerifySquenceOfBST().VerifySquenceOfBST(
                new int[]{2, 1, 3}
        ));
        System.out.println(new VerifySquenceOfBST().VerifySquenceOfBST(
                new int[]{2, 3, 1}
        ));
        System.out.println(new VerifySquenceOfBST().VerifySquenceOfBST(
                new int[]{3, 2, 1}
        ));
        System.out.println(new VerifySquenceOfBST().VerifySquenceOfBST(
                new int[]{3, 1, 2}
        ));
    }
}
