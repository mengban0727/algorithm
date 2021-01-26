package sort;

/**
 * @author zhangjie
 */
public class MergeSort {

  public static void mergeSort(int[] a, int n) {
    mergeSortInternally(a, 0, n - 1);
  }

  private static void mergeSortInternally(int[] a, int left, int right) {
    if (left >= right) {
      return;
    }
    int q = left + (right - left) / 2;
    mergeSortInternally(a, left, q);
    mergeSortInternally(a, q + 1, right);
    merge(a, left, q, right);
  }

  private static void merge(int[] a, int left, int mid, int right) {
    int i = left;
    int j = mid + 1;
    int[] tmp = new int[right - left + 1];
    int k = 0;
    while (i <= mid && j <= right) {
      if (a[i] < a[j]) {
        tmp[k++] = a[i++];

      } else {
        tmp[k++] = a[j++];

      }
    }

    int start = i;
    int end = mid;
    if (j <= right) {
      start = j;
      end = right;
    }

    while (start <= end) {
      tmp[k++] = a[start++];
    }

    for (i = 0; i <= right - left; i++) {
      a[left + i] = tmp[i];
    }

  }
}
