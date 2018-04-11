/**
 * FindNumsAppearOnce class<br/>
 *
 * 题目描述
 * 数组中只出现一次的数字
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * num1,num2分别为长度为1的数组。传出参数
 * 将num1[0],num2[0]设置为返回结果
 *
 * @author hdonghong
 * @date 2018/04/09
 */
public class FindNumsAppearOnce {

    /*
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
        for (int e : array) {
            if (map.get(e) == null) {
                map.put(e, 1);
            } else {
                map.put(e, 2);
            }
        }
        boolean flag = false;
        for (int e : array) {
            if (map.get(e) == 1) {
                if (!flag) {
                    num1[0] = e;
                    flag = true;
                } else {
                    num2[0] = e;
                    break;
                }
            }
        }
    }
    */

    /**
     * 异或解法
     * 1. 0与任何数异或结果为该数
     * 2. 异或遍历题目数组所有元素的结果为两个不同数字的异或结果
     * 3. 因为是两个不同数字，其异或结果的二进制数中必有一个1，找到最低位1出现的index位置，可区分出两个不同数组
     * 4. 不同数组：一个是二进制数N位置为1的数组A，一个是二进制数N位置为0的数组B
     * 5. 继续以0异或遍历数组，区分数组A、B
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length < 2) return;

        int xorResult = 0;
        for (int e : array) xorResult ^= e;

        if (xorResult == 0) return;

        // 注意index=0，不是1
        int index = 0;
        while ((xorResult & 1) != 1) {
            xorResult >>= 1;
            index++;
        }

        for (int i = 0; i < array.length; i++) {
            if (bitOne(array[i], index)) num1[0] ^= array[i];
            else num2[0] ^= array[i];
        }
    }

    /** index位置为1返回true */
    private boolean bitOne(int num, int index) {
        return ((num >> index) & 1) == 1;
    }
}
