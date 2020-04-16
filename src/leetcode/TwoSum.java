package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 利用hashmap  做到时间复杂度 o(1)  空间复杂度 o(n)
 *
 * @author Liumz
 * @since 2019-04-12  11:28:20
 */
public class TwoSum {

    /**
     * 利用hashmap  做到时间复杂度 o(1)  空间复杂度 o(n)
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums.length <= 0) {
            throw new IllegalArgumentException("");
        }
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp) && map.get(temp) != i) {
                return new int[] { i, map.get(temp) };
            }
        }

        throw new IllegalArgumentException("");
    }

    public static void main(String[] args) {
        twoSum(new int[] { 3, 3 }, 6);
    }
}
