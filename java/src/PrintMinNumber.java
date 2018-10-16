import java.util.ArrayList;
import java.util.List;

/**
 * PrintMinNumber class<br/>
 *
 * 把数组排成最小的数
 * 题目描述
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * @author hdonghong
 * @since 2018/10/16
 */
public class PrintMinNumber {

    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length <= 0)
            return "";

        List<String> numberStrs = new ArrayList<>(numbers.length);
        for (int number : numbers)
            numberStrs.add(number + "");

        return numberStrs.stream()
                         .sorted((s1, s2) -> (s1 + s2).compareTo(s2 + s1))
                         .reduce("", (ret, str) -> ret + str);
    }

    public static void main(String[] args) {
        System.out.println("3".compareTo("321"));
        System.out.println("3".compareTo("32"));
        System.out.println("3".compareTo("5"));
        System.out.println("3".compareTo("1"));

        System.out.println(new PrintMinNumber().PrintMinNumber(new int[] {3, 32, 321}));
        System.out.println(new PrintMinNumber().PrintMinNumber(new int[] {3,5,1,4,2}));
        System.out.println(new PrintMinNumber().PrintMinNumber(new int[] {3, 321}));
        System.out.println(new PrintMinNumber().PrintMinNumber(new int[] {3,5}));
    }

}
