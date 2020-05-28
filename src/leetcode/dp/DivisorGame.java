package leetcode.dp;

/**
 * 推理题： 题目简化成：爱丽丝先手，鲍勃后手，每次减约数，约数不能是自身，谁拿到1谁输。 下面两条定理： A:奇数的约数肯定是奇数。 B:1是所有数的约数，2是所有偶数的约数。
 * <p>
 * 由A推导出C:奇数减任意约数都是偶数。 由B推导出D:偶数减任意约数或奇或偶。
 * <p>
 * 假设每人每步都选择最优方案，则拿到偶数的人可以让对方拿到奇数： 偶->奇->偶->奇->……2->1(输)
 * <p>
 * 所以偶数先手必赢，奇数先手导致后手为偶数（由于C），所以奇数先手必输。
 * <p>
 * 结论：N为奇数时爱丽丝输，返回false。N为偶数时爱丽丝赢，返回true
 * https://leetcode-cn.com/problems/divisor-game/
 *
 * @author Liumz
 * @since 2020-05-19  16:28:45
 */
public class DivisorGame {
    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }
}
