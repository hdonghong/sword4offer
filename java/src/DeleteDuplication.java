/**
 * DeleteDuplication class<br/>
 *
 * 删除链表中重复的结点
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，
 * 返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @author hdonghong
 * @date 2018/04/26
 */
public class DeleteDuplication {

    /*
     public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    */

    public ListNode deleteDuplication(ListNode pHead) {
        // 处理开头重复的情况
        ListNode newHead = new ListNode(-1);
        newHead.next = pHead;

        ListNode p = newHead;
        while (p != null) {
            p.next = removeRepe(p.next);
            p = p.next;
        }

        return newHead.next;
    }

    private ListNode removeRepe(ListNode p) {
        if (p != null) {
            if (p.next != null && p.next.val == p.val) {
                ListNode temp = p;
                while (p.next != null && p.next.val == p.val) {
                    p = p.next;
                }
                temp.next = p.next;
                p = p.next;
            }
        }
        return p;
    }

    public static void main(String[] args) {
        ListNode pHead = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3= new ListNode(3);
        ListNode p4 = new ListNode(3);
        ListNode p5 = new ListNode(4);
        ListNode p6 = new ListNode(4);
        ListNode p7 = new ListNode(5);
        pHead.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = p6;
        p6.next = p7;

        ListNode p = new DeleteDuplication().deleteDuplication(pHead);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }
}
