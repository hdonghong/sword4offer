/**
 * FirstNotRepeatingChar class<br/>
 *
 * 第一个只出现一次的字符
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.
 *
 * @author hdonghong
 * @since 2018/10/30
 */
public class FirstNotRepeatingChar {

    public int FirstNotRepeatingChar(String str) {
        int[] charCount = new int[255];
        int[] charIndex = new int[255];
        int maxIndex = 10000;

        for (int i = 0, len = str.length(); i < len; i++) {
            char c = str.charAt(i);
            if (++charCount[c] > 1) {
                charIndex[c] = maxIndex;
            } else {
                charIndex[c] = i;
            }
        }

        int minIndex = maxIndex;
        for (int c = 'A'; c <= 'z'; c++) {
            if (c > 'Z' && c < 'a') {
                continue;
            }
            if (charIndex[c] < minIndex && charCount[c] == 1) {
                minIndex = charIndex[c];
            }
        }

        return minIndex == maxIndex ?
                -1 : minIndex;
    }

    public static void main(String[] args) {
        System.out.println(new FirstNotRepeatingChar().FirstNotRepeatingChar("google"));
    }
}
