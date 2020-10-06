import java.util.*;


public class 牛客二分查找 {
    /**
     * 二分查找
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */

    /**
     * 请实现有重复数字的有序数组的二分查找。
     * 输出在数组中第一个大于等于查找值的位置，如果数组中不存在这样的数，则输出数组长度加一。
     * @param n
     * @param v
     * @param a
     * @return
     */
    public int upper_bound_ (int n, int v, int[] a) {
        // write code here
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (a[mid] < v) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        if(a[left]==a[right] && a[left]==v)//这个是判断如果最后一个是目标值的话，就返回正常坐标
            return left+1;
        else  return left==n-1?n+1:left+1;//判断其他情况，因为已经判断了最后一个，所以现在如果还是=n-1就说明找完了没找到，返回n+1，其他返回正常值。
    }
}