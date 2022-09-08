package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author zhangjie
 */
public class CalcEquation {

  public double[] calcEquation(List<List<String>> equations, double[] values,
      List<List<String>> queries) {
    int equationsSize = equations.size();

    UnionFind unionFind = new UnionFind(2 * equationsSize);
    // 第 1 步：预处理，将变量的值与 id 进行映射，使得并查集的底层使用数组实现，方便编码
    Map<String, Integer> hashMap = new HashMap<>(2 * equationsSize);
    int id = 0;
    for (int i = 0; i < equationsSize; i++) {
      List<String> equation = equations.get(i);
      String var1 = equation.get(0);
      String var2 = equation.get(1);

      if (!hashMap.containsKey(var1)) {
        hashMap.put(var1, id);
        id++;
      }
      if (!hashMap.containsKey(var2)) {
        hashMap.put(var2, id);
        id++;
      }
      unionFind.union(hashMap.get(var1), hashMap.get(var2), values[i]);
    }

    // 第 2 步：做查询
    int queriesSize = queries.size();
    double[] res = new double[queriesSize];
    for (int i = 0; i < queriesSize; i++) {
      String var1 = queries.get(i).get(0);
      String var2 = queries.get(i).get(1);

      Integer id1 = hashMap.get(var1);
      Integer id2 = hashMap.get(var2);

      if (id1 == null || id2 == null) {
        res[i] = -1.0d;
      } else {
        res[i] = unionFind.isConnected(id1, id2);
      }
    }
    return res;
  }

  private class UnionFind {

    private int[] parent;

    /**
     * 指向的父结点的权值
     */
    private double[] weight;


    public UnionFind(int n) {
      this.parent = new int[n];
      this.weight = new double[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
        weight[i] = 1.0d;
      }
    }

    public void union(int x, int y, double value) {
      int rootX = find(x);
      int rootY = find(y);
      if (rootX == rootY) {
        return;
      }

      parent[rootX] = rootY;
      // 关系式的推导请见「参考代码」下方的示意图
      weight[rootX] = weight[y] * value / weight[x];
    }

    /**
     * 路径压缩
     *
     * @return 根结点的 id
     */
    public int find(int x) {
      if (x != parent[x]) {
        int origin = parent[x];
        parent[x] = find(parent[x]);
        weight[x] *= weight[origin];
      }
      return parent[x];
    }

    public double isConnected(int x, int y) {
      int rootX = find(x);
      int rootY = find(y);
      if (rootX == rootY) {
        return weight[x] / weight[y];
      } else {
        return -1.0d;
      }
    }
  }

  public static void main(String[] args) {
    /**
     * equations = [["a","b"],["b","c"]],
     * values = [2.0,3.0],
     * queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
     */

    CalcEquation calcEquation = new CalcEquation();
    List<List<String>> equations = new ArrayList<>();
    equations.add(Arrays.asList("a", "b"));
    equations.add(Arrays.asList("b", "c"));
    double[] values = new double[]{2.0, 3.0};

    List<List<String>> queries = new ArrayList<>();
    queries.add(Arrays.asList("a", "c"));
    queries.add(Arrays.asList("b", "a"));
    queries.add(Arrays.asList("a", "e"));
    queries.add(Arrays.asList("a", "a"));
    queries.add(Arrays.asList("x", "x"));
    double[] doubles = calcEquation.calcEquation(equations, values, queries);

    System.out.println(Arrays.toString(doubles));
  }


}
