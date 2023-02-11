package search;

/**
 * 搜索旋转排序数组 https://leetcode.cn/problems/search-in-rotated-sorted-array/
 *
 * @author zhangjie
 */
public class SearchInRotatedSortedArray {

  public static int solution(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;

    while (low <= high) {
      int mid = low + ((high - low) >> 1);

      if (nums[mid] == target) {
        return mid;
      }

      //前半部分有序 2,3,4,5,6,7,1
      if (nums[low] <= nums[mid]) {

        //判断target在不在前半部分
        if (target >= nums[low] && target < nums[mid]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }
      //后半部分有序  6,7,1,2,3,4,5
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
