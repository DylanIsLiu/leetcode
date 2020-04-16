package leetcode;

/**
 * Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * 方法1： 时间复杂度 O(n2) 空间复杂度 O(1)
 *   双循环查找
 * 方法2: 时间复杂度 O (n) 空间复杂度O1
 *   Ascll码法。定义长度256的ascll码字符集合数组，循环字符串，每个字符存在则数组对应的值+i(当前字符索引+1)。
 *   如果当前循环中，无重复字符，nowLength++
 *   如果当前循环中，遇到了重复的字符，且在nowLength对应的字符串中存在 ,即nowLength>i-indexp1。当前nowLength重新计算 即nowLength = i-indexP1+1
 *   如果当前循环中，遇到了重复的字符，且在nowLength对应的字符串中不存在 ,则继续+1
 *
 * @author Liumz
 * @since 2019-06-03  15:53:43
 */
public class LongestSubString {

    public static int lengthOfLongestSubstring(String s) {
        return solu2(s);
    }

    public static int solu1(String s){
        int maxLength = 0;
        if (s == null || s.isEmpty()) {
            return maxLength;
        }

        for (int i = 0; i < s.length(); i++) {
            String temp = "";
            for (int j = i; j < s.length(); j++) {
                if (temp.contains(s.charAt(j) + "")) {
                    break;
                }
                temp += s.charAt(j);
            }
            if (temp.length() > maxLength) {
                maxLength = temp.length();
            }
        }

        return maxLength;
    }

    /**
     * abcdab
     * abcd
     * a
     * if(nowLength > i-indexP1){
     *     nowLength = i-indexP1+1;
     * }
     *
     *@param s inputStr
     *@return
     */
    public static int solu2(String s){
        int[] appearance = new int[256];

        int nowLength = 0;
        int maxLength = 0;

        int indexP1; // index plus 1.

        final int size = s.length(); // The length of input string.

        char ch;

        for (int i = 0; i < size; ) {
            ch = s.charAt(i);
            indexP1 = appearance[ch];

            //当前i - 上一次  i- indexP1>nowLeb
            if (0 == indexP1) {
                // 0 means codePoint is not contained.
                // update nowLength++;
                nowLength++;
            } else if (indexP1 > i - nowLength) {
                //当前长度为  两个相同字符的间距
                nowLength = i - indexP1 + 1;
            } else {
                nowLength++;
            }

            if (nowLength > maxLength){
                maxLength = nowLength; // record max length.
            }
            appearance[ch] = ++i; // record current.
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
