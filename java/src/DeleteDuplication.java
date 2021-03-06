/**
 * DeleteDuplication class<br/>
 *
 * 删除链表中重复的结点【！！！
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

        if (pHead == null || pHead.next == null) { return pHead; }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = pHead;
        ListNode cur = pHead;
        ListNode last = dummyHead;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                int val = cur.val;
                while (cur != null && cur.val == val) { cur = cur.next; }
                last.next = cur;
            } else {
                last = cur;
                cur = cur.next;
            }
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode pHead = new ListNode(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 6, 6});

        ListNode p = new DeleteDuplication().deleteDuplication(pHead);

        System.out.println(p);
    }
}
