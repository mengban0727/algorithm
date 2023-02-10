package queue;

import java.util.LinkedList;

/**
 * 滑动窗口最大值
 *
 * https://leetcode.cn/problems/sliding-window-maximum/solutions/667836/dong-hua-yan-shi-dan-diao-dui-lie-239hua-hc5u/
 *
 * @author zhangjie
 */
public class SlidingWindowMaximum {

  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length < 2) {
      return nums;
    }

    LinkedList<Integer> queue = new LinkedList<>();
    int[] result = new int[nums.length - k + 1];

    for (int i = 0; i < nums.length; i++) {

      //队列中弹出比当前小的数的下标
      while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
        queue.pollLast();
      }

      //添加当前数的下标
      queue.addLast(i);

      //判断队列头部的下标是否在范围内
      if (queue.peek() <= i - k) {
        queue.poll();
      }

      if (i + 1 >= k) {
        result[i + 1 - k] = nums[queue.peek()];
      }


    }

    return result;

  }
}
