package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 每日温度 https://leetcode.cn/problems/daily-temperatures/
 *
 * @author zhangjie
 */
public class DailyTemperature {

  public static int[] dailyTemperatures(int[] temperatures) {
    int[] result = new int[temperatures.length];
    Deque<Integer> stack = new LinkedList<>();
    stack.push(0);

    for (int i = 1; i < temperatures.length; i++) {
      while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
        int index = stack.pop();
        result[index] = i - index;
      }
      stack.push(i);
    }
    while (!stack.isEmpty()) {
      result[stack.pop()] = 0;
    }
    return result;
  }


  public static void main(String[] args) {
    dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
  }
}
