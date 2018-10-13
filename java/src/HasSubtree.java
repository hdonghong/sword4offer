/**
 * HasSubtree class<br/>
 *
 * 树的子结构
 * 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @author hdonghong
 * @since 2018/10/13
 */
public class HasSubtree {

    // 先找出root1中与root2根节点相同的节点，再比较root2的子节点
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) return false;

        boolean ret = false;
        if (root1.val == root2.val) ret = tree1HasTree2(root1, root2);
        if (!ret) ret = tree1HasTree2(root1.left, root2);
        if (!ret) ret = tree1HasTree2(root1.right, root2);

        return ret;
    }

    private boolean tree1HasTree2(TreeNode tree1, TreeNode tree2) {
        if (tree2 == null) return true;
        if (tree1 == null) return false;
        if (tree1.val != tree2.val) return false;
        return tree1HasTree2(tree1.left, tree2.left) && tree1HasTree2(tree1.right, tree2.right);
    }
}
