/**
 * Match class<br/>
 *
 * 正则表达式匹配（！！！重点难题！！！）
 *
 * 题目描述
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字
 * 符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和
 * "ab*a"均不匹配
 *
 * @author hdonghong
 * @since 2018/10/25
 */
public class Match {

    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }

        return match(str, pattern, 0, 0);
    }

    private boolean match(char[] str, char[] pattern, int indexStr, int indexPtn) {
        if (indexStr >= str.length && indexPtn >= pattern.length) {
            return true;
        }

        if (indexStr < str.length && indexPtn >= pattern.length) {
            return false;
        }

        if (indexPtn + 1 < pattern.length && pattern[indexPtn + 1] == '*') {
            if ((indexStr < str.length && pattern[indexPtn] == str[indexStr]) ||
                    (pattern[indexPtn] == '.' && indexStr < str.length)) {
                return match(str, pattern, indexStr + 1, indexPtn + 2)
                    || match(str, pattern, indexStr + 1, indexPtn)
                    || match(str, pattern, indexStr, indexPtn + 2);
            } else {
                return match(str, pattern, indexStr, indexPtn + 2);
            }
        }

        if ((indexStr < str.length && pattern[indexPtn] == str[indexStr]) ||
                (pattern[indexPtn] == '.' && indexStr < str.length)) {
            return match(str, pattern, indexStr + 1, indexPtn + 1);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Match().match(
                "aaa".toCharArray(),
                "a.a".toCharArray()
        ));

        System.out.println(new Match().match(
                "aaa".toCharArray(),
                "ab*ac*a".toCharArray()
        ));
        System.out.println(new Match().match(
                "aa.a".toCharArray(),
                "ab*a".toCharArray()
        ));
        System.out.println(new Match().match(
                "aaa".toCharArray(),
                "a*a".toCharArray()
        ));
        System.out.println(new Match().match(
                "".toCharArray(),
                ".*".toCharArray()
        ));
    }
}
