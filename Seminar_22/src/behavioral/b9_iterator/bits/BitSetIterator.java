package behavioral.b9_iterator.bits;

import java.util.BitSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BitSetIterator implements Iterator<Boolean> {

    private final BitSet bitset;
    private int index;

    public BitSetIterator(BitSet bitset) {
        this.bitset = bitset;
    }

    public boolean hasNext() {
        return index < bitset.length();
    }

    public Boolean next() {
        if (index >= bitset.length()) {
            throw new NoSuchElementException();
        }
        boolean b = bitset.get(index++);
//        return new Boolean(b); //TODO: is it good style of coding? Why?
//        return bitset.get(index++);
        return (b)? Boolean.TRUE : Boolean.FALSE;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
