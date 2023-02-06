package array;

/**
 * 缺失的第一个正数 https://leetcode.cn/problems/first-missing-positive/
 *
 * @author zhangjie
 */
public class FirstMissingPositive {

  public static int firstMissingPositive(int[] nums) {
    int length = nums.length;

    for (int i = 0; i < length; i++) {
      //1,2,3,4
      while (nums[i] >= 1 && nums[i] <= length && nums[i] != nums[nums[i] - 1]) {
        //当前元素下标和当前元素应该在的元素下标交换
        swap(nums, i, nums[i] - 1);
      }
    }

    //遍历数组，找到最小正整数
    for (int i = 0; i < length; i++) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }

    return length + 1;


  }

  private static void swap(int[] nums, int i, int i1) {
    int tmp = nums[i1];
    nums[i1] = nums[i];
    nums[i] = tmp;
  }

  public static void main(String[] args) {
    int i = firstMissingPositive(new int[]{0, 1, 2});
    System.out.println(i);
  }

}
