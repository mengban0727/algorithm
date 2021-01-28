package sort;

/**
 * 基数排序
 *
 * 数据要求比较苛刻: 1.数据能划分为高低位，位与位之间有进位关系 2.每一位的数据范围不能太大
 *
 * 如：电话号码排序，ip地址排序，字符串排序
 *
 * @author zhangjie
 */
public class RadixSort {


  public static void radixSort(int[] arr) {

    int max = arr[0];

    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }

    //从个位开始排序

    for (int exp = 1; max / exp > 0; exp *= 10) {
      countingSort(arr, exp);


    }


  }

  public static void countingSort(int[] arr, int exp) {
    if (arr.length <= 1) {
      return;
    }

    //计算每一位元素的个数,范围0-9
    int[] c = new int[10];
    for (int i = 0; i < arr.length; i++) {
      c[(arr[i] / exp) % 10]++;
    }

    //计算排序后的位置
    for (int i = 1; i < c.length; i++) {
      c[i] = c[i - 1] + c[i];
    }

    int[] r = new int[arr.length];
    for (int i = arr.length - 1; i >= 0; i++) {
      r[c[(arr[i] / exp) % 10] - 1] = arr[i];
      c[(arr[i] / exp) % 10]--;
    }

    for (int i = 0; i < arr.length; i++) {
      arr[i] = r[i];
    }

  }


}
