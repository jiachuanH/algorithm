package com.hjc.geektime;

import java.util.LinkedList;

// 拓扑排序
public class KahnAlgorithm {
    private int v; // 顶点的个数
    private LinkedList<Integer> adj[]; // 邻接表

    public KahnAlgorithm(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) { // s 先于 t，边 s->t
        adj[s].add(t);
    }

    public void topoSortByKahn() {
        int[] inDegree = new int[v]; // 统计每个顶点的入度 其中 inDegree[i] 表示顶点 i 的入度。
        for (int i = 0; i < v; ++i) { // 遍历整个邻接表，将所有顶点的入度都统计出来。
            for (int j = 0; j < adj[i].size(); ++j) {
                int w = adj[i].get(j); // i->w
                inDegree[w]++;
            }
        }
        LinkedList<Integer> queue = new LinkedList<>(); // 使用队列保存所有入度为 0 的顶点。
        for (int i = 0; i < v; ++i) {
            if (inDegree[i] == 0) // 找到
                queue.add(i);
        }
        while (!queue.isEmpty()) { // 不断从队列中取出入度为 0 的顶点并进行拓扑排序。
            int i = queue.remove();
            System.out.print("->" + i);
            for (int j = 0; j < adj[i].size(); ++j) { // 遍历顶点 i 所指向的所有顶点 k。
                int k = adj[i].get(j); // 将顶点 k 的入度减 1。
                inDegree[k]--;
                if (inDegree[k] == 0) // 如果顶点 k 的入度变为了 0，就将其加入到队列中等待处理。
                    queue.add(k);
            }
        } // 时间复杂度为 O(V+E)，其中 V 和 E 分别表示有向无环图中顶点和边的数量
    }

    // DFS 算法
    public void topoSortByDFS() {
        // 先构建逆邻接表，边 s->t 表示，s 依赖于 t，t 先于 s
        LinkedList<Integer> inverseAdj[] = new LinkedList[v];
        for (int i = 0; i < v; ++i) { // 申请空间
            inverseAdj[i] = new LinkedList<>();
        }
        for (int i = 0; i < v; ++i) { // 通过邻接表生成逆邻接表
            for (int j = 0; j < adj[i].size(); ++j) {
                int w = adj[i].get(j); // i->w
                inverseAdj[w].add(i); // w->i
            }
        }
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; ++i) { // 深度优先遍历图
            if (visited[i] == false) {
                visited[i] = true;
                dfs(i, inverseAdj, visited);
            }
        }
    }

    private void dfs(
            int vertex, LinkedList<Integer> inverseAdj[], boolean[] visited) {
        for (int i = 0; i < inverseAdj[vertex].size(); ++i) {
            int w = inverseAdj[vertex].get(i);
            if (visited[w] == true)
                continue;
            visited[w] = true;
            dfs(w, inverseAdj, visited);
        } // 先把 vertex 这个顶点可达的所有顶点都打印出来之后，再打印它自己
        System.out.print("->" + vertex);
    }
}
