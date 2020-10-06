public class 牛客旋转数组的最小数字 {
    public int minNumberInRotateArray(int [] array) {
        int left = 0, right = array.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (array[mid] > array[right]) {
                left = mid + 1;
            }else if (array[mid] < array[right]) {
                right = mid;
            }else {
                // 有重复元素时
                right--;
            }
        }

        return array[left];
    }
}
