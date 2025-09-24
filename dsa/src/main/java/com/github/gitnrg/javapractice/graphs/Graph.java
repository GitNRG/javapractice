package com.github.gitnrg.javapractice.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph<T> {
    private int size;
    private int[][] edges;
    private T[] data;

    public Graph(int size) {
        this.size = size;
        this.edges = new int[size][size];
        this.data = (T[]) new Object[size];
    }

    public void connect(int from, int to) {
        if (from >= 0 && from < size && to >= 0 && to < size) {
            // bidirectional connection
            // constant weights for simplicity
            edges[from][to] = 1;
            edges[to][from] = 1;
        }
    }

    public void set(int node, T value) {
        if (node >= 0 && node < size) {
            data[node] = value;
        }
    }

    public List<T> dfs(int node) {
        var visited = new boolean[size];
        var values = new ArrayList<T>();
        dfs(node, visited, values);
        return values;

    }

    private void dfs(int node, boolean[] visited, List<T> values) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        values.add(data[node]);

        for (int i = 0; i < size; i++) {
            if (edges[node][i] != 0) {
                dfs(i, visited, values);
            }
        }
    }

    public List<T> bfs(int node) {
        var visited = new boolean[size];
        var values = new ArrayList<T>();
        visited[node] = true;

        var queue = new LinkedList<Integer>();
        queue.add(node);
        while (!queue.isEmpty()) {
            var curr = queue.removeFirst();

            values.add(data[curr]);

            for (int i = 0; i < size; i++) {
                if (!visited[i] && edges[curr][i] == 1) {
                    queue.addLast(i);
                    visited[i] = true;
                }
            }
        }
        return values;
    }
}
