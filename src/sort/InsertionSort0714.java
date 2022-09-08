package sort;

import java.util.Arrays;

/**
 * @author zhangjie
 */
public class InsertionSort0714 {

  public static void insertionSort(int[] a, int n) {
    for (int i = 1; i < n; i++) {
      int tmp = a[i];
      int j = i - 1;
      for (; j >= 0; j--) {
        if (a[j] > tmp) {
          a[j+1] = a[j];
        } else {
          break;
        }
      }
      a[j + 1] = tmp;
    }
  }

  public static void main(String[] args) {
    int[] a = new int[]{5, 3, 2, 1, 2, 6};
    insertionSort(a, a.length);
    System.out.println(Arrays.toString(a));
  }
}
