package array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 杨辉三角最后一行 https://leetcode.cn/problems/pascals-triangle/
 *
 * @author zhangjie
 */
public class PascalsTriangleSim {

  public static List<Integer> getRow(int rowIndex) {
    int[] result = new int[rowIndex + 1];

    for (int i = 0; i < rowIndex + 1; i++) {
      result[i] = 1;
      for (int j = i - 1; j >= 1; j--) {
        result[j] = result[j] + result[j - 1];
      }
    }
    return Arrays.stream(result).boxed().collect(Collectors.toList());
  }

  public static void main(String[] args) {
    List<Integer> result = getRow(3);
    System.out.println(result);
  }
}
