package general;

public class BinarySearch {

    static int search(int s, int e, int nums[], int target) {
        int m = s + (e - s) / 2;

        if (s > e) {
            return -1;
        }

        if (nums[m] == target) {
            return m;
        } else if (nums[m] < target) {
            return search(m + 1, e, nums, target);
        } else {
            return search(s, m - 1, nums, target);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 6, 7, 8, 9, 10};
        int result = search(0, nums.length - 1, nums, 10);
        System.out.println(result);

    }
}
