package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合 https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 *
 * @author zhangjie
 */
public class LetterCombinations {

  Map<Integer, String> numMap = new HashMap<>();

  public List<String> letterCombinations(String digits) {
    numMap.put(2, "abc");
    numMap.put(3, "def");
    numMap.put(4, "ghi");
    numMap.put(5, "jkl");
    numMap.put(6, "mno");
    numMap.put(7, "pqrs");
    numMap.put(8, "tuv");
    numMap.put(9, "wxyz");

    if (digits == null || "".equals(digits)) {
      return new ArrayList<>();
    }

    List<String> result = new ArrayList<>();
    dfs("", 0, digits.length(), digits, result);
    return result;
  }

  public void dfs(String curr, int index, int length, String digits, List<String> result) {
    if (index == length) {
      result.add(curr);
      return;
    }

    String str = numMap.get(Integer.parseInt(String.valueOf(digits.charAt(index))));
    for (int i = 0; i < str.length(); i++) {
      dfs(curr + str.charAt(i), index + 1, length, digits, result);
    }
  }


  public List<String> letterCombinations2(String digits) {
    numMap.put(2, "abc");
    numMap.put(3, "def");
    numMap.put(4, "ghi");
    numMap.put(5, "jkl");
    numMap.put(6, "mno");
    numMap.put(7, "pqrs");
    numMap.put(8, "tuv");
    numMap.put(9, "wxyz");

    List<String> result = new ArrayList<>();
    if (digits == null || "".equals(digits)) {
      return result;
    }

    String path = "";
    dfs2(digits, result, path, 0);
    return result;
  }

  public void dfs2(String digits, List<String> result, String path, int index) {
    if (index == digits.length()) {
      result.add(path);
      return;
    }

    String str = numMap.get(Integer.parseInt(String.valueOf(digits.charAt(index))));
    for (int i = 0; i < str.length(); i++) {
      dfs2(digits, result, path + str.charAt(i), index + 1);
    }
  }


  public static void main(String[] args) {
    LetterCombinations letterCombinations = new LetterCombinations();
    List<String> strings = letterCombinations.letterCombinations("23");
    System.out.println(strings);
  }
}
