package array;

import java.util.Arrays;

/**
 * 最接近的三数之和
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
 * 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案
 *

 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class ThreeSumClosest {

  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int ans = nums[0] + nums[1] + nums[2];
    for (int i = 0; i < nums.length; i++) {
      int start = i + 1, end = nums.length - 1;
      while (start < end) {
        int sum = nums[start] + nums[end] + nums[i];
        if (Math.abs(target - sum) < Math.abs(target - ans)) {
          ans = sum;
        }
        if (sum > target) {
          end--;
        } else if (sum < target) {
          start++;
        } else {
          return ans;
        }
      }
    }
    return ans;
  }
}