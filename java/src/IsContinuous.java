/**
 * IsContinuous class<br/>
 *
 * 扑克牌顺子
 *
 * 题目描述
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,
 * 想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”
 * 不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成
 * “1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉
 * 我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 *
 * @author hdonghong
 * @since 2018/10/30
 */
public class IsContinuous {

    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length < 1) {
            return false;
        }

        int[] numberCount = new int[14];
        for (int i = 0, len = numbers.length; i < len; i++) {
            if (++numberCount[numbers[i]] > 1 && numbers[i] != 0) {
                return false;
            }
        }
        boolean ret = true;
        for (int i = 1; i < 14; i++) {
            if (numberCount[i] == 1 && ret) {
                while (++i < 14) {
                    if (numberCount[i] != 1 && numberCount[0]-- <= 0) {
                        ret = false;
                        break;
                    }
                }
            }
            if (numberCount[i] == 0 && !ret) {
                while (++i < 14) {
                    if (numberCount[i] == 0) {
                        ret = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new IsContinuous().isContinuous(new int[]{1, 3, 0, 0, 5, 8}));
    }
}
