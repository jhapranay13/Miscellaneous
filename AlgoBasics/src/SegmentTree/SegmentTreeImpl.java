package SegmentTree;

public class SegmentTreeImpl {
    int n;
    int[] cache;
    int[] arr;

    public SegmentTreeImpl(int[] arr, int n) {
        this.n = n;
        int logCalculation = (int)(Math.ceil(Math.log(n) / Math.log(2)));
        int size = 2 * (int)Math.pow(2, logCalculation) - 1;
        cache = new int[size];
        buildSegmentTree(arr, 0, n - 1, 0);
        this.arr = arr;
    }

    private int buildSegmentTree(int[] arr, int lo, int hi, int treeIndex) {

        if(lo == hi) {
            cache[treeIndex] = arr[lo];
            return arr[lo];
        }
        int pivot = lo + (hi - lo) / 2;
        cache[treeIndex] = buildSegmentTree(arr, lo, pivot, 2 * treeIndex + 1) +
                buildSegmentTree(arr, pivot + 1, hi, 2 * treeIndex + 2);
        return cache[treeIndex];
    }

    public int getSum(int lo, int hi) {

        if (lo < 0 || hi > n - 1 || lo > hi) {
            System.out.println("Invalid Input");
            return -1;
        }
        return getSum(0, n - 1, lo, hi, 0);
    }

    private int getSum(int lo, int hi, int qlo, int qhi, int treeIndex) {

        if (lo >= qlo && hi <= qhi) {
            return cache[treeIndex];
        }

        if (hi < qlo || lo > qhi) {
            return 0;
        }
        int pivot = lo + (hi - lo) / 2;
        return getSum(lo, pivot, qlo, qhi, treeIndex * 2 + 1) +
                getSum(pivot + 1, hi, qlo, qhi, treeIndex * 2 + 2);
    }

    private void update(int index, int val) {

        if (index < 0 || index > n - 1) {
            System.out.println("Invalid Input");
            return;
        }
        int diff =  val - arr[index];
        arr[index] = val;
        update(0, n - 1, diff, index, 0);
    }

    private void update(int lo, int hi, int diff, int index, int treeIndex) {

        if (index < lo || index > hi) {
            return;
        }
        cache[treeIndex] += diff;

        if (lo != hi) {
            int pivot = lo + (hi - lo) / 2;
            update(lo, pivot, diff, index, treeIndex * 2 + 1);
            update(pivot + 1, hi, diff, index, treeIndex * 2 + 2);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 7, 9, 11};
        int n = arr.length;
        SegmentTreeImpl tree = new SegmentTreeImpl(arr, n);
        System.out.println("Sum of values in given range = " +
                tree.getSum(1, 3));
        tree.update(1, 10);

        // Find sum after the value is updated
        System.out.println("Updated sum of values in given range = " +
                tree.getSum(1, 3));
    }
}
