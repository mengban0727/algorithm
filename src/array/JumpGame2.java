package array;

/**
 * 跳跃游戏 https://leetcode.cn/problems/jump-game-ii
 *
 * https://leetcode.cn/problems/jump-game-ii/solutions/9347/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-10/?orderBy=most_votes
 */
class JumpGame2 {

  //从前往后贪
  public int jump1(int[] nums) {
    int maxPosition = 0;
    int step = 0;
    int lastPosition = 0;
    for(int i = 0; i < nums.length-1; i++){
      maxPosition = Math.max(maxPosition,i+nums[i]);
      if(i==lastPosition){
        lastPosition = maxPosition;
        step++;
      }
    }
    return step;
  }

  //从后往前贪
  public int jump2(int[] nums) {
    int lastPosition = nums.length-1;
    int step=0;
    while(lastPosition>0){
      for(int i = 0; i < lastPosition; i++){
        if(nums[i]+i>=lastPosition){
          step++;
          lastPosition = i;
          break;
        }
      }
    }
    return step;
  }


}