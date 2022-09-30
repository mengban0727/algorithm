package sort;

/**
 * @author zhangjie
 */
public class SortColors {

  public void sortColors(int[] nums) {
    int left = 0;
    int right = nums.length-1;
    int i = 0;
    while(left < right){
      if(nums[i]==0){
        swap(nums,i,left);
        left++;
        i++;
      }else if(nums[i]==1){
        i++;
      }else{
        swap(nums,right,i);
        right--;
      }
    }

  }

  public void swap(int[] nums, int a, int b) {
    int tmp = nums[a];
    nums[a] = nums[b];
    nums[b] = tmp;
  }

  public static void main(String[] args) {
    new SortColors().sortColors(new int[]{2,0,2,1,1,0});
  }
}
