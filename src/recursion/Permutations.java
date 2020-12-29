package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * n个数的全排列
 *
 * @author zhangjie
 */
public class Permutations {

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    int len = nums.length;
    if (len == 0) {
      return result;
    }

    //设置一个保存数字是否使用状态的数组
    boolean[] used = new boolean[len];
    //单个排列
    List<Integer> path = new ArrayList<>();
    dfs(nums, len, 0, path, used, result);

    return result;
  }

  /**
   * 深度优先遍历，回溯
   *
   * @param nums 输入的n个数
   * @param len 又多少个数
   * @param depth 当前遍历的深度
   * @param path 一条路径，也就是一种排列的集合
   * @param used 每个数字在当前路径是否使用
   * @param result 总的排列数量
   */
  private void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] used,
      List<List<Integer>> result) {
    //如果深度与个数相同，则走完了树的路径，得到一种排列,将当前路径放入结果集中
    if (len == depth) {
      //注意，需要新的一个list，否则结果输出为空，因为回到根节点的时候，path为空，而result存的都是同一个path也就是同一个list的引用
      result.add(new ArrayList<>(path));
      return;
    }

    //第n层（每一层）从没有使用的数中选出一个作为根节点
    for (int i = 0; i < len; i++) {
      //判断当前是否使用，没有使用，则加入path，然后递归进入下一层继续从未选择的数中选出一个数，直到len=depth
      if (!used[i]) {
        used[i] = true;
        path.add(nums[i]);
        dfs(nums, len, depth + 1, path, used, result);

        //第n层走完一条路径，需要重新走另一条路径，此时需要将之前做过的那条路径进行状态重置即将它设置未使用
        used[i] = false;
        path.remove(path.size() - 1);
      }
    }
  }


}
