public class 在排序数组中查找数字1 {
    private int count = 0;
    public int search(int[] nums, int target) {
        // 统计一个数字在排序数组中出现的次数
        helper(nums, target, 0, nums.length - 1);

        return count;
    }

    public void helper(int[] nums, int target, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                count++;
                helper(nums, target, left, mid - 1);
                helper(nums, target, mid + 1, right);
            }else if (nums[mid] < target) {
                helper(nums, target, mid + 1, right);
            }else {
                helper(nums, target, left, mid - 1);
            }
        }
    }
}
