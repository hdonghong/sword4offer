/**
 * IsBalancedSolution class<br/>
 *
 * 题目描述
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * TODO
 * @author hdonghong
 * @date 2018/05/26
 */
public class IsBalancedSolution {

    public boolean IsBalanced_Solution(TreeNode root) {
        java.util.Stack<TreeNode> stack = new java.util.Stack<>();
        return inOrder(root, stack);
    }

    private boolean inOrder(TreeNode node, java.util.Stack<TreeNode> stack) {
        if (node == null) {
            return true;
        }
        if (!inOrder(node.left, stack)) {
            return false;
        }

        if (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            if (top.val > node.val) {
                return false;
            }
        }
        stack.push(node);

        return inOrder(node.right, stack);

    }

    public static void main(String[] args) {
        TreeNode[] ts = new TreeNode[7];
        for (int i = 0; i < ts.length; i++) {
            ts[i] = new TreeNode(i+1);
        }

        ts[3].left = ts[1];
        ts[3].right = ts[5];
        ts[1].left = ts[0];
        ts[1].right = ts[2];
        ts[5].left = ts[4];
        ts[5].right = ts[6];

        System.out.println(new IsBalancedSolution().IsBalanced_Solution(ts[3]));

        ts = new TreeNode[7];
        for (int i = 0; i < ts.length; i++) {
            ts[i] = new TreeNode(i+1);
        }
        ts[1].left = ts[0];
        ts[2].left = ts[1];
        ts[3].left = ts[2];
        ts[4].left = ts[3];
        ts[4].right = ts[5];
        ts[5].right = ts[6];
        System.out.println(new IsBalancedSolution().IsBalanced_Solution(ts[4]));
    }
}
