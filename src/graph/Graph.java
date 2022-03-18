package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhangjie
 */
public class Graph {

  boolean found = false;
  /**
   * 顶点的个数
   */
  private int v;
  /**
   * 邻接表
   */
  private LinkedList<Integer> adj[];

  public Graph(int v) {
    this.v = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; ++i) {
      adj[i] = new LinkedList<>();
    }
  }

  /**
   * 无向图一条边存两次
   */
  public void addEdge(int s, int t) {
    adj[s].add(t);
    adj[t].add(s);
  }

  public void bfs(int s, int t) {
    if (s == t) {
      return;
    }

    boolean[] visited = new boolean[v];
    visited[s] = true;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(s);

    int[] pre = new int[v];
    for (int i = 0; i < v; i++) {
      pre[i] = -1;
    }

    while (!queue.isEmpty()) {
      int w = queue.poll();
      for (int i = 0; i < adj[w].size(); i++) {
        int q = adj[w].get(i);
        if (!visited[q]) {
          pre[q] = w;
          if (q == t) {
            print(pre, s, t);
            return;
          }
          visited[q] = true;
          queue.add(q);
        }
      }
    }
  }

  // 递归打印s->t的路径
  private void print(int[] prev, int s, int t) {
    if (prev[t] != -1 && t != s) {
      print(prev, s, prev[t]);
    }
    System.out.print(t + " ");
  }

  public void dfs(int s, int t) {
    found = false;
    if (s == t) {
      return;
    }

    boolean[] visited = new boolean[v];
    int[] pre = new int[v];
    for (int i = 0; i < v; i++) {
      pre[i] = -1;
    }

    //递归查找
    recurDfs(s, t, visited, pre);

    //打印
    print(pre, s, t);

  }

  private void recurDfs(int w, int t, boolean[] visited, int[] pre) {
    if (found) {
      return;
    }

    visited[w] = true;
    if (w == t) {
      found = true;
      return;
    }

    for (int i = 0; i < adj[w].size(); i++) {
      int q = adj[w].get(i);
      if (!visited[q]) {
        pre[q] = w;
        recurDfs(q, t, visited, pre);
      }
    }
  }

}

