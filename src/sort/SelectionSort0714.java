package sort;

import java.util.Arrays;

/**
 * @author zhangjie
 */
public class SelectionSort0714 {

  public static void selection(int[] a, int n) {
    for (int i = 0; i < n - 1; i++) {
      int min = i;
      for (int j = i + 1; j < n; j++) {
        if (a[j] < a[min]) {
          min = j;
        }
      }
      if (min != i) {
        swap(a, i, min);
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
    selection(a, a.length);
    System.out.println(Arrays.toString(a));
  }

}
