package recursion;

/**
 * 斐波那契数列
 *
 * @author zhangjie
 */
public class Fibonacci {

  public long fibonacci(int n) {
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }

    return fibonacci(n - 1) + fibonacci(n - 2);
  }
}
