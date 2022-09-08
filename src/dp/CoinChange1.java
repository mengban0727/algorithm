package dp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author zhangjie
 */
public class CoinChange1 {

  public static int coinChange(int[] coins, int amount) {
    if (amount == 0) {
      return 0;
    }
    int min = coins[0];
    for (int i = 1; i < coins.length; i++) {
      if (coins[i] < min) {
        min = coins[i];
      }
    }

    int length = amount / min;
    if (length == 0) {
      return -1;
    }
    length = amount % coins[0] == 0 ? length : length + 1;

    boolean[] dp = new boolean[amount + 1];
    for (int i = 0; i < coins.length; i++) {
      if (coins[i] < amount) {
        dp[coins[i]] = true;
      } else if (coins[i] == amount) {
        return 1;
      }
    }
    for (int i = 1; i < length; i++) {
      for (int j = amount; j > 0; j--) {
        if (dp[j]) {
          for (int k = 0; k < coins.length; k++) {
            if (j + coins[k] < amount) {
              dp[j + coins[k]] = true;
            } else if (j + coins[k] == amount) {
              return i + 1;
            }
          }
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int count = coinChange(new int[]{1, 2, 5}, 11);
    System.out.println(count);
  }


}
