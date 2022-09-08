package dp;

/**
 * @author zhangjie
 */
public class Backpack1 {

  public int solution(int[] weights, int max) {
    boolean[][] dp = new boolean[weights.length][max];
    dp[0][0] = true;
    if (weights[0] < max) {
      dp[0][weights[0]] = true;
    }

    for (int i = 1; i < weights.length; i++) {
      for (int j = 0; j < max; j++) {
        if (dp[i - 1][j]) {
          dp[i][j] = true;
        }
      }

      for (int j = 0; j < max - weights[i]; j++) {
        if (dp[i - 1][j]) {
          dp[i][j + weights[i]] = true;
        }
      }

    }

    for (int i = max; i >= 0; i--) {
      if (dp[weights.length - 1][i]) {
        return i;
      }
    }

    return 0;
  }
}
