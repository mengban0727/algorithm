package dp;

/**
 * 分割等和子集 https://leetcode.cn/problems/partition-equal-subset-sum/description/
 *
 * @author zhangjie
 */
public class PartitionEqualSubsetSum {

  public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum % 2 != 0) {
      return false;
    }
    sum = sum / 2 + 1;
    boolean[][] dp = new boolean[nums.length][sum];
    dp[0][0] = true;
    if (nums[0] < sum) {
      dp[0][nums[0]] = true;
    }

    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < sum; j++) {
        if (dp[i - 1][j]) {
          dp[i][j] = dp[i - 1][j];
        }
        if (j + nums[i] < sum && dp[i - 1][j]) {
          dp[i][j + nums[i]] = true;
        }
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (dp[i][sum - 1]) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    boolean canPartition = new PartitionEqualSubsetSum().canPartition(new int[]{1, 2, 3, 5});
    System.out.println(canPartition);
  }
}
