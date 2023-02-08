package array;

/**
 * @author zhangjie
 */
public class Unknown {

  public static void main(String[] args) {
    merge(new int[]{2, 0}, 1, new int[]{1}, 1);

  }
  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    if (n == 0) {
      return;
    }
    int i = 0;
    for (; i < m; ) {
      if (nums1[i] <= nums2[0]) {
        i++;
      } else {
        int tmp = nums1[i];
        nums1[i] = nums2[0];

        int k = 1;
        for (; k < n; k++) {
          if (tmp <= nums2[k]) {
            break;
          } else {
            nums2[k - 1] = nums2[k];
          }
        }
        nums2[k - 1] = tmp;


      }
    }
    for (int j = 0; j < n; j++) {
      nums1[i + j] = nums2[j];
    }

  }
}
