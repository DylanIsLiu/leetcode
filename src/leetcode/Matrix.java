package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 考察内容   广度优先搜索
 * （队列入队顺序，只要顶点出队，则开始入队各个邻接点。邻接点入队完毕，开始出队头，队头邻接点继续入队）
 * 深度优先一般是解决连通性问题，而广度优先一般是解决最短路径问题
 *
 * @author Liumz
 * @since 2020-04-15  13:48:25
 */
public class Matrix {

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length > 10000) {
            return null;
        }
        int sl = matrix.length;
        int ml = matrix[0].length;

        boolean[][] existArray = new boolean[sl][ml];
        Queue<int[]> queue = new LinkedList<>();

        int[][] outputArray = new int[sl][sl];
        for (int i = 0; i < sl; i++) {
            for (int j = 0; j < ml; j++) {
                if (matrix[i][j] == 0) {
                    existArray[i][j] = true;
                    queue.offer(new int[] { i, j });
                }
            }
        }

        int[][] direction = new int[][] { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
        while (!queue.isEmpty()) {
            int[] firstItem = queue.poll();
            int i = firstItem[0];
            int j = firstItem[1];

            for (int k = 0; k < direction.length; k++) {

            }

        }
        return null;
    }

    public static void main(String[] args) {
    }

}
