package stack;

/**
 * @author zhangjie
 */
public class FindUnsortedSubarray {
  public static int findUnsortedSubarray(int[] nums) {
    int end = -1;
    int max = nums[0];
    int start = 0;
    int min = nums[nums.length-1];
    for(int i = 0 ; i < nums.length; i++){
      if(nums[i]<max){
        end = i;
      }else{
        max = nums[i];
      }

      if(nums[nums.length-1-i]>min){
        start = nums.length-1-i;
      }else{
        min = nums[nums.length-1-i];
      }
    }

    return end-start+1;
  }

  public static void main(String[] args) {
    System.out.println(findUnsortedSubarray(new int[]{1,2,3,4}));
  }
}
