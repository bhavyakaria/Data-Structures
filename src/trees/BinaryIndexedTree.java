/***
 * A Fenwick tree or binary indexed tree is a data structure providing efficient methods
 * for calculation and manipulation of the prefix sums of a table of values.
 *
 * Space complexity for fenwick tree is O(n)
 * Time complexity to create fenwick tree is O(nlogn)
 * Time complexity to update value is O(logn)
 * Time complexity to get prefix sum is O(logn)
 *
 * References
 * http://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/
 * https://www.topcoder.com/community/data-science/data-science-tutorials/binary-indexed-trees/
 * http://en.wikipedia.org/wiki/Fenwick_tree
 */
package trees;

import java.util.Arrays;

/**
 *
 * @author Parzival
 */
public class BinaryIndexedTree {
    
    final static int MAX = 1000;
    final static int BITree[] = new int[MAX];

    public static void main(String[] args) {

        int freq[] = {2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = freq.length;

        BinaryIndexedTree tree = new BinaryIndexedTree();

        tree.constructBITree(freq,n);

        System.out.println("Sum:"+getSum(BITree,5));

    }

    private void constructBITree(int[] arr, int n) {
        Arrays.fill(BITree,0);
        for (int i = 0; i < n; i++) {
            updateBIT(n,i,arr[i]);
        }
    }

    /** Root node is always the dummy node hence index+1 **/
    private void updateBIT(int n, int index, int val) {
        index = index + 1;

        while(index <= n) {
            BITree[index] += val;
            index += index & (-index);
        }
    }

    /** Add all its parent node along with itself **/
    /**
     * To get parent
     * 1) 2's complement to get minus of index
     * 2) AND this with index
     * 3) Subtract that from index
     */
    private static int getSum(int[] biTree, int index) {
        int sum = 0;
        index = index + 1;

        while(index > 0) {
            sum += BITree[index];

            index -= index & (-index);
        }
        return sum;
    }
    
}
