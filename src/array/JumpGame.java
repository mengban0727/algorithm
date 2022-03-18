package array;

import java.text.DecimalFormat;

class JumpGame {

  public static int jump(int[] nums) {
    int length = nums.length;
    int end = 0;
    int maxPosition = 0;
    int steps = 0;
    for (int i = 0; i < length - 1; i++) {
      maxPosition = Math.max(maxPosition, i + nums[i]);
      if (i == end) {
        end = maxPosition;
        steps++;
      }
    }
    return steps;
  }

  public static int jump2(int[] nums) {
    int step = 0;
    int start = 0;
    int end = 1;

    while (end < nums.length) {
      int maxPos = 0;

      for (int i = start; i < end; i++) {
        maxPos = Math.max(maxPos, i + nums[i]);
      }

      start = end;
      end = maxPos + 1;
      step++;
    }

    return step;

  }

  public static boolean jump3(int[] nums) {

    int maxPosition = 0;
    for (int i = 0; i < nums.length; i++) {

      if (i <= maxPosition) {
        maxPosition = Math.max(maxPosition, i + nums[i]);

        if (maxPosition >= nums.length - 1) {
          return true;
        }

      }


    }

    return false;

  }

  public int[][] generateMatrix(int n) {
    int[][] nums = new int[n][n];

    int num = 1;
    int target = n * n;

    int left = 0;
    int right = n - 1;
    int top = 0;
    int bottom = n - 1;
    while (num <= target) {
      for (int i = left; i <= right; i++) {
        nums[top][i] = num++;
      }
      top++;

      for (int i = top; i <= bottom; i++) {
        nums[i][right] = num++;
      }

      right--;

      for (int i = right; i >= left; i--) {
        nums[bottom][i] = num++;
      }
      bottom--;

      for (int i = bottom; i >= top; i--) {
        nums[i][left] = num++;
      }

      left++;


    }

    return nums;

  }

  public int uniquePaths(int m, int n) {
    int bottom = 1;
    int right = 1;
    return dfs(bottom, right, m, n);

  }

  public int uniquePaths2(int m, int n) {
    int bottom = 1;
    int right = 1;
    return dfs(bottom, right, m, n);

  }


  private int dfs(int bottom, int right, int m, int n) {

    if (bottom > m || right > n) {
      return 0;
    }

    if (bottom == m && right == n) {
      return 1;
    }

    return dfs(bottom + 1, right, m, n) + dfs(bottom, right + 1, m, n);
  }

  public int minPathSum(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int rows = grid.length;
    int columns = grid[0].length;

    int[][] dp = new int[rows][columns];

    dp[0][0] = grid[0][0];

    for (int i = 1; i < rows; i++) {
      dp[i][0] = dp[i - 1][0] + grid[i][0];
    }

    for (int i = 1; i < columns; i++) {
      dp[0][i] = dp[0][i - 1] + grid[0][i];
    }

    for (int i = 1; i < rows; i++) {
      for (int j = 1; j < columns; j++) {
        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
      }
    }

    return dp[rows - 1][columns - 1];

  }

  public static void sortColors(int[] nums) {
    //[2,0,2,1,1,0]

    //遍历下标
    int index = 0;

    //zero左侧的为0的数
    int zero = 0;
    //two右侧的为2的数
    int two = nums.length-1;

    while (index<=two) {
      if (nums[index] == 0) {
        swap(nums, index, zero);
        index++;
        zero++;
      } else if (nums[index] == 1) {
        index++;
      } else {
        swap(nums, index, two);
        two--;
      }


    }


  }

  private static void swap(int[] nums, int index, int zero) {
    int tmp = nums[index];
    nums[index] = nums[zero];
    nums[zero] = tmp;
  }


  public static void main(String[] args) {
  //  sortColors(new int[]{2,0,2,1,1,0});


    System.out.println(new DecimalFormat("000,000.00").format(12222111.5888));
    System.out.println(new DecimalFormat("000,000.00").format(1111.5888));
    System.out.println(new DecimalFormat("000,000.00").format(1111.7844));
    System.out.println(new DecimalFormat("000,000.00").format(1112.98));
    System.out.println(new DecimalFormat("000,000.00").format(1113.80));
    System.out.println(new DecimalFormat("000,000.00").format(1114.8));
    System.out.println(new DecimalFormat("000,000.00").format(1115.00));
    System.out.println(new DecimalFormat("000,000.00").format(0.686));
    System.out.println(new DecimalFormat("000,000.00").format(0.784));
    System.out.println(new DecimalFormat("000,000.00").format(0.88));
    System.out.println(new DecimalFormat("000,000.00").format(0.8));
    System.out.println(new DecimalFormat("000,000.00").format(0));



    //jump2(new int[]{2, 3, 1, 2, 4});
  }
}