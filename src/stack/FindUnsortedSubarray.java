package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序
 *
 * https://leetcode.cn/problems/shortest-unsorted-continuous-subarray/
 *
 * https://leetcode.cn/problems/shortest-unsorted-continuous-subarray/solutions/422614/si-lu-qing-xi-ming-liao-kan-bu-dong-bu-cun-zai-de-/?orderBy=hot
 *
 * 单调栈 https://leetcode.cn/problems/shortest-unsorted-continuous-subarray/solutions/913700/kan-tong-ge-shua-ti-jian-dan-yi-li-jie-d-2ci3/
 *
 * @author zhangjie
 */
public class FindUnsortedSubarray {

  public static int findUnsortedSubarray(int[] nums) {
    int end = -1;
    int max = nums[0];
    int start = 0;
    int min = nums[nums.length - 1];
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < max) {
        end = i;
      } else {
        max = nums[i];
      }

      if (nums[nums.length - 1 - i] > min) {
        start = nums.length - 1 - i;
      } else {
        min = nums[nums.length - 1 - i];
      }
    }

    return end - start + 1;
  }

  public int findUnsortedSubarray2(int[] nums) {
    // 单调栈从前往后遍历一遍可得到左边界
    Deque<Integer> stack = new ArrayDeque<>();
    int left = nums.length;
    for (int i = 0; i < nums.length; i++) {
      while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
        left = Math.min(left, stack.pop());
      }
      stack.push(i);
    }

    stack.clear();

    // 单调栈从后往前遍历一遍可得到右边界
    int right = -1;
    for (int i = nums.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
        right = Math.max(right, stack.pop());
      }
      stack.push(i);
    }

    return right - left > 0 ? right - left + 1 : 0;
  }

  public static void main(String[] args) {
    //只需要对 [2, 6, 0, 4, 1] 进行升序排序，那么整个表都会变为升序排序
    System.out.println(findUnsortedSubarray(new int[]{2, 6, 0, 4, 1, 9, 15}));
  }
}
