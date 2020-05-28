package leetcode.dp;

/**
 * https://leetcode-cn.com/problems/count-square-submatrices-with-all-ones/
 *
 * @author Liumz
 * @since 2020-05-15  15:00:06
 */
public class CountSquares {

    //region 暴力法 时间复杂度较高，无递推式。

    /**
     * 1 <= arr.length <= 300
     * 1 <= arr[0].length <= 300
     * 0 <= arr[i][j] <= 1
     *
     * @param matrix 矩阵
     * @return 数量
     */
    public static int countSquares(int[][] matrix) {
        int totalNum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int val = matrix[i][j];
                if (val == 0) {
                    continue;
                }

                int length = Math.min(matrix[0].length - j - 1, matrix.length - i - 1);
                for (int k = 0; k <= length; k++) {
                    if (isSquare(matrix, i, j, k)) {
                        totalNum++;
                    }
                }

            }
        }

        return totalNum;
    }

    private static boolean isSquare(int[][] matrix, int i, int j, int x) {
        for (int k = 0; k < x + 1; k++) {
            for (int l = 0; l < x + 1; l++) {
                if (matrix[i + k][j + l] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
    //endregion

    //region 动态规划，从右下角开始求出递推式

    /**
     * f(m,n)：（m,n）为右下角的正方形的边长 ;边长为n的正方形 也就有 n个包含自己的子正方形
     * f(m,n) = min(f(m,n-1),f(m-1,n),f(m-1,n-1))+1
     * if(i == 0 || j == 0) f(m,n) = 1 or 0
     * if(matrix[i][j] == 0) f(m,n) = 0
     *
     * @param matrix
     */
    public static int countSquaresForDp(int[][] matrix) {
        return 0;
    }

    public static int getSquareX(int[][] matrix, int i, int j) {
        return 0;
    }

    //endregion

    public static void main(String[] args) {
        int[][] x = new int[][] { { 1, 0, 1 }, { 1, 1, 0 }, { 1, 1, 0 } };
        System.out.println(countSquares(x));
    }
}
