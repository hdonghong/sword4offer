import java.util.Stack;

/**
 * KthNode class<br/>
 *
 * 二叉搜索树的第k个结点
 * 题目描述
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如,（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 *
 * @author hdonghong
 * @since 2018/10/29
 */
public class KthNode {

    TreeNode KthNode(TreeNode pRoot, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int i = 0;
        TreeNode node = pRoot;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (++i == k) {
                break;
            }
            node = node.right;
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);

        t5.left = t3;
        t5.right = t7;
        t3.left = t2;
        t3.right = t4;
        t7.left = t6;
        t7.right = t8;

        System.out.println(new KthNode().KthNode(t5, 1).val);
    }
}
