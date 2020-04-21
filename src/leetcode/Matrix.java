package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 考察内容   广度优先搜索
 * （队列入队顺序，只要顶点出队，则开始入队各个邻接点。邻接点入队完毕，开始出队头，队头邻接点继续入队）
 * 深度优先一般是解决连通性问题，而广度优先一般是解决最短路径问题
 * <p>
 * 问  给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。 两个相邻元素间的距离为 1
 *
 * @author Liumz
 * @since 2020-04-15  13:48:25
 */
public class Matrix {

    /**
     * 最短路径可以用广度优先搜索，设一个super0，与所有0连通。先将所有0入队，然后依次出队，入队刚出队的所有邻接点（未入队过）。如此循环到队列为空。
     * 广度遍历搜索出所有节点。并计算距离
     *
     * @param matrix 输入矩阵
     * @return 输出矩阵
     */
    public static int[][] updateMatrix(int[][] matrix) {
        if (matrix.length > 10000) {
            return null;
        }

        int sl = matrix.length;
        int ml = matrix[0].length;

        boolean[][] existArray = new boolean[sl][ml];
        Queue<int[]> queue = new LinkedList<>();

        int[][] outputArray = new int[sl][ml];
        for (int i = 0; i < sl; i++) {
            for (int j = 0; j < ml; j++) {
                if (matrix[i][j] == 0) {
                    existArray[i][j] = true;
                    queue.offer(new int[] { i, j });
                    //可省略，初始值为0  outputArray[i][j] = 0;
                }
            }
        }

        int[][] direction = new int[][] { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
        while (!queue.isEmpty()) {
            int[] firstItem = queue.poll();
            int i = firstItem[0];
            int j = firstItem[1];

            for (int k = 0; k < direction.length; k++) {
                int x = i + direction[k][0];
                int y = j + direction[k][1];
                if (x >= 0 && y >= 0 && x < sl && y < ml && !existArray[x][y]) {
                    queue.offer(new int[] { x, y });
                    existArray[x][y] = true;
                    outputArray[x][y] = outputArray[i][j] + 1;
                }
            }
        }

        return outputArray;
    }

    public static void soutMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 0 }, { 0 }, { 0 }, { 0 } };
        soutMatrix(matrix);
        int[][] outputMatrix = updateMatrix(matrix);
        soutMatrix(outputMatrix);
    }
}
