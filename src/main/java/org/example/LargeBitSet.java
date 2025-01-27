package org.example;

import java.util.BitSet;
public class LargeBitSet {
    private static final int BITSET_SIZE = Integer.MAX_VALUE;
    private final BitSet[] bitSets;

    public LargeBitSet() {
        bitSets = new BitSet[] { new BitSet(BITSET_SIZE), new BitSet(BITSET_SIZE) };
    }

    public void set(final long index) {
        final int bitSetIndex = (int) (index / BITSET_SIZE);
        final int bitIndex = (int) (index % BITSET_SIZE);
        bitSets[bitSetIndex].set(bitIndex);
    }

    public int cardinality() {
        return bitSets[0].cardinality() + bitSets[1].cardinality();
    }
}