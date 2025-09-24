package com.github.gitnrg.javapractice.prims;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class PrimsMSTImplTest {

    private PrimsMST buildEmptyGraph(int size) {
        return new PrimsMSTImpl<String>(size); // use your implementation here
    }

    @Test
    void testEmptyGraph() {
        var graph = buildEmptyGraph(0);

        var mst = graph.build();

        assertArrayEquals(new Integer[0], mst);
    }

    @Test
    void testGraphWithSingeNode() {
        var graph = buildEmptyGraph(1);

        var mst = graph.build();

        assertArrayEquals(new Integer[]{-1}, mst);
    }

    @Test
    void testGraphMinimalNotConnectedGraph() {
        var graph = buildEmptyGraph(2);

        var mst = graph.build();

        assertArrayEquals(new Integer[]{-1, null}, mst);
    }

    @Test
    void testGraphMinimalConnectedGraph() {
        var graph = buildEmptyGraph(2);
        graph.connect(0, 1, 1);

        var mst = graph.build();

        assertArrayEquals(new Integer[]{-1, 0}, mst);
    }

    @Test
    void testGraphThatFormsChain() {
        var graph = buildEmptyGraph(3);
        graph.connect(0, 1, 1);
        graph.connect(1, 2, 1);

        var mst = graph.build();

        assertArrayEquals(new Integer[]{-1, 0, 1}, mst);
    }

    @Test
    void testGraphWithDifferentWeights() {
        var graph = buildEmptyGraph(3);
        graph.connect(0, 1, 1);
        graph.connect(0, 2, 2);

        var mst = graph.build();

        assertArrayEquals(new Integer[]{-1, 0, 0}, mst);
    }

    @Test
    void testGraphWithNegativeWeights() {
        var graph = buildEmptyGraph(3);
        graph.connect(0, 1, -2);
        graph.connect(0, 2, -1);

        var mst = graph.build();

        assertArrayEquals(new Integer[]{-1, 0, 0}, mst);
    }

    @Test
    void testGraphWithZeroWeights() {
        var graph = buildEmptyGraph(3);
        graph.connect(0, 1, 0);
        graph.connect(0, 2, 0);

        var mst = graph.build();

        assertArrayEquals(new Integer[]{-1, 0, 0}, mst);
    }

    @Test
    void testGraphWithLoop() {
        var graph = buildEmptyGraph(3);
        graph.connect(0, 1, 1);
        graph.connect(1, 2, 1);
        graph.connect(2, 0, 1);

        var mst = graph.build();

        assertArrayEquals(new Integer[]{-1, 0, 0}, mst);
    }

    @Test
    void testGraphIsMinimal() {
        var graph1 = buildEmptyGraph(3);
        graph1.connect(0, 1, 1);
        graph1.connect(0, 2, 1);
        graph1.connect(1, 2, 9);
        var mst1 = graph1.build();

        var graph2 = buildEmptyGraph(3);
        graph2.connect(0, 1, 1);
        graph2.connect(0, 2, 9);
        graph2.connect(1, 2, 1);
        var mst2 = graph2.build();

        assertArrayEquals(new Integer[]{-1, 0, 0}, mst1);
        assertArrayEquals(new Integer[]{-1, 0, 1}, mst2);
    }

    @Test
    void testGraphWithSelfRef() {
        var graph = buildEmptyGraph(3);
        graph.connect(0, 0, 1);
        graph.connect(1, 1, 1);
        graph.connect(2, 2, 1);
        graph.connect(0, 1, 9);
        graph.connect(2, 0, 9);
        var mst = graph.build();

        assertArrayEquals(new Integer[]{-1, 0, 0}, mst);
    }

    @Test
    void testGraphWithEqualPaths() {
        var graph = buildEmptyGraph(4);
        graph.connect(0, 1, 1);
        graph.connect(0, 2, 1);
        graph.connect(1, 3, 1);
        graph.connect(2, 3, 1);
        var mst = graph.build();

        assertArrayEquals(new Integer[]{-1, 0, 0, 1}, mst);
    }
}