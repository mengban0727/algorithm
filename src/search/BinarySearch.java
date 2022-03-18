package search;

/**
 * 二分查找
 *
 * @author zhangjie
 */
public class BinarySearch {

  public static int binarySearch(int[] a, int n, int value) {
    int low = 0;
    int high = n - 1;

    while (low <= high) {
      //int mid = low + ((high-low)>>1)
      int mid = low + (high - low) / 2;

      if (a[mid] == value) {
        return mid;
      } else if (a[mid] > value) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;

  }


  /**
   * 查找第一个等于给定值的元素
   */
  public static int binarySearch1(int[] a, int n, int value) {
    int low = 0;
    int high = n - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (a[mid] > value) {
        high = mid - 1;
      } else if (a[mid] < value) {
        low = mid + 1;
      } else {
        if ((mid == 0) || a[mid - 1] != value) {
          return mid;
        } else {
          high = mid - 1;
        }
      }
    }
    return -1;
  }

  /**
   * 查找最后一个值等于给定值的元素
   */
  public static int binarySearch2(int[] a, int n, int value) {
    int low = 0;
    int high = n - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (a[mid] < value) {
        low = mid + 1;
      } else if (a[mid] > value) {
        high = mid - 1;
      } else {

        if ((mid == n - 1) || a[mid + 1] != value) {
          return mid;
        } else {
          low = mid + 1;
        }
      }
    }
    return -1;
  }

  /**
   * 查找第一个大于等于给定值的元素
   */
  public static int binarySearch3(int[] a, int n, int value) {
    int low = 0;
    int high = n - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (a[mid] < value) {
        low = mid + 1;
      } else {
        if ((mid == 0) || a[mid - 1] < value) {
          return mid;
        } else {
          high = mid - 1;
        }
      }
    }
    return -1;
  }

  /**
   * 查找最后一个小于等于给定值的元素
   */
  public static int binarySearch4(int[] a, int n, int value) {
    int low = 0;
    int high = n - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (a[mid] > value) {
        high = mid - 1;
      } else {
        if ((mid == n - 1) || a[mid + 1] > value) {
          return mid;
        } else {
          low = mid + 1;
        }
      }
    }
    return -1;
  }


}
