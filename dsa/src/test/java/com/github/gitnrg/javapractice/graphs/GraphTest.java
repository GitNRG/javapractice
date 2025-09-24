package com.github.gitnrg.javapractice.graphs;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphTest {

    // todo not finished
    @Test
    void testX() {
        var graph = new Graph<>(7);
        graph.set(0, "A");
        graph.set(1, "B");
        graph.set(2, "C");
        graph.set(3, "D");
        graph.set(4, "E");
        graph.set(5, "F");
        graph.set(6, "G");
        graph.connect(0,3); // AD
        graph.connect(0,4); // AE
        graph.connect(0,2); // AC
        graph.connect(2,4); // CE
        graph.connect(2,1); // CB
        graph.connect(2,6); // CG
        graph.connect(2,5); // CF
        graph.connect(1,5); // BF


        var result = graph.dfs(3); // D

        assertEquals(List.of("D", "A", "C", "B", "F", "E", "G"), result);
    }

    @Test
    void testY() {
        var graph = new Graph<>(7);
        graph.set(0, "A");
        graph.set(1, "B");
        graph.set(2, "C");
        graph.set(3, "D");
        graph.set(4, "E");
        graph.set(5, "F");
        graph.set(6, "G");
        graph.connect(0,3); // AD
        graph.connect(0,4); // AE
        graph.connect(0,2); // AC
        graph.connect(2,4); // CE
        graph.connect(2,1); // CB
        graph.connect(2,6); // CG
        graph.connect(2,5); // CF
        graph.connect(1,5); // BF


        var result = graph.bfs(3); // D

        assertEquals(List.of("D", "A", "C", "E", "B", "F", "G"), result);
    }
}