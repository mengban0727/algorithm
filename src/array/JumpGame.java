package array;

/**
 * 跳跃游戏 https://leetcode.cn/problems/jump-game/
 */
class JumpGame {

  //跳跃游戏1
  public static boolean jump3(int[] nums) {
    //能跳到的最大位置，贪心
    int maxPosition = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i <= maxPosition) {
        maxPosition = Math.max(maxPosition, i + nums[i]);
        if (maxPosition >= nums.length - 1) {
          return true;
        }
      }
    }
    return false;
  }
}