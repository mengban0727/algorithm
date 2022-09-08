package sort;

/**
 * @author zhangjie
 */
public class FindKthLargest0810 {
  public int findKthLargest(int[] nums, int k) {
    int start = 0;
    int end = nums.length-1;
    int pivot = quickSort(nums,start,end);
    while(pivot!=nums.length-k){
      if(pivot<nums.length-k){
        start = pivot+1;
        pivot = quickSort(nums,start,end);
      }else{
        end = pivot-1;
        pivot = quickSort(nums,start,end);
      }
    }
    return nums[pivot];
  }
  public int quickSort(int []nums,int start ,int end){
    int pivot = end;
    int i = 0;
    for(int j = 0; j <=end-1; j++){
      if(nums[j]>nums[pivot]){

      }else{
        swap(nums,i++,j);
      }
    }
    swap(nums,i,pivot);
    return i;
  }
  public void swap(int[] nums,int i, int j){
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  public static void main(String[] args) {
    FindKthLargest0810 test = new FindKthLargest0810();
    test.findKthLargest(new int[]{3,2,1,5,6,4},2);
  }
}
