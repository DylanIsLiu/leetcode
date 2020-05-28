package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [23,2,4,6,7], k = 6
 * 输出: True
 * 解释: [2,4] 是一个大小为 2 的子数组，并且和为 6。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Liumz
 * @since 2020-05-11  17:29:20
 */
public class ContinuousSubArraySum {

    /**
     * ???????
     * 暴力法或暴力法优化
     * HashMap保存，取余。遍历，若有相同余数，则必有k的倍数连续子串。因为2个相同余数的串的不相交子串的和 肯定 为 n*k
     */
    public static boolean checkSubarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (k != 0) {
                sum = sum % k;
            }
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }

        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 0,3, 1 };
        checkSubarraySum(nums, 3);
    }
}
