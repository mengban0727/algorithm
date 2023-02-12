package dp;

/**
 * 找零问题
 *
 * @author zhangjie
 */
public class LeastCoins {

  public static int countMoneyMin(int[] moneyItems, int resultMemory) {

    if (null == moneyItems || moneyItems.length < 1) {
      return -1;
    }

    if (resultMemory < 1) {
      return -1;
    }

    // 计算遍历的层数，此按最小金额来支付即为最大层数
    int levelNum = resultMemory / moneyItems[0];
    int leng = moneyItems.length;

    int[][] status = new int[levelNum][resultMemory + 1];

    // 初始化状态数组
    for (int i = 0; i < levelNum; i++) {
      for (int j = 0; j < resultMemory + 1; j++) {
        status[i][j] = -1;
      }
    }

    // 将第一层的数数据填充
    for (int i = 0; i < leng; i++) {
      status[0][moneyItems[i]] = moneyItems[i];
    }

    int minNum = -1;

    // 计算推导状态
    for (int i = 1; i < levelNum; i++) {
      // 推导出当前状态
      for (int j = 0; j < resultMemory; j++) {
        if (status[i - 1][j] != -1) {
          // 遍历元素,进行累加
          for (int k = 0; k < leng; k++) {
            if (j + moneyItems[k] <= resultMemory) {
              status[i][j + moneyItems[k]] = moneyItems[k];
            }
          }
        }

        // 找到最小的张数
        if (status[i][resultMemory] >= 0) {
          minNum = i + 1;
          break;
        }
      }

      if (minNum > 0) {
        break;
      }
    }

    int befValue = resultMemory;

    // 进行反推出，币的组合
    for (int i = minNum - 1; i >= 0; i--) {
      for (int j = resultMemory; j >= 0; j--) {
        if (j == befValue) {
          System.out.println("当前的为:" + status[i][j]);
          befValue = befValue - status[i][j];
          break;
        }
      }
    }

    return minNum;
  }

  public static void main(String[] args) {
    countMoneyMin(new int[]{1, 3, 5}, 23);
  }
}
