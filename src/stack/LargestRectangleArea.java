package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 柱状图中最大的矩形
 *
 * https://leetcode.cn/problems/largest-rectangle-in-histogram/
 *
 * @author zhangjie
 */
public class LargestRectangleArea {

  public static int largestRectangleArea(int[] heights) {
    int len = heights.length;
    Deque<Integer> stack = new ArrayDeque<>();
    int max = 0;
    for (int i = 0; i < len; i++) {
      while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
        int index = stack.pop();
        //优化，两个相同的柱子
        while (!stack.isEmpty() && heights[stack.peek()] == heights[index]) {
          stack.pop();
        }
        int width = 0;
        if (stack.isEmpty()) {
          width = i;
        } else {
          width = i - stack.peek() - 1;
        }
        max = Math.max(max, width * heights[index]);
      }
      stack.push(i);
    }

    while (!stack.isEmpty()) {
      int index = stack.pop();
      int width = 0;
      if (stack.isEmpty()) {
        width = len;
      } else {
        width = len - stack.peek() - 1;
      }
      max = Math.max(max, width * heights[index]);
    }

    return max;
  }

  public static void main(String[] args) {
    largestRectangleArea(new int[]{4, 2, 0, 3, 2, 5});
  }
}
