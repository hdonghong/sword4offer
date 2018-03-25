/**
 * ReverseList class<br/>
 *
 * 题目描述
 * 反转链表
 * 输入一个链表，反转链表后，输出链表的所有元素。
 * @author hdonghong
 * @date 2018/03/25
 */
public class ReverseList {


    public ListNode ReverseList(ListNode head) {
        // 参考别人的
        // 迭代
        /*
        ListNode result = null;
        ListNode temp = null;
        while (head != null) {
            temp = head.next;
            head.next = result;
            result = head;
            head = temp;
        }
        return result;
        */
        // 递归
        if (head == null || head.next == null) return head;// 空链表或一个元素的直接返回
        ListNode result = ReverseList(head.next);// 走到链表尾部

        head.next.next = head;
        head.next = null;

        return result;
    }

}
