/**
 * FindFirstCommonNode class<br/>
 *
 * 题目描述
 * 两个链表的第一个公共结点
 * 输入两个链表，找出它们的第一个公共结点。
 * @author hdonghong
 * @date 2018/04/06
 */
public class FindFirstCommonNode {

    /*
    需要记链表的长度
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;

        // 先确定两个链表的长度
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        int len1 = 0;
        int len2 = 0;

        while (p1 != null) {
            len1++;
            p1 = p1.next;
        }
        while (p2 != null) {
            len2++;
            p2 = p2.next;
        }
        return len1 > len2 ?
                excute(len1, len2, pHead1, pHead2) : excute(len2, len1, pHead2, pHead1);
    }

    /**
     * p是较长的链表
     * @param pLen
     * @param qLen
     * @param p
     * @param q
     * @return
     */
    /*
    private ListNode excute(int pLen, int qLen, ListNode p, ListNode q) {
        int difference = pLen - qLen;
        while (difference-- > 0) {
            p = p.next;
        }
        for (int i = 0; 0 < qLen; i++) {
            if (p == q) return p;
            p = p.next;
            q = q.next;
        }
        return null;
    }
    */

    /* 别人的做法，不需要记长度 */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = (p1 == null ? pHead2 : p1.next);
            p2 = (p2 == null ? pHead1 : p2.next);
        }
        return p1;
    }
}
