package dp;

import java.util.Arrays;

/**
 * @author zhangjie
 */
public class NumSquares {
  public static int numSquares(int n) {
    int []dp = new int[n+1];
    Arrays.fill(dp,Integer.MAX_VALUE);
    dp[0] = 0;
    dp[1] = 1;
    for(int i = 1;i <= Math.sqrt(n); i++){
      for(int j = 2 ; j <= n; j++){
        if(j-i*i>=0){
          dp[j] = Math.min(dp[j],dp[j-i*i]+1);
        }
      }
    }

    return dp[n];
  }

  public static void main(String[] args) {
    System.out.println( numSquares(12));
  }

}
