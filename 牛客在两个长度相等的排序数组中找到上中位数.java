public class 牛客在两个长度相等的排序数组中找到上中位数 {
    // LeetCode版本
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//
//        if (nums1.length > nums2.length) {
//            return findMedianSortedArrays(nums2, nums1);
//        }
//
//        int len1 = nums1.length;
//        int len2 = nums2.length;
//
//        // 分别定义了partition1取值的上下限
//        int low = 0;
//        int high = nums1.length;
//
//        while (low <= high) {
//
//            int partition1 = (low + high) / 2;
//            int partition2 = (len1 + len2 + 1) / 2 - partition1;
//
//            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
//            int minRight1 = (partition1 == len1) ? Integer.MAX_VALUE : nums1[partition1];
//
//            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
//            int minRight2 = (partition2 == len2) ? Integer.MAX_VALUE : nums2[partition2];
//
//            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
//                // 若找到符合条件的分割,则直接返回
//                if ((len1 + len2) % 2 == 0) {
//                    return ((double) Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2;
//                } else {
//                    return (double) Math.max(maxLeft1, maxLeft2);
//                }
//            } else if (maxLeft1 > minRight2) {
//                // partiton1太靠右了,将区间向左倾斜
//                high = partition1 - 1;
//            } else {
//                // partition1太靠左了,将区间向右倾斜
//                low = partition1 + 1;
//            }
//        }
//
//        throw new IllegalArgumentException();
//    }

    public int findMedianinTwoSortedAray (int[] arr1, int[] arr2) {
        // write code here
        if (arr1 == null || arr2 == null) {
            return -1;
        }
        int l1 = 0;
        int r1 = arr1.length - 1;
        int l2 = 0;
        int r2 = arr2.length - 1;
        int mid1 = 0;
        int mid2 = 0;
        int offset = 0;
        while (l1 < r1) {
            mid1 = l1 + (r1 - l1) / 2;
            mid2 = l2 + (r2 - l2) / 2;
            offset = ((r1 - l1 + 1) & 1)^1;
            if (arr1[mid1] < arr2[mid2]) {
                l1 = mid1 + offset;
                r2 = mid2;
            } else if (arr1[mid1] > arr2[mid2]) {
                r1 = mid1;
                l2 = mid2 + offset;
            } else {
                return arr2[mid1];
            }
        }
        return Math.min(arr1[l1], arr2[l2]);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 8, 9, 15};
        int[] nums2 = {7, 11, 19, 21, 23, 25};

    }
}
