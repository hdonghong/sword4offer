import java.util.Stack;

/**
 * TwoStacks2Queue class
 *
 * 题目描述
 * 用两个栈来实现一个队列
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @author hdonghong
 * @date 2018/03/21
 */
public class TwoStacks2Queue {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        /*
        while (stack1.size() > 1) {
            stack2.push(stack1.pop());
        }
        int result = stack1.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return result;
        */
        // 别人的答案
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("empty queue!");
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
