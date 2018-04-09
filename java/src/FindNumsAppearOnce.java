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

    // 异或解法
}
