package array;

/**
 * 移除元素 https://leetcode.cn/problems/remove-element/description/
 */
class RemoveElement {

  public int removeElement2(int[] nums, int val) {
    int i = 0;
    int j = 0;
    for(;j<nums.length;j++){
      if(nums[j]!=val){
        nums[i] = nums[j];
        i++;
      }
    }
    return i;
  }

  public int removeElement(int[] nums, int val) {
    //不是指定val的下标
    int p = -1;
    //遍历的下标
    int q = 0;

    while (q < nums.length) {
      if (nums[q] == val) {
        q++;
      } else {
        nums[p + 1] = nums[q];
        p++;
        q++;
      }
    }

    return p + 1;

  }
}