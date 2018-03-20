/**
 * ReplaceSpace class
 *
 * 题目描述
 * 替换空格
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @author hdonghong
 * @date 2018/03/20
 */
public class ReplaceSpace {

    public String replaceSpace(StringBuffer str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                str.replace(i, i+1, "%20");
        }
        return str.toString();
    }
}
