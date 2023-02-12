package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 最大矩形 将问题转换为. 柱状图中最大的矩形  https://leetcode.cn/problems/maximal-rectangle/description/?orderBy=hot
 *
 * https://leetcode.cn/problems/maximal-rectangle/solutions/1861698/by-ac_oier-k02i/?orderBy=hot
 *
 * @author zhangjie
 */
public class MaximalRectangle {

  public int maximalRectangle2(char[][] matrix) {
    int[] heights = new int[matrix[0].length];
    int max = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == '1') {
          heights[j] = heights[j] + 1;
        } else {
          heights[j] = 0;
        }
      }

      Deque<Integer> stack = new ArrayDeque<>();
      for (int k = 0; k < heights.length; k++) {
        while (!stack.isEmpty() && heights[stack.peek()] > heights[k]) {
          int index = stack.pop();
          int width;
          if (stack.isEmpty()) {
            width = k;
          } else {
            width = k - stack.peek() - 1;
          }
          max = Math.max(max, heights[index] * width);
        }
        stack.push(k);
      }
      while (!stack.isEmpty()) {
        int index = stack.pop();
        int width;
        if (stack.isEmpty()) {
          width = heights.length;
        } else {
          width = heights.length - stack.peek() - 1;
        }
        max = Math.max(max, heights[index] * width);
      }
    }
    return max;

  }


  public static int maximalRectangle(char[][] matrix) {
    int[] heights = new int[matrix[0].length + 2];
    heights[0] = 0;
    heights[heights.length - 1] = 0;
    int max = 0;
    for (int m = 0; m < matrix.length; m++) {
      for (int n = 0; n < matrix[0].length; n++) {
        if (matrix[m][n] == '1') {
          heights[n + 1] = heights[n + 1] + 1;
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
