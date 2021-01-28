package sort;

/**
 * 计数排序
 *
 * 范围不大的数据排序，如考生成绩排序，年龄排序
 *
 * @author zhangjie
 */
public class CountingSort {

  public static void countingSort(int[] a, int n) {
    if (n <= 1) {
      return;
    }

    //查询最大值，数组的范围
    int max = a[0];
    for (int i = 1; i < n; i++) {
      if (a[i] > max) {
        max = a[i];
      }
    }

    //max+1长度的计数数组
    int[] counting = new int[max + 1];

    //统计每个数，出现的次数
    for (int i = 0; i < n; i++) {
      counting[a[i]]++;
    }

    //累加counting，每一位存储的数为比小于等于当前下标的个数
    for (int i = 1; i < n; i++) {
      counting[i] = counting[i - 1] + counting[i];
    }

    //排序后的结果
    int[] result = new int[n];

    //如果是从头开始遍历，两个相同的数排序后相对位置会交换，是不稳定的，所以从后往前遍历
    for (int i = n - 1; i >= 0; i--) {
      //当前元素应该放在result的下标（比当前元素小于等于的个数-1）
      int index = counting[a[i]] - 1;
      result[index] = a[i];
      counting[a[i]]--;
    }

    //result就是已经排好序的结果
    for (int i = 0; i < n; i++) {
      a[i] = result[i];
    }

  }

}
