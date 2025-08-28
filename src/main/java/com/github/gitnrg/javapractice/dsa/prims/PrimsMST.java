package com.github.gitnrg.javapractice.dsa.prims;

/**
 * Implement this interface on your own and make sure tests in PrimsMSTImplTest pass.
 * You can use {@link PrimsMSTImpl} as reference
 */
public interface PrimsMST {
    void connect(int from, int to, int weight);

    Integer[] build();
}
