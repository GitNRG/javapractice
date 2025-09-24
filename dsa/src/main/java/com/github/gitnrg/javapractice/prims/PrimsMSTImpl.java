package com.github.gitnrg.javapractice.prims;

public class PrimsMSTImpl<T> implements PrimsMST {
    private final int size;
    private final Integer[][] edges;

    public PrimsMSTImpl(int size) {
        this.size = size;
        this.edges = new Integer[size][size];
    }

    @Override
    public void connect(int from, int to, int weight) {
        if (from >= 0 && from < size && to >= 0 && to < size) {
            edges[from][to] = weight;
            edges[to][from] = weight;
        }
    }

    @Override
    public Integer[] build() {
        if (size == 0) {
            return new Integer[0];
        }

        var nodesInMST = new Boolean[size];
        var minAdjEdge = new Integer[size];
        var parents = new Integer[size];
        for (int i = 0; i < size; i++) {
            nodesInMST[i] = false;
            minAdjEdge[i] = Integer.MAX_VALUE;
            parents[i] = null;
        }

        parents[0] = -1; // root node
        minAdjEdge[0] = 0; // to make algorithm start from this mode

        // N nodes need N-1 edges, so use size - 1
        for (int edgeCounter = 0; edgeCounter < size - 1; edgeCounter++) {
            int nextNode = -1;
            int minEdge = Integer.MAX_VALUE;
            for (int j = 0; j < size; j++) {
                if (!nodesInMST[j] && minAdjEdge[j] < minEdge) {
                    nextNode = j;
                    minEdge = minAdjEdge[j];
                }
            }
            if (nextNode == -1) {
                break; // not all vertices are connected, error might be preferable for some cases
            }
            nodesInMST[nextNode] = true;

            for (int j = 0; j < size; j++) {
                // if next node is not in MST - !nodesInMST[j]
                // and is connected to the node we've just added - edges[nextNode][j] != null
                // and this edge is lighter than prev one - edges[nextNode][j] < minAdjEdge[j]
                // make curr node it's parent
                if (!nodesInMST[j] && edges[nextNode][j] != null && edges[nextNode][j] < minAdjEdge[j]) {
                    parents[j] = nextNode;
                    minAdjEdge[j] = edges[nextNode][j];
                }
            }
        }
        return parents;
    }
}
