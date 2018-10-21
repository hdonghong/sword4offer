/**
 * IsNumeric class<br/>
 *
 * 表示数值的字符串
 * 题目描述
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1.2E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * @author hdonghong
 * @since 2018/10/21
 */
public class IsNumeric {

    public boolean isNumeric(char[] str) {

        int len;
        if (str == null || (len = str.length) < 1) return false;

        // 判断第一位是否符号位
        boolean firstCisSign = false;
        if (str[0] == '+' || str[0] == '-') firstCisSign = true;
        else if (str[0] < '0' || str[0] > '9') return false;

        if (firstCisSign && len < 2) return false;
        // 第一位是符号位但第二位不是数字且不是小数点，不符合要求
        if (firstCisSign && str[1] != '.' && (str[1] < '0' || str[1] > '9')) return false;

        boolean existE = false;
        boolean existDot = false;
        int i;
        for (i = 1; i < len; i++) {
            char c = str[i];
            if (c < '0' || c > '9') {
                if ((c == 'e' || c == 'E') && i < len - 1) {
                    existE = true;
                } else if (c == '.' && i < len - 1) {
                    if (str[i+1] == 'e' || str[i+1] == 'E') return false;
                    existDot = true;
                } else {
                    return false;
                }
                i++;
                break;
            }
        }

        if (existDot) {
            while (i < len) {
                char c = str[i];
                if (c < '0' || c > '9') {
                    if ((c == 'e' || c == 'E') && i < len - 1) {
                        existE = true;
                        i++;
                        break;
                    } else {
                        return false;
                    }
                }
                i++;
            }
        }

        if (existE) {
            boolean firstCAftEisSign = false;
            if (str[i] == '+' || str[i] == '-') firstCAftEisSign = true;
            else if (str[i] < '0' || str[i] > '9') return false;
            i++;
            // 第一位是符号位但第二位不是数字，不符合要求
            if (firstCAftEisSign && (str[i] < '0' || str[i] > '9')) return false;

            while (i < len) {
                char c = str[i];
                if (c < '0' || c > '9') return false;
                i++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsNumeric().isNumeric(new char[]{'1', '2', '3'}));
        System.out.println(new IsNumeric().isNumeric(new char[]{'+', '1', '0', '0'}));
        System.out.println(new IsNumeric().isNumeric(new char[]{'-', '1', '2', '3'}));
        System.out.println(new IsNumeric().isNumeric(new char[]{'3', '.', '1', '4', '1', '6'}));
        System.out.println(new IsNumeric().isNumeric(new char[]{'-', '2', 'E', '-', '1', '6'}));
        System.out.println(new IsNumeric().isNumeric(new char[]{'1', '2', 'E'}));
        System.out.println(new IsNumeric().isNumeric(new char[]{'1', 'a', '3', '.', '1', '4'}));
        System.out.println(new IsNumeric().isNumeric(new char[]{'1', '.', '2', '.', '3'}));
        System.out.println(new IsNumeric().isNumeric(new char[]{'+', '-', '6'}));
        System.out.println(new IsNumeric().isNumeric(new char[]{'1', '2', 'e', '+', '4', '.', '3'}));
        System.out.println(new IsNumeric().isNumeric(new char[]{'1', '2', '.', '4', '5', 'e', '+', '4', '3'}));
        System.out.println(new IsNumeric().isNumeric(new char[]{'-', '.', '4', '5', 'e', '+', '4', '3'}));
        /*
        true
        true
        true
        true
        true
        false
        false
        false
        false
        false
        true
        true
         */
    }
}
