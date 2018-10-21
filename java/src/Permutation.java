import java.util.ArrayList;
import java.util.Comparator;

/**
 * Permutation class<br/>
 *
 * 字符串的排列
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串
 * abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 *
 * @author hdonghong
 * @since 2018/10/21
 */
public class Permutation {

    // 解决，分两部分，递归解决
    private ArrayList<String> ret = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        if (str != null && str.length() > 0) {
            permutation(str.toCharArray(), 0);
        }
        ret.sort(Comparator.naturalOrder());
        return ret;
    }

    private void permutation(char[] str, int pBegin) {
        int len = str.length;
        if (pBegin == len - 1) {
            ret.add(new String(str));
            return;
        }

        for (int i = pBegin; i < len; i++) {
            if (pBegin != i && str[pBegin] == str[i]) {
                continue;
            }

            char t = str[i];
            str[i] = str[pBegin];
            str[pBegin] = t;

            permutation(str, pBegin + 1);

            t = str[i];
            str[i] = str[pBegin];
            str[pBegin] = t;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permutation().Permutation("abc"));
        System.out.println(new Permutation().Permutation("abcd"));
        System.out.println(new Permutation().Permutation("aac"));
    }
}
