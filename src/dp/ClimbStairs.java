package dp;

/**
 * 爬楼梯
 *
 * @author zhangjie
 */
public class ClimbStairs {

  public int climbStairs(int n) {
    int p = 0, q = 0, r = 1;
    //f(n) = f(n-1)+f(n-2)
    for (int i = 1; i <= n; i++) {
      p = q;
      q = r;
      r = p + q;
    }
    return r;
  }
}
