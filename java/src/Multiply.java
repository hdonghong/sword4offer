import java.util.Arrays;

/**
 * Multiply class<br/>
 *
 * 构建乘积数组 <br/>
 *
 * 题目描述<br/>
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。<br/>
 *
 * @author hdonghong
 * @since 2018/04/14
 */
public class Multiply {

    public int[] multiply(int[] A) {
        if (A == null || A.length <= 1) return A;

        int aLength = A.length;
        // B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
        int[] B = new int[aLength];
        // c[i] = A[0]*A[1]*...*A[i-1]
        int[] c = new int[aLength];
        // d[i] = A[i+1]*...*A[n-1]
        int[] d = new int[aLength];

        c[0] = 1;
        for (int i = 1; i < aLength; i++) {
            c[i] = c[i-1] * A[i-1];
        }

        d[aLength-1] = 1;
        for (int i = aLength - 2; i >= 0; i--) {
            d[i] = d[i+1] * A[i+1];
            B[i] = c[i] * d[i];
        }
        B[0] = c[0] * d[0];
        B[aLength-1] = c[aLength-1] * d[aLength-1];

        return B;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = new Multiply().multiply(a);
        System.out.println(Arrays.toString(b));
    }
}
