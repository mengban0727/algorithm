package dp;

/**
 * @author zhangjie
 */
public class FindTargetSumWays {
  private int count;
  public int findTargetSumWays(int[] nums, int target) {
    dfs(nums,target,0,0);
    return count;
  }
  public int findTargetSumWays2(int[] nums, int t) {
    int n = nums.length;
    int s = 0;
    for (int i : nums) {
      s += Math.abs(i);
    }
    if (Math.abs(t) > s) {
      return 0;
    }
    int[][] f = new int[n + 1][2 * s + 1];
    f[0][0+s] = 1;
    for (int i = 1; i <= n; i++) {
      int x = nums[i - 1];
      for (int j = -s; j <= s; j++) {
        if ((j - x+s) >= 0) f[i][j+s] += f[i - 1][(j - x)+s];
        if ((j + x+s) <= 2*s) f[i][j+s] += f[i - 1][(j + x)+s];
      }
    }
    return f[n][t+s];
  }

  public void dfs(int []nums,int target,int sum,int index){
    if(index==nums.length){
      if(sum==target){
        count++;
      }
      return;
    }

    dfs(nums,target,sum-nums[index],index+1);
    dfs(nums,target,sum+nums[index],index+1);
  }

  public static void main(String[] args) {
    FindTargetSumWays targetSumWays = new FindTargetSumWays();
    targetSumWays.findTargetSumWays2(new int[]{1,1,1,1,1},3);
  }
}
