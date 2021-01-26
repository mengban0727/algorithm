package sort;

/**
 * @author zhangjie
 */
public class SelectionSort {

  public static void selectionSort(int[] a, int n) {
    if (n <= 1) {
      return;
    }
    for (int i = 0; i < n - 1; i++) {
      int min = i;
      for (int j = i + 1; j < n; j++) {
        if (a[j] < a[min]) {
          min = j;
        }
      }
      int tmp = a[i];
      a[i] = a[min];
      a[min] = tmp;
    }

  }
}
