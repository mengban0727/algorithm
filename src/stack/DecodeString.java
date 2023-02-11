package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 字符串解码 https://leetcode.cn/problems/decode-string/
 *
 * @author zhangjie
 */
public class DecodeString {

  public static String decodeString(String s) {
    Deque<Integer> stack1 = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    Deque<Character> stack2 = new LinkedList<>();
    int multi = 0;
    for (int i = 0; i < s.length(); i++) {
      char tmp = s.charAt(i);

      if (tmp - '0' <= 9 && tmp - '0' >= 0) {
        multi = multi * 10 + Integer.parseInt(tmp + "");
        char nextChar = s.charAt(i + 1);
        if (!(nextChar - '0' <= 9 && nextChar - '0' >= 0)) {
          stack1.addLast(multi);
          multi = 0;
        }
      } else if (stack1.isEmpty()) {
        sb.append(tmp);
      } else if (']' != tmp) {
        stack2.addLast(tmp);
      } else {
        Character c = stack2.pollLast();
        StringBuilder sb2 = new StringBuilder();
        while (c != '[') {
          sb2.append(c);
          c = stack2.pollLast();
        }
        Integer count = stack1.pollLast();
        String s1 = sb2.reverse().toString();
        StringBuilder sb3 = new StringBuilder();
        for (int j = 0; j < count; j++) {
          sb3.append(s1);
        }
        String s3 = sb3.toString();
        if (stack2.isEmpty()) {
          sb.append(s3);
        } else {
          for (int k = 0; k < s3.length(); k++) {
            stack2.addLast(s3.charAt(k));
          }
        }
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    String s = decodeString("3[a2[c]]");
    System.out.println(s);
  }
}
