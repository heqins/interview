public class 牛客统计数字在升序数组中出现的次数 {
    public int GetNumberOfK(int [] array , int k) {
        int index = search(array, 0, array.length - 1, k);

        if (index == -1) return 0;

        int left = index, right = index;
        while (left > 0 && array[left - 1] == array[index]) left--;

        while (right < array.length - 1 && array[right + 1] == array[index]) right++;

        return right - left + 1;
    }

    private int search(int[] nums, int left, int right, int target) {
        if (left > right) return - 1;

        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        }else if (nums[mid] < target) {
            return search(nums, mid + 1, right, target);
        }else{
            return search(nums, left, mid - 1, target);
        }
    }
}
