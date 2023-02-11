package search;

/**
 * 二分法求平方根 https://leetcode.cn/problems/sqrtx/solutions/?orderBy=hot
 *
 * https://leetcode.cn/problems/sqrtx/solutions/7866/er-fen-cha-zhao-niu-dun-fa-python-dai-ma-by-liweiw/?orderBy=hot
 *
 * @author zhangjie
 */
public class BinarySqrt {

  public static int sqrt(int x) {
    if (x == 0) {
      return 0;
    }
    long left = 1;
    long right = x / 2;
    while (left < right) {
      //注意mid取右中位数，不然会死循环
      long mid = left + (right - left + 1) / 2;
      long square = mid * mid;
      if (square > x) {
        right = mid - 1;
      } else {
        left = mid;
      }
    }
    return (int) left;
  }

  public static void main(String[] args) {
    sqrt(9);
  }

}
