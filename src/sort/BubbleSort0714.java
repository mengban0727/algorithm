package sort;

import java.util.Arrays;

/**
 * @author zhangjie
 */
public class BubbleSort0714 {

  public static void bubble(int[] a, int n) {

    for (int i = 0; i < n - 1; i++) {
      boolean flag = false;
      for (int j = 0; j < n - i - 1; j++) {
        if (a[j] > a[j + 1]) {
          swap(a, j, j + 1);
          flag = true;
        }
      }
      if (!flag) {
        break;
      }
    }
  }

  private static void swap(int[] a, int left, int right) {
    int tmp = a[right];
    a[right] = a[left];
    a[left] = tmp;
  }

  public static void main(String[] args) {
    int[] a = new int[]{5, 3, 2, 1, 2, 6};
    bubble(a, a.length);
    System.out.println(Arrays.toString(a));
  }
}
