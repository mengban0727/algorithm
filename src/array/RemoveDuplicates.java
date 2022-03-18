package array;

class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        //已经去重后的下标
        int p = 0;
        //遍历的下标
        int q = 1;

        while (q<nums.length){
            if(nums[p]==nums[q]){
                q++;
            }else{
                nums[p+1] = nums[q];
                p++;
                q++;
            }
        }

        return p+1;

    }

    public static void main(String[] args) {
        int i = removeDuplicates(new int[]{1, 1, 2});
        System.out.println(i);
    }
}