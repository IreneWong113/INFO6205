package edu.neu.coe.info6205.sort.simple;

import java.util.Arrays;

/**
 * Class to implement Shell Sort.
 *
 * @param <X> the type of element on which we will be sorting (must implement Comparable).
 */
public class ShellSort<X extends Comparable<X>> implements Sort<X> {

    /**
     * Constructor for ShellSort
     *
     * @param m the "gap" (h) sequence to follow:
     *          1: ordinary insertion sort;
     *          2: use powers of two less one;
     *          3: use the sequence based on 3 (the one in the book): 1, 4, 13, etc.
     *          4: Sedgewick's sequence (not implemented).
     * @param helper an explicit instance of Helper to be used.
     */
    public ShellSort(int m, Helper<X> helper) {
        this.m = m;
        this.helper = helper;
    }

    /**
     * Constructor for ShellSort
     *
     * @param m the "gap" (h) sequence to follow:
     *          1: ordinary insertion sort;
     *          2: use powers of two less one;
     *          3: use the sequence based on 3 (the one in the book): 1, 4, 13, etc.
     *          4: Sedgewick's sequence (not implemented).
     */
    public ShellSort(int m) {
        this(m, new Helper<>("ShellSort"));
    }

    /**
     * Method to sort a sub-array of an array of Xs.
     * <p>
     * TODO check that the treatment of from and to is correct. It seems to be according to the unit tests.
     *
     * @param xs an array of Xs to be sorted in place.
     */
    @Override
    public void sort(X[] xs, int from, int to) {
        int N = to - from;
        H hh = new H(N);
        int h = hh.first();
        while (h > 0) {
            hSort(h, xs, from, to);
            h = hh.next();
        }
    }

    @Override
    public Helper<X> getHelper() {
        return helper;
    }

    @Override
    public String toString() {
        return helper.toString();
    }

    /**
     * Private method to h-sort an array.
     * TODO use private method tester to test this
     *
     * @param h    the stride (gap) of the h-sort.
     * @param xs   the array to be sorted.
     * @param from the first index to be considered in array xs.
     * @param to   one plus the last index to be considered in array xs.
     */
    private void hSort(int h, X[] xs, int from, int to) {
        for (int i = h + from; i < to; i++)
            for (int j = i; j >= h + from && helper.less(xs[j], xs[j - h]); j -= h) {
                helper.swap(xs, from, to, j, j - h);
            }
    }

    private final int m;
    private final Helper<X> helper;

    /**
     * Private inner class to provide h (gap) values.
     */
    private class H {
        @SuppressWarnings("CanBeFinal")
        private int h = 1;
        private boolean started = false;

        H(int N) {
            switch (m) {
                case 1:
                    // TO BE IMPLEMENTED
                    break;
                case 2:
                    // TO BE IMPLEMENTED
                    break;
                case 3:
                    // TO BE IMPLEMENTED
                    break;
                default:
                    throw new RuntimeException("invalid m value: " + m);
            }
        }

        /**
         * Method to yield the first h value.
         * NOTE: this may only be called once.
         *
         * @return the first (largest) value of h, given the size of the problem (N)
         */
        int first() {
            if (started) throw new RuntimeException("cannot call first more than once");
            started = true;
            return h;
        }

        /**
         * Method to yield the next h value in the "gap" series.
         * NOTE: first must be called before next.
         *
         * @return the next value of h in the gap series.
         */
        int next() {
            if (started) {
                switch (m) {
                    case 1:
                        // TO BE IMPLEMENTED
                        return 0;
                    case 2:
                        // TO BE IMPLEMENTED
                        return 0;
                    case 3:
                        // TO BE IMPLEMENTED
                        return 0;
                    default:
                        throw new RuntimeException("invalid m value: " + m);
                }
            } else {
                started = true;
                return h;
            }
        }
    }

    /**
     * An example main program.
     * @param args the command-line args (ignored).
     */
    public static void main(String[] args) {
        ShellSort<Integer> s = new ShellSort<>(2);
        Integer[] array = {5, 3, 0, 2, 4, 1, 0, 5, 2, 3, 1, 4};
        System.out.println("Before:\t\t\t\t\t" + Arrays.toString(array));
        s.sort(array, false);
        System.out.println("After:\t\t\t\t\t" + Arrays.toString(array));
    }
}
