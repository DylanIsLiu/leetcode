package leetcode.dp;

/**
 * 贪心和动态规划的区别：
 * <p>
 * 1.贪心：本次最优解，包含上次最优解。
 * 【每次的最优解，一定包含上一次的最优解。在之前的不保留】
 * <p>
 * 动态规划：全局最优解，包含了某个局部最优解。记录所有的局部最优解
 * 【全局最优解中一定包含某个局部最优解，但不一定包含前一个局部最优解，需要记录之前的所有的局部最优解】
 * <p>
 * 2.贪心： 每次都去找最优的。
 * 【如果把所有的子问题看成一棵树的话，贪心从根出发，每次向下遍历最优子树即可（通常这个“最优”都是基于当前情况下显而易见的“最优”）；
 * 这样的话，就不需要知道一个节点的所有子树情况，于是构不成一棵完整的树；】
 * <p>
 * 动态规划： 通过所有的局部最优解，找到全局最优解
 * 【动态规划则自底向上，从叶子向根，构造子问题的解，对每一个子树的根，求出下面每一个叶子的值，最后得到一棵完整的树，
 * 并且最终选择其中的最优值作为自身的值，得到答案】
 * <p>
 * 3.根据以上两条可以知道，
 * 贪心 复杂度低，不一定最优
 * 动态规划 复杂度高，一定最优
 * 【贪心不能保证求得的最后解是最佳的，一般复杂度低；而动态规划本质是穷举法，可以保证结果是最佳的，复杂度高。】
 * <p>
 * dp求数组最大子序和
 *
 * @author Liumz
 * @since 2019-12-03  15:24:33
 */
public class MaximumSubarray {

    /**
     * 类似贪心算法 (记录上一步的最优解)
     * 遍历array
     * 1.设最大子序和为 res,初始值为 array[0]
     * 2.设当前最大子序和为 sum,初始值为 0
     * 3.
     * 若当前sum <=0, 和后面的子项(a[i])相加无增益，则取sum = a[i] (从当前开始 重新计算最大子序和)
     * 若当前sum > 0, 则取sum = sum + a[i]
     * <p>
     * 4.取 res = max(res,sum)
     */
    public static int getMaxSum(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int sum = 0;
        int res = array[0];
        for (int arr : array) {
            if (sum <= 0) {
                sum = arr;
            } else {
                sum += arr;
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    /**
     * 动态规划
     * 递推公式 dp[n] = max(dp[n-1]+a[n],a[n])
     */
    public static int getMaxSumDP(int[] nums) {
        int sum = nums[0];
        int maxDp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int sumNext = Math.max(sum + nums[i], nums[i]);
            maxDp = Math.max(Math.max(sumNext, sum), maxDp);
            sum = sumNext;
        }
        return maxDp;
    }
}
