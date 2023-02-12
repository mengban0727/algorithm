package stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 有效括号 https://leetcode.cn/problems/valid-parentheses/description/?orderBy=hot
 *
 * https://leetcode.cn/problems/valid-parentheses/solutions/9185/valid-parentheses-fu-zhu-zhan-fa-by-jin407891080/?orderBy=hot
 *
 * @author zhangjie
 */
public class ValidParentheses {

  private static final Map<Character, Character> map = new HashMap<Character, Character>() {
    {
      put('{', '}');
      put('[', ']');
      put('(', ')');
      put('?', '?');
    }
  };


  public boolean isValid(String s) {

    //单独处理第一个字符
    if (s.length() > 0 & !map.containsKey(s.charAt(0))) {
      return false;
    }

    //构造一个栈
    LinkedList<Character> stack = new LinkedList<Character>() {{
      //防止栈为空，pop报错
      add('?');
    }};

    for (char c : s.toCharArray()) {
      if (map.containsKey(c)) {
        //push
        stack.add(c);
      } else {
        //pop
        if (map.get(stack.removeLast()) != c) {
          return false;
        }
      }
    }

    return stack.size() == 1;
  }


}
