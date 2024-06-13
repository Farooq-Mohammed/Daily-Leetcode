public class SortColors {
/*
    Given an array nums with n objects colored red, white, or blue, sort them in-place
    so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

    We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
    You must solve this problem without using the library's sort function.

    Example 1:
    Input: nums = [2,0,2,1,1,0]
    Output: [0,0,1,1,2,2]

    Example 2:
    Input: nums = [2,0,1]
    Output: [0,1,2]

    Constraints:
        n == nums.length
        1 <= n <= 300
        nums[i] is either 0, 1, or 2.

    Follow up: Could you come up with a one-pass algorithm using only constant extra space?
*/
    public void sortColors(int[] nums) { // Time complexity - O(N*N)
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++)
                if(nums[i] > nums[j])
                    swap(nums, i, j);
        }
    }

    public void swap(int[] ar, int a, int b) {
        ar[a] = ar[a] ^ ar[b] ^ (ar[b] = ar[a]);
    }

    public void sortColors2(int [] nums) { // Time complexity - O(N)
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while(mid <= high) {
            if(nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if(nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }
}
