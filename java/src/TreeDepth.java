import java.util.ArrayDeque;
import java.util.Queue;

/**
 * TreeDepth class<br/>
 *
 * 题目描述
 * 二叉树的深度
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * @author hdonghong
 * @date 2018/04/02
 */
public class TreeDepth {

    public int TreeDepth(TreeNode root) {
        /*迭代求法*/
        /*
        if (root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        // 开始前，假设在第0层，则当前层结点数为0，下一层结点数为1，深度为0
        int currLayerCount = 0;
        int nextLayCount = 1;
        int depth = 0;

        while (!queue.isEmpty()) {
            currLayerCount++;

            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            if (currLayerCount == nextLayCount) {
                nextLayCount = queue.size();
                currLayerCount = 0;
                depth++;
            }
        }
        return depth;
        */

        /*递归求法*/
        if (root == null) {
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
