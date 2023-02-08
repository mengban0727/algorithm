package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和: https://leetcode.cn/problems/3sum/
 *
 * Krahets: https://leetcode.cn/problems/3sum/solutions/11525/3sumpai-xu-shuang-zhi-zhen-yi-dong-by-jyd/
 *
 * @author zhangjie
 */
public class ThreeSum {

  public static List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();

    int n = nums.length;
    for (int i = 0; i < n; i++) {
      if (nums[i] > 0) {
        break;
      }
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int left = i + 1;
      int right = n - 1;
      //-4,-1,-1,0,1,2
      while (left < right) {
        int tmp = nums[i] + nums[left] + nums[right];
        if (tmp == 0) {
          result.add(Arrays.asList(nums[i], nums[left], nums[right]));
          while (left < right && nums[left] == nums[left + 1]) {
            left += 1;
          }
          while (left < right && nums[right] == nums[right - 1]) {
            right -= 1;
          }

          left += 1;
          right -= 1;
        } else if (tmp > 0) {
          right -= 1;
        } else {
          left += 1;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    threeSum(new int[]{-1, 0, 1, 2, -1, -4});
  }

}
