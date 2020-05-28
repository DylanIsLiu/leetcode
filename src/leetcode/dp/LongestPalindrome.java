package leetcode.dp;

/**
 * 最长回文串 如aba / bb/ aaacaaa
 * DP
 *
 * @author Liumz
 * @since 2020-05-11  14:56:41
 */
public class LongestPalindrome {

    /**
     * DP求最长  dp[i][j]  && i-1 == j+1 -> dp[i-1][j+1]
     * 可以获得长度和下标。初始化i = j 或 i = j-1
     *
     * @param s 字符串
     * @return 最长
     */
    public static String longestPalindrome(String s) {
        int len = s.length();
        int maxLength = 0;
        char[] charArry = s.toCharArray();
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < len - 1; i++) {
            dp[i][i + 1] = charArry[i] == charArry[i + 1];
        }

        int finali = 0;
        int finalj = 0;

        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j <len; j++) {
                if(j != i+1){
                    dp[i][j] = dp[i + 1][j - 1] && charArry[i] == charArry[j];
                }
                if (dp[i][j] && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    finali = i;
                    finalj = j;
                }
            }
        }

        return s.substring(finali, finalj + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));
    }
}
