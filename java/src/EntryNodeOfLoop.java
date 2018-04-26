/**
 * EntryNodeOfLoop class<br/>
 *
 * 链表中环的入口结点
 * 题目描述
 * 一个链表中包含环，请找出该链表的环的入口结点。
 *
 * @author hdonghong
 * @date 2018/04/26
 */
public class EntryNodeOfLoop {

    /*
     public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    */

    // 断链法，链表有环，如果遍历的话会死循环；
    // 所以每次访问一个结点，先保存它的下一个结点，然后断开其与下一个结点的联系，
    // 这样回到环的入口结点处时它的next就为null
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) return null;
        ListNode p = pHead;
        while (p.next != null) {
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        return p;
    }
}
