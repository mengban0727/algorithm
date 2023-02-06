package array;

/**
 * 寻找两个正序数组的中位数 https://leetcode.cn/problems/median-of-two-sorted-arrays/
 *
 * @author zhangjie
 */
public class FindMedianSortedArrays {

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int len1 = nums1.length;
    int len2 = nums2.length;
    int k = (len1 + len2 + 1) / 2;
    return findKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, k);

  }

  public static double findKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2,
      int k) {
    int dis1 = end1 - start1 + 1;
    int dis2 = end2 - start2 + 1;
    if (dis1 == 0) {
      return nums2[start2 + k - 1];
    }
    if (dis2 == 0) {
      return nums1[start1 + k - 1];
    }
    if (k == 1) {
      return Math.min(nums1[start1], nums2[start2]);
    }
    int i = start1 + Math.min(dis1, k / 2) - 1;
    int j = start2 + Math.min(dis2, k / 2) - 1;
    if (nums1[i] < nums2[j]) {
      return findKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
    } else {
      return findKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
    }

  }

  public static void main(String[] args) {
    findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
  }

}
