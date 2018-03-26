/**
 * Merge class<br/>
 *
 * 题目描述
 * 合并两个排序的链表
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @author hdonghong
 * @date 2018/03/25
 */
public class Merge {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else {
            ListNode resultHead = null;
            if (list1.val < list2.val) {
                resultHead = list1;
                resultHead.next = Merge(list1.next, list2);
            } else {
                resultHead = list2;
                resultHead.next = Merge(list1, list2.next);
            }
            return resultHead;
        }
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode h2 = new ListNode(4);
        ListNode h3 = new ListNode(6);
        head.next = h2;
        h2.next = h3;

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);

        System.out.println(new Merge().Merge(head, l2));
    }
}
