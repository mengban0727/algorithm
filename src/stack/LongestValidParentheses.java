package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 最长有效括号
 *
 * @author zhangjie
 */
public class LongestValidParentheses {


  /**
   * 解法一：利用栈找出最长有效括号
   */
  public int longestValidParentheses1(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    //栈存储下标
    Deque<Integer> stack = new ArrayDeque<>();

    //填充一个初始值好判断
    stack.push(-1);

    //最长有效长度
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.push(i);
      } else {
        stack.pop();

        if (stack.isEmpty()) {
          stack.push(i);
        } else {
          result = Math.max(result, i - stack.peek());
        }

      }
    }

    return result;


  }

  /**
   * 解法二：利用dp思想
   */
  public int longestValidParentheses2(String s) {
    return 0;
  }

}
