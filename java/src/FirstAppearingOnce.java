import java.util.LinkedList;

/**
 * FirstAppearingOnce class<br/>
 *
 * 字符流中第一个不重复的字符
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 * @author hdonghong
 * @since 2018/10/15
 */
public class FirstAppearingOnce {

    private StringBuilder stringStream = new StringBuilder();

    //Insert one char from stringstream
    public void Insert(char ch) {
        stringStream.append(ch);
    }

    //return the first appearence once char in current stringstream
    /* O(n2)
    public char FirstAppearingOnce() {
        LinkedList<Character> chs = new LinkedList<>();
        for (int i = 0, len = stringStream.length(); i < len; i++) {
            Character c = stringStream.charAt(i);
            if (chs.contains(c)) {
                chs.remove(c);
            } else {
                chs.add(c);
            }
        }
        return chs.size() > 0 ? chs.getFirst() : '#';
    }
    */

    // O(n)
    public char FirstAppearingOnce() {
        // 都是字符，也就256个
        int[] charArr = new int[256];
        for (int i = 0, len = stringStream.length(); i < len; i++) {
            charArr[stringStream.charAt(i)] += 1;
        }
        for (int i = 0, len = stringStream.length(); i < len; i++) {
            char ret = stringStream.charAt(i);
            if (charArr[ret] == 1) {
                return ret;
            }
        }
        return '#';
    }

    public static void main(String[] args) {
        FirstAppearingOnce firstAppearingOnce = new FirstAppearingOnce();
        firstAppearingOnce.Insert('g');
        firstAppearingOnce.Insert('o');
        firstAppearingOnce.Insert('o');
        firstAppearingOnce.Insert('g');
        firstAppearingOnce.Insert('l');
        firstAppearingOnce.Insert('e');
        System.out.println(firstAppearingOnce.FirstAppearingOnce());
    }
}
