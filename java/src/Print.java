import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Print class<br/>
 *
 * 题目描述
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * @author hdonghong
 * @date 2018/05/26
 */
public class Print {
    /*
        public class TreeNode {
            int val = 0;
            TreeNode left = null;
            TreeNode right = null;

            public TreeNode(int val) {
                this.val = val;

            }

        }
     */

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) {
            return null;
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(pRoot);
        while (!q.isEmpty()) {
            int lo = 0;
            int hi = q.size();
            ArrayList<Integer> t = new ArrayList<>();
            while (lo++ < hi) {
                TreeNode poll = q.poll();
                t.add(poll.val);
                if (poll.left != null) {
                    q.add(poll.left);
                }
                if (poll.right != null) {
                    q.add(poll.right);
                }
            }
            result.add(t);
        }

        return result;
    }
}
