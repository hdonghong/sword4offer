/**
 * Clone class<br/>
 *
 * 复杂链表的复制
 * 
 * 题目描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * @author hdonghong
 * @since 2018/10/27
 */
public class Clone {

    /**
     * 方式1：使用哈希表
     * 方式2：新克隆的链表交叉入原链表中
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;

        // 新克隆的链表交叉入原链表中
        RandomListNode p = pHead;
        while (p != null) {
            RandomListNode tempNode = new RandomListNode(p.label);
            tempNode.next = p.next;
            p.next = tempNode;
            p = tempNode.next;
        }

        // 处理random节点
        p = pHead;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        // 分开
        p = pHead;
        RandomListNode retHead = p.next;
        RandomListNode retNode = retHead;
        p.next = retNode.next;
        p = p.next;
        while (p != null) {
            retNode.next = p.next;
            retNode = retNode.next;
            p.next = retNode.next;
            p = p.next;
        }

        return retHead;
    }
}
