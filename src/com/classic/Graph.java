package com.classic;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 无向图
 */
public class Graph {
    private int v; // 顶点数
    private LinkedList<Integer> adj[]; // 邻接表

    public Graph(int v){
        this.v = v;
        adj = new LinkedList[v];
        for(int i=0; i < v; i++){
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int s, int t){
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * 宽度优先遍历
     * @param s
     * @param t
     */
    public void bfs(int s, int t){
        if(s == t)  return;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for(int i=0;i<v;i++){
            prev[i] = -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while(queue.size() != 0){
            int w = queue.poll();
            for(int i=0; i < adj[w].size();i++){
                int q = adj[w].get(i);
                if(!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    public void print(int[] prev, int s, int t){
        if(prev[t] != -1 && s != t){
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    /**
     * 深度优先遍历
     * @param s
     * @param t
     */

    boolean found = false;

    public void dfs(int s, int t){
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for(int i=0;i<v;i++){
            prev[i] = -1;
        }
        dfsCore(s,t,visited,prev);
        print(prev,s,t);
    }

    public void dfsCore(int w, int t, boolean[] visited, int[] prev){
        if(found) return ;
        visited[w] = true;
        if(w == t){
            found = true;
            return;
        }
        for(int i=0;i<adj[w].size();i++){
            int q = adj[w].get(i);
            if(!visited[q]){
                prev[q] = w;
                dfsCore(q, t, visited, prev);
            }
        }
    }
}
