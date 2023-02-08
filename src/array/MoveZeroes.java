package array;

/**
 * 移动零 https://leetcode.cn/problems/move-zeroes/
 *
 * @author zhangjie
 */
public class MoveZeroes {
  public static void moveZeroes(int[] nums) {
    if(nums==null||nums.length==1){
      return;
    }
    int left = 0;
    int right = 0;
    while(right<nums.length){
      if(nums[right]!=0){
        swap(nums,left,right);
        left++;
      }else{
        right++;
      }
    }


  }

  private static void swap(int[] nums, int left, int right) {
    int tmp = nums[left];
    nums[left] = nums[right];
    nums[right] = tmp;
  }

  public static void main(String[] args) {
    moveZeroes(new int[]{1,0});
  }
}
