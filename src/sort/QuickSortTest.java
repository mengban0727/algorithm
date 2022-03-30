package sort;

/**
 * @author zhangjie
 */
public class QuickSortTest {


  public static void quickSort(int []a,int left,int right){
    if(left>=right){
      return;
    }
    //1.分区
    int mid = partition(a, left, right);
    //2.分治递归
    quickSort(a,left,mid-1);
    quickSort(a,mid+1,right);
  }

  public static int partition(int []a,int left,int right){
    //最后一位分区
    int pivot= a[right];

    //比分区点小的下标
    int i = left;

    //遍历
    for(int j = left; j < right;j++){
      if(a[j]<pivot){
        swap(a,i,j);
        i++;
      }
    }

    swap(a,i,right);
    return right;
  }

  private static void swap(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }

  public static void main(String[] args) {
    int [] a = new int[]{3,4,5,1,2};
    quickSort(a,0,a.length-1);
    System.out.println(a);
  }
}
