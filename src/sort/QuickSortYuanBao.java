package sort;

import java.util.Arrays;

/**
 * @author zhangjie
 */
public class QuickSortYuanBao {

    public static void main(String[] args) {
      int[] nums = new int[]{3,1,4,53,2};
      quickSort(nums,0,nums.length-1);
      System.out.println(Arrays.toString(nums));
    }


    public static void quickSort(int[] nums,int start,int end){
      if(start>=end){
        return;
      }
      int pivot = quickSort2(nums, start, end);
      quickSort(nums,start,pivot-1);
      quickSort(nums,pivot+1,end);
    }

    public static int quickSort2(int[] nums,int start,int end){
      int pivot = end;

      int left = start;
      int right = start;
      while(right<end){
        if(nums[right]>=nums[pivot]){
          right++;
        }else{
          swap(nums,left,right);
          left++;
        }
      }
      swap(nums,left,pivot);
      return left;
    }

    private  static void swap(int[] nums, int left, int right) {
      int tmp = nums[left];
      nums[left] = nums[right];
      nums[right] = tmp;
    }

}
