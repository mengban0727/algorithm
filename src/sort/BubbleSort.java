package sort;

/**
 * @author zhangjie
 */
public class BubbleSort {


  public static void bubbleSort(int[] a, int n) {
    if (n <= 1) {
      return;
    }

    //记录最后一次交换的位置
    int lastExchange = 0;

    //比较的边界
    int sortBorder = n - 1;

    for (int i = 0; i < n-1; i++) {
      //提前退出标志
      boolean flag = false;
      for (int j = 0; j < sortBorder; j++) {
        if (a[j] > a[j + 1]) {
          int tmp = a[j + 1];
          a[j + 1] = a[j];
          a[j] = tmp;
          flag = true;
          lastExchange = j;
        }
      }
      sortBorder = lastExchange;

      //没有数据交换，则已经排好序
      if (!flag) {
        break;
      }

    }


  }
}
