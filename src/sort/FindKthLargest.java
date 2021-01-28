package sort;

/**
 * 数组中的第k个最大元素
 *
 * @author zhangjie
 */
public class FindKthLargest {

  public static int findKthLargest(int[] nums, int k) {
    //第k大的下标为nums.length-k
    return querySelect(nums, 0, nums.length - 1, nums.length - k);
  }

  private static int querySelect(int[] nums, int left, int right, int index) {
    int pivotIndex = partition(nums, left, right);
    if (index == pivotIndex) {
      return nums[pivotIndex];
    } else if (pivotIndex < index) {
      return querySelect(nums, pivotIndex + 1, right, index);
    } else {
      return querySelect(nums, left, pivotIndex - 1, index);
    }
  }

  //快排分区函数
  private static int partition(int[] nums, int left, int right) {
    int i = left;
    //最后一位作为分区数
    int pivot = nums[right];
    for (int j = i; j < right; j++) {
      if (nums[j] < pivot) {
        if (i == j) {
          i++;
        } else {
          int tmp = nums[j];
          nums[j] = nums[i];
          nums[i] = tmp;
          i++;
        }
      }
    }
    nums[right] = nums[i];
    nums[i] = pivot;
    return i;
  }

  public static void main(String[] args) {
    findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
  }
}
