/**
 * Power class<br/>
 *
 * 题目描述
 * 数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @author hdonghong
 * @date 2018/03/24
 */
public class Power {

    public double Power(double base, int exponent) {
        if (base == 0d) return 0d;
        else if (base == 1d || exponent == 0) return 1d;
        else if (base == -1d) return exponent%2==0 ? 1d : -1d;
        else {
            double result = 1;
            double ex = Math.abs(exponent);
            while (ex-- > 0) result *= base;
            return exponent > 0 ?
                    result : 1/result;
        }

        // 稍微看了下讨论区的解法，有用了递归和&1，看不懂，（逃
    }

    public static void main(String[] args) {
        System.out.println(new Power().Power(2, -3));
    }

}
