import java.util.ArrayList;

/**
 * FindPath class<br/>
 *
 * 二叉树中和为某一值的路径
 * 题目描述
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返
 * 回值的list中，数组长度大的数组靠前)
 *
 * @author hdonghong
 * @since 2018/10/31
 */
public class FindPath {

    ArrayList<ArrayList<Integer>> rets = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return rets;
        }

        findPath(root, target, new ArrayList<>(), 0);
        return rets;
    }

    void findPath(TreeNode pRoot, int target, ArrayList<Integer> path, int currentSum) {
        currentSum += pRoot.val;
        path.add(pRoot.val);

        // 如果是叶子结点
        boolean isLeaf = (pRoot.left == null && pRoot.right == null);
        // 并且刚好满足期望值
        if (currentSum == target && isLeaf) {
            rets.add(new ArrayList<>(path));
        }

        // 如果不是叶子节点
        if (pRoot.left != null) {
            findPath(pRoot.left, target, path, currentSum);
        }
        if (pRoot.right != null) {
            findPath(pRoot.right, target, path, currentSum);
        }

        // 移除父节点
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t7 = new TreeNode(7);
        TreeNode t10 = new TreeNode(10);
        TreeNode t12 = new TreeNode(12);

        t5.left = t4;
        t5.right = t7;
        t10.left = t5;
        t10.right = t12;

        System.out.println(new FindPath().FindPath(t10, 22));
    }
}
