import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ZhiPrint class<br/>
 * 按之字形顺序打印二叉树
 *
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * @author hdonghong
 * @since 2018/07/27
 */
public class ZhiPrint {

    /*
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }
    解题思路：利用两个栈，“倒来倒去”，栈1取，打印所有，子叶存栈2；栈2取，打印所有，子叶存栈1
    */

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {return result;}

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        ArrayList<Integer> temp;

        boolean isLeft2Right = true;
        stack.push(pRoot);

        while (!stack.isEmpty() || !stack2.isEmpty()) {
            temp = stack.size() > 0 ?
                    reallyPrint(stack, stack2, isLeft2Right) : reallyPrint(stack2, stack, isLeft2Right);
            isLeft2Right = !isLeft2Right;
            result.add(temp);
        }
        return result;
    }

    private ArrayList<Integer> reallyPrint(Stack<TreeNode> stack, Stack<TreeNode> stack2, boolean isLeft2Right) {
        int size = stack.size();
        ArrayList<Integer> temp = new ArrayList<>();
        while (size-- > 0) {
            TreeNode node = stack.pop();
            temp.add(node.val);
            if (isLeft2Right) {
                if (node.left != null) { stack2.push(node.left); }
                if (node.right != null) { stack2.push(node.right); }
            } else {
                if (node.right != null) { stack2.push(node.right); }
                if (node.left != null) { stack2.push(node.left); }
            }
        }
        return temp;
    }





    public static void main(String[] args) {
        TreeNode treeNode = init();
        List<ArrayList<Integer>> print = new ZhiPrint().Print(treeNode);
        print.forEach(System.out::println);
    }

    public static TreeNode init() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t4.left = t8;
        t4.right = t9;
        return t1;
    }
}
