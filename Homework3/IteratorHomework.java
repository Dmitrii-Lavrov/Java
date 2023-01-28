package Homework3;
import java.util.Iterator;

public class IteratorHomework {

    public static void main(String[] args) {
        
        int[] source = {1, 2, 3, 4, 5, 6, 7};

        Iterator<Integer> intArrayIterator = new IntArrayIterator(source);
        while (intArrayIterator.hasNext()) {            
            System.out.println(intArrayIterator.next());            
        }
    }    

    private static class IntArrayIterator implements Iterator<Integer> {

        private final int[] source;
        public int i = 0;

        public IntArrayIterator(int[] source) {
            this.source = source;
        }

        @Override
        public boolean hasNext() {            
            return i <= source.length - 1;
        }

        @Override
        public Integer next() {            
            return source[i++];
        }
    }
}


