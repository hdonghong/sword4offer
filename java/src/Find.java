/**
 * Find class
 *
 * 题目描述
 * 二维数组中的查找
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author hdonghong
 * @date 2018/03/20
 */
public class Find {
    public boolean Find(int target, int [][] array) {
        /*
        if (array.length < 1) return false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == target)
                    return true;
            }
        }
        return false;
        */
        /*
            别人的思路：
            从左下角开始，向上是递减，向右递增
         */
        if (array.length < 1) return false;
        int i = array.length - 1;
        int j = 0;
        while (i >= 0 && j < array[i].length) {
            if (target > array[i][j]) {
                j++;
            } else if (target < array[i][j]) {
                i--;
            } else {
                return true;
            }
        }
        return false;

    }
}
