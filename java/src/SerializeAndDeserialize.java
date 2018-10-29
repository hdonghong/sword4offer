import java.util.LinkedList;
import java.util.Queue;

/**
 * SerializeAndDeserialize class<br/>
 *
 * 序列化二叉树
 *
 * 题目描述
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * @author hdonghong
 * @since 2018/10/28
 */
public class SerializeAndDeserialize {

    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode poll = q.poll();
            if (poll == null) {
                sb.append("null");
                if (!q.isEmpty()) {
                    sb.append(" ");
                }
            } else {
                sb.append(poll.val + " ");
                q.add(poll.left);
                q.add(poll.right);
            }
        }

        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        String[] vals = str.split(" ");
        if ("null".equals(vals[0])) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int length = vals.length;
        int i = 1;
        while (i < length && !q.isEmpty()) {
            TreeNode poll = q.poll();
            if (!"null".equals(vals[i])) {
                poll.left = new TreeNode(Integer.parseInt(vals[i]));
                q.add(poll.left);
            }
            if (!"null".equals(vals[i + 1])) {
                poll.right = new TreeNode(Integer.parseInt(vals[i + 1]));
                q.add(poll.right);
            }
            i += 2;
        }

        return root;
    }

    public static void main(String[] args) {
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
//        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t4.left = t8;
        t4.right = t9;
        t5.left = t4;

        SerializeAndDeserialize solution = new SerializeAndDeserialize();
        String str = solution.Serialize(t1);
        System.out.println(str);
        System.out.println(
                solution.Serialize(solution.Deserialize(str))
        );

    }
}
