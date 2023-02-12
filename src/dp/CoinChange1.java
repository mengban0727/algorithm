package dp;

import java.util.Arrays;

/**
 * 零钱兑换 https://leetcode.cn/problems/coin-change/
 *
 * @author zhangjie
 */
public class CoinChange1 {

  int INF = 0x3f3f3f3f;

  public int coinChange2(int[] cs, int cnt) {
    int[] dp = new int[cnt + 1];
    Arrays.fill(dp, INF);
    dp[0] = 0;
    for (int i = 0; i < cs.length; i++) {
      for (int j = 0; j < cnt + 1; j++) {
        if (j - cs[i] >= 0 && dp[j - cs[i]] != INF) {
          dp[j] = Math.min(dp[j], dp[j - cs[i]] + 1);
        }
      }
    }
    return dp[cnt] != INF ? dp[cnt] : -1;
  }


  public static int coinChange(int[] coins, int amount) {
    if (amount == 0) {
      return 0;
    }

    //找出最小的零钱
    int min = coins[0];
    for (int i = 1; i < coins.length; i++) {
      if (coins[i] < min) {
        min = coins[i];
      }
    }
    //按照最小的零钱，最多兑换的次数
    int length = amount / min;
    if (length == 0) {
      return -1;
    }
    length = amount % coins[0] == 0 ? length : length + 1;

    boolean[] dp = new boolean[amount + 1];
    //拿一个硬币的时候的情况
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
