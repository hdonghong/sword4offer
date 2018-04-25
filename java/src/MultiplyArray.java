/**
 * MultiplyArray class<br/>
 *
 * 构建乘积数组
 *
 * 题目描述
 * 给定一个数组A[0,1, ... ,n-1],请构建一个数组B[0,1, ... ,n-1],其中B中的元素
 * B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]* ... *A[n-1]。不能使用除法。
 * @author hdonghong
 * @date 2018/04/25
 */
public class MultiplyArray {

    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) return new int[0];
        int sum = 1;
        for (int a : A) {
            sum *= a;
        }
        int[] B = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            B[i] = sum / A[i];
        }

        return B;
    }
}
