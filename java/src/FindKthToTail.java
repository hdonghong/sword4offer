import java.util.ArrayList;
import java.util.List;

/**
 * FindKthToTail class<br/>
 *
 * 题目描述
 * 链表中倒数第k个结点
 * 输入一个链表，输出该链表中倒数第k个结点。
 * @author hdonghong
 * @date 2018/03/24
 */
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head,int k) {
        /*
        if (head == null || k <= 0) return null;
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        if (k > list.size()) return null;
        return list.get(list.size()-k);
        */
        // 大佬的思路：两个指针pre和last指向head，
        // pre先走（k-1），然后pre和last同时走
        if (head == null || k <= 0) return null;
        ListNode pre = head;
        ListNode last = head;
        for (int i = 1; i < k; i++) {
            if (pre.next == null) return null;
            pre = pre.next;
        }
        while (pre.next != null) {
            pre = pre.next;
            last = last.next;
        }
        return last;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        head.next = h2;
        h2.next = h3;

        System.out.println(new FindKthToTail().FindKthToTail(head, 3).val);
    }


}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}