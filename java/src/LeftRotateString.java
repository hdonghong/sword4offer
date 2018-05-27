/**
 * LeftRotateString class<br/>
 *
 * 左旋转字符串
 * 题目描述
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你
 * 把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求
 * 输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞
 * 定它！
 *
 * @author hdonghong
 * @date 2018/05/27
 */
public class LeftRotateString {

    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() < 2) {
            return str;
        }

        n %= str.length();
        return n >= 0 ?
                str.substring(n) + str.substring(0, n) :
                str.substring(str.length() + n) + str.substring(0, str.length() + n);
    }

    public static void main(String[] args) {
        System.out.println(new LeftRotateString().LeftRotateString("abcXYZdef", -3));
    }
}
