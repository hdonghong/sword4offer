/**
 * GetNext class<br/>
 *
 * @author hdonghong
 * @date 2018/05/26
 */
public class GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        TreeLinkNode root = pNode;
        while (root.next != null) {
            root = root.next;
        }
        return inOrder(root, pNode);
    }

    private TreeLinkNode inOrder(TreeLinkNode root, TreeLinkNode pNode) {
        java.util.Stack<TreeLinkNode> stack = new java.util.Stack<>();
        boolean flag = false;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();

                if (flag) {
                    return root;
                }
                if (root.equals(pNode)) {
                    if  (root.right != null) {
                        flag = true;
                    } else if (!stack.isEmpty()) {
                        return stack.pop();
                    } else {
                        return null;
                    }
                }

                root = root.right;
            }
        }

        return null;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}