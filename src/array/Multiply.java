package array;

/**
 * 字符串相乘 https://leetcode.cn/problems/multiply-strings/
 */
class Multiply {

  /**
   * 乘数 num1 位数为 M，被乘数 num2 位数为 N，
   *
   * num1 x num2 结果 res 最大总位数为 M+N num1[i] x num2[j] 的结果为
   *
   * tmp(位数为两位，"0x""0x""0x", "xy""xy""xy" 的形式)，
   *
   * 其第一位位于 res[i+j]，第二位位于 res[i+j+1]
   */
  public String multiply2(String num1, String num2) {
    if ("0".equals(num1) || "0".equals(num2)) {
      return "0";
    }
    int[] res = new int[num1.length() + num2.length()];
    for (int i = num1.length() - 1; i >= 0; i--) {
      int n1 = num1.charAt(i) - '0';
      for (int j = num2.length() - 1; j >= 0; j--) {
        int n2 = num2.charAt(j) - '0';
        int sum = (res[i + j + 1] + n1 * n2);
        res[i + j + 1] = sum % 10;
        res[i + j] += sum / 10;
      }
    }

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < res.length; i++) {
      if (i == 0 && res[i] == 0) {
        continue;
      }
      result.append(res[i]);
    }
    return result.toString();
  }


  public String multiply(String num1, String num2) {
    if (num1.equals("0") || num2.equals("0")) {
      return "0";
    }
    String ans = "0";
    int m = num1.length(), n = num2.length();
    for (int i = n - 1; i >= 0; i--) {
      StringBuffer curr = new StringBuffer();
      int add = 0;
      for (int j = n - 1; j > i; j--) {
        curr.append(0);
      }
      int y = num2.charAt(i) - '0';
      for (int j = m - 1; j >= 0; j--) {
        int x = num1.charAt(j) - '0';
        int product = x * y + add;
        curr.append(product % 10);
        add = product / 10;
      }
      if (add != 0) {
        curr.append(add % 10);
      }
      ans = addStrings(ans, curr.reverse().toString());
    }
    return ans;
  }

  public String addStrings(String num1, String num2) {
    int i = num1.length() - 1, j = num2.length() - 1, add = 0;
    StringBuffer ans = new StringBuffer();
    while (i >= 0 || j >= 0 || add != 0) {
      int x = i >= 0 ? num1.charAt(i) - '0' : 0;
      int y = j >= 0 ? num2.charAt(j) - '0' : 0;
      int result = x + y + add;
      ans.append(result % 10);
      add = result / 10;
      i--;
      j--;
    }
    ans.reverse();
    return ans.toString();
  }

  public static void main(String[] args) {
    Multiply multiply = new Multiply();
    multiply.multiply("345", "123");
  }
}
