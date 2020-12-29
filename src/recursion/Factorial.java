package recursion;

/**
 * n阶乘
 *
 * @author zhangjie
 */
public class Factorial {

  public long factorial(int n) {
    if (n == 1) {
      return 1;
    }

    return n * factorial(n - 1);
  }
}
