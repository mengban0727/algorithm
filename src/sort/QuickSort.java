package sort;

/**
 * @author zhangjie
 */
public class QuickSort {

  public static void quickSort(int[] a, int n) {
    quickSortInternally(a, 0, n - 1);
  }

  private static void quickSortInternally(int[] a, int left, int right) {
    int mid = partition(a, left, right);
    quickSortInternally(a, left, mid - 1);
    quickSortInternally(a, mid + 1, right);
  }

  private static int partition(int[] a, int left, int right) {

    //选最后一位作为分区点
    int pivot = a[right];

    //i左边为小于分区点的下标
    int i = left;

    //j表示还没有进行分区的下标
    for (int j = left; j < right; j++) {

      //如果未分区的值比分区点小
      if (pivot > a[j]) {

        //如果i和j相等，i向后移动一位，i左侧为小于分区点的下标
        if (i == j) {
          i++;
        }
        //如果i和j不相等，则需要将a[i]和a[j]交换，i加一，i左侧为小于分区点的下标
        //比如：5，4，2，1，3，分区点的值位3，遍历到2时，2比3小，j为2，i为0，将5和2交换，i加1后为1，i左侧的数据小于分区点
        else {
          int tmp = a[i];
          a[i++] = a[j];
          a[j] = tmp;
        }
      }
    }

    //将分区点与i进行交换
    int tmp = a[i];
    a[i] = a[right];
    a[right] = tmp;

    //返回分区点的下标
    return i;
  }

  private static int partision(int []a,int left,int right){
    int pivot = a[right];
    int i = left;
    for(int j = left; j < right-1;j++){
      if(a[j]>pivot){

      }else{
        if(i==j){
          i++;
        }
        int tmp = a[i];
        a[i++] = a[j];
        a[j] = tmp;
      }
    }

    a[right] = a[i];
    a[i] = pivot;

    return i;
  }
}
