package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangjie
 */
public class LetterCombinations {
  Map<Integer,String> numMap = new HashMap<>();

  public List<String> letterCombinations(String digits) {
    numMap.put(2,"abc");
    numMap.put(3,"def");
    numMap.put(4,"ghi");
    numMap.put(5,"jkl");
    numMap.put(6,"mno");
    numMap.put(7,"pqrs");
    numMap.put(8,"tuv");
    numMap.put(9,"wxyz");

    List<String> result = new ArrayList<>();
    dfs("",0,digits.length(),digits,result);
    return result;
  }

  public void dfs(String curr,int index,int length,String digits,List<String>result){
    if(index==length-1){
      result.add(curr);
      return;
    }

    String str = numMap.get(Integer.parseInt(String.valueOf(digits.charAt(index))));
    for(int i = 0; i < str.length();i++){
      dfs(curr+str.charAt(i),index+1,length,digits,result);
    }

  }

  public static void main(String[] args) {
    LetterCombinations letterCombinations = new LetterCombinations();
    letterCombinations.letterCombinations("23");
  }
}
