package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhangjie
 */
public class MaximalRectangle {

  public static int maximalRectangle(char[][] matrix) {
    int[] heights = new int[matrix[0].length + 2];
    heights[0] = 0;
    heights[heights.length - 1] = 0;
    int max = 0;
    for (int m = 0; m < matrix.length; m++) {
      for (int n = 0; n < matrix[0].length; n++) {
        if (matrix[m][n] == '1') {
          heights[n + 1] = heights[n + 1]+1;
        } else {
          heights[n + 1] = 0;
        }
      }

      Deque<Integer> stack = new ArrayDeque<>();
      stack.push(0);
      for (int i = 1; i < heights.length; i++) {
        while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
          int index = stack.pop();
          max = Math.max(max, heights[index] * (i - stack.peek() - 1));
        }
        stack.push(i);
      }
    }

    return max;
  }

  public static void main(String[] args) {
    char[][] chars = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'},
        {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
    int result = maximalRectangle(chars);
    System.out.println(result);
  }


}
