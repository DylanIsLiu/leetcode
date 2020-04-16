package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 冒泡排序
 * 平均时间复杂度On2，最好情况 On，最坏情况On2；
 * 空间复杂度 O1；
 * 排序方式：内排序(内存内)；
 * 稳定性 ：稳定(不改变相同元素的位置)
 * 比较排序
 *
 * 简介：
 * 长度为N的队列
 * 最多排序N-1次
 * 每次遍历N-i个
 *
 * @author Liumz
 * @since 2019-09-26  15:03:44
 */
public class BubbleSort {

    public static void main(String[] args) {

        int[] sortArray = new int[10];
        Random random = new Random();
        //初始化数组
        for (int i = 0; i < 10; i++) {
            sortArray[i] = random.nextInt(100);
        }

        //冒泡排序.每一趟都确定一个最大的数
        for (int i = 0; i < sortArray.length - 1; i++) {
            for (int j = 0; j < sortArray.length - i - 1; j++) {
                if (sortArray[j] > sortArray[j + 1]) {
                    int temp = sortArray[j];
                    sortArray[j] = sortArray[j + 1];
                    sortArray[j + 1] = temp;
                }
            }
        }

        Arrays.stream(sortArray).forEach(i -> System.out.print(i + "，"));
    }

}
