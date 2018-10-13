/**
 * IsSymmetrical class<br/>
 *
 * 对称的二叉树
 * 题目描述
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * @author hdonghong
 * @since 2018/10/12
 */
public class IsSymmetrical {

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

    boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot, pRoot);
    }

    boolean isSymmetrical(TreeNode node, TreeNode node2) {
        if (node == null && node2 == null) return true;

        if (node == null || node2 == null) return false;

        if (node.val != node2.val) return false;

        return isSymmetrical(node.left, node2.right) && isSymmetrical(node.right, node2.left);
    }
}
