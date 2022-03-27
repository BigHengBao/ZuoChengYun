package day15;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/27/11:37
 * title：背包问题
 * 给定两个长度都为N的数组weight和values，weight[i]和values[i]分别表示i号物品的重量和价值。
 * 给定一个正数bag，表示一个载重bag的袋子，你装的物品不能超过这个重量，返回你能装下的最多的价值是多少
 */
public class BagProcess {
    public static void main(String[] args) {

    }

    // i..的货物自由选择，形成的最大价值返回
    // 重量不要超过bag
    // 之前做过的决定所形成的重量，alreadyWeight
    public static int process(int[] weight, int[] values, int i, int alreadyWeight, int bag) {
        if (alreadyWeight > bag) {
            return 0;
        }
        if (i == weight.length) {
            return 0;
        }

        return Math.max(

                process(
                        // 不要i号货物
                        weight, values, i + 1, alreadyWeight, bag),
                //要i号货物
                values[i] + process(weight, values, i + 1, alreadyWeight + weight[i], bag)
        );
    }
}
