package interview.sort;

import java.util.Arrays;

public class heap {
    /**
     * 思路：堆排序使用到了完全二叉树的一个特性，根节点比左孩子和右孩子都要大，完成一次建堆的操作实质上是比较根节点和左孩子、右孩子的大小，
     * 大的交换到根节点上，直至最大的节点在树顶。随后与数组最后一位元素进行交换
     * 代码实现：只要左子树或右子树大于当前根节点，则替换。替换后会导致下面的子树发生了变化，因此同样需要进行比较，直至各个节点实现父>子这么一个条件
     * @param args
     */
    public static void main(String[] args) {
        int[] arrays = {-2, 3, -5, 3945, 23124, -20321};

        // 完成一次建堆
        maxHeapify(arrays, arrays.length - 1);
        int size = arrays.length - 1;

        for (int i = 0; i < arrays.length; i++) {
            // 交换
            int temp = arrays[0];
            arrays[0] = arrays[arrays.length - 1 - i];
            arrays[arrays.length - 1 - i] = temp;

            // 调整位置
            heapify(arrays, 0, size);
            size--;
        }

        System.out.println(Arrays.toString(arrays));
    }

    public static void maxHeapify(int[] arrays, int size) {
        for (int i = size - 1; i >= 0; i--) {
            heapify(arrays, i, size);
        }
    }

    public static void heapify(int[] arrays, int currentRootNode, int size) {
        if (currentRootNode < size) {
            // 左子树和右子树的位置
            int left = 2 * currentRootNode + 1;
            int right = 2 * currentRootNode + 2;

            // 把当前父节点看成是最大的
            int max = currentRootNode;

            if (left < size) {
                // 如果比当前根元素要大，记录它的位置
                if (arrays[max] < arrays[left]) {
                    max = left;
                }
            }

            if (right < size) {
                if (arrays[max] < arrays[right]) {
                    max = right;
                }
            }

            // 如果最大的不是根元素位置，那么就交换
            if (max != currentRootNode) {
                int temp = arrays[max];
                arrays[max] = arrays[currentRootNode];
                arrays[currentRootNode] = temp;

                // 继续比较，直到完成一次建堆
                heapify(arrays, max, size);
            }
        }
    }
}
