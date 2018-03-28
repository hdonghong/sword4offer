import java.util.Stack;

/**
 * MinStack class<br/>
 *
 * 题目描述
 * 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 要求复杂度O(1)
 * @author hdonghong
 * @date 2018/03/27
 */
public class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void pop() {
        stack.pop();
        minStack.pop();
    }
    public void push(int e) {
        stack.push(e);
        if (minStack.isEmpty() || e < minStack.peek()) {
            minStack.push(e);
        } else {
            minStack.push(minStack.peek());
        }
    }
    public int top() {
        return stack.peek();
    }
    public int min() {
        return minStack.peek();
    }
}
