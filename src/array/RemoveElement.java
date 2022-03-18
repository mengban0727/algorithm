package array;

class RemoveElement {

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