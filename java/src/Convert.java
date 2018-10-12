import java.util.Stack;

/**
 * Convert class<br/>
 * 二叉搜索树与双向链表
 * 题目描述
 * 一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @author hdonghong
 * @since 2018/05/26
 */
public class Convert {

    /**
         public class TreeNode {
             int val = 0;
             TreeNode left = null;
             TreeNode right = null;

             public TreeNode(int val) {
                this.val = val;
             }
         }
     */

    public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode[] lastNodeInList = new TreeNode[1];
        convertNode(pRootOfTree, lastNodeInList);
        // 返回头节点
        TreeNode headInList = lastNodeInList[0];
        while (headInList != null && headInList.left != null) {
            headInList = headInList.left;
        }

        return headInList;

    }

    private void convertNode(TreeNode current, TreeNode[] lastNodeInList) {
        if (current == null) return;

        // 先递归左节点
        if (current.left != null) convertNode(current.left, lastNodeInList);

        // 互指向
        current.left = lastNodeInList[0];
        if (lastNodeInList[0] != null) lastNodeInList[0].right = current;

        // 更新指向列表中最后节点
        lastNodeInList[0] = current;

        // 最后递归右节点
        if (current.right != null) convertNode(current.right, lastNodeInList);
    }
}