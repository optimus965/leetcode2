class Solution {
    public long minimumCost(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long count1 = 0;
        long count2 = 0;
        int value = nums[n / 2];
        int value1 = smallPalindrome(value);
        int value2 = greaterPalindrome(value);
        for (int i = 0; i < nums.length; i++) {
            count1 = count1 + (int) Math.abs(value1 - nums[i]);
            count2 = count2 + (int) Math.abs(value2 - nums[i]);
        }
        long count = Math.min(count1, count2);
        return count;
    }

    public int smallPalindrome(int n) {
        while (true) {
            if (isPalindrome(n)) {
                return n;
            }
            n++;
        }
    }
    public int greaterPalindrome(int n) {
        while (true) {
            if (isPalindrome(n)) {
                return n;
            }
            n--;
        }
    }
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;
        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x = x / 10;
        }
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
// we have to make the array equalindromic
// which mean every element should be one
// find the minimum cost 
// we have to find the one palindromic number which minimizes the total cost
