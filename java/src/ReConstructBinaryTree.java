/**
 * ReConstructBinaryTree class<br/>
 * 重建二叉树
 *
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @author hdonghong
 * @since 2018/10/09
 */
public class ReConstructBinaryTree {

    /**
     * Definition for binary tree
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || pre.length == 0) return null;
        if (in == null || in.length == 0) return null;
        if (pre.length != in.length) return null;

        return reConstructBinaryTree(pre, in, 0, in.length - 1, 0);
    }

    private TreeNode reConstructBinaryTree(int [] pre,int [] in, int inLeft, int inRight, int preLeft) {
        if (inLeft > inRight || preLeft >= in.length) return null;
        int rootVal = pre[preLeft];
        // 获取根节点在中跟序列中的位置
        int rootInIdx = inLeft;
        for (int i = inLeft; i <= inRight; i++) {
            if (in[i] == rootVal) {
                rootInIdx = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = reConstructBinaryTree(pre, in, inLeft, rootInIdx - 1, preLeft + 1);
        root.right = reConstructBinaryTree(pre, in, rootInIdx + 1, inRight, preLeft + 1 + rootInIdx - inLeft);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] in = new int[]{4,7,2,1,5,3,8,6};

        TreeNode treeNode = new ReConstructBinaryTree().reConstructBinaryTree(pre, in);
        System.out.println(
                new Print().Print(treeNode)
        );
    }
}
