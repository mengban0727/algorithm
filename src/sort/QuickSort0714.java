package sort;

import java.util.Arrays;

/**
 * @author zhangjie
 */
public class QuickSort0714 {

  public static void quickSort(int[] a, int n) {
    quickSort(a, 0, n - 1);
  }

  private static void quickSort(int[] a, int left, int right) {
    if (left >= right) {
      return;
    }
    int mid = partition(a, left, right);
    quickSort(a, left, mid - 1);
    quickSort(a, mid + 1, right);
  }

  private static void swap(int[] a, int left, int right) {
    int tmp = a[right];
    a[right] = a[left];
    a[left] = tmp;
  }

  //2, 5, 1, 3, 6, 2
  private static int partition(int[] a, int left, int right) {
    //选取最后一位作为pivot
    int pivot = a[right];

    //已分区好的
    int i = left;

    for (int j = left; j < right - 1; j++) {
      if (a[j] > pivot) {

      } else {
        if(i==j){
          i++;
        }else{
          swap(a, i, j);
          i++;
        }
      }
    }

    swap(a, i, right);
    return i;
  }

  public static void main(String[] args) {
    int[] a = new int[]{2, 5, 1, 3, 6, 2};
    quickSort(a, a.length);
    System.out.println(Arrays.toString(a));
  }
}
