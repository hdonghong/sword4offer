import java.util.ArrayList;

/**
 * PrintListFromTailToHead class
 *
 * 题目描述
 * 从尾到头打印链表
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * @author hdonghong
 * @date 2018/03/20
 */
public class PrintListFromTailToHead {
    ArrayList<Integer> result = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        /*
        ArrayList<Integer> a1 = new ArrayList<>();
        while (listNode != null) {
            a1.add(listNode.val);
            listNode = listNode.next;
        }

        for (int i = a1.size()-1; i >= 0; i--) {
            result.add(a1.get(i));
        }
        */
        // 递归实现：
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            result.add(listNode.val);
        }
        return result;
    }

    class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
           this.val = val;
       }
    }
}
