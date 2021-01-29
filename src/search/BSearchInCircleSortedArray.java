package search;

/**
 * 循环有序数组查找指定元素下标
 *
 * @author zhangjie
 */
public class BSearchInCircleSortedArray {

  public static int bSearchInCircleSortedArray(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;

    while (low <= high) {
      int mid = low + ((high - low) >> 1);

      if (nums[mid] == target) {
        return mid;
      }

      //前半部分有序
      if (nums[low] <= nums[mid]) {

        //判断target在不在前半部分
        if (target >= nums[low] && target < nums[mid]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }
      //后半部分有序
      else {
        if (target > nums[mid] && target <= nums[high]) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
    }

    return -1;


  }

}
