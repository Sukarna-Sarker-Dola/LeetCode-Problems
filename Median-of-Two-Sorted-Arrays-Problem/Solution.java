class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        if (totalLength % 2 == 0) {
            int leftMedian = findKthElement(nums1, 0, nums2, 0, totalLength / 2);
            int rightMedian = findKthElement(nums1, 0, nums2, 0, totalLength / 2 + 1);
            return (leftMedian + rightMedian) / 2.0;
        } else {
            return findKthElement(nums1, 0, nums2, 0, totalLength / 2 + 1);
        }
    }
    
    private int findKthElement(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if (start1 >= nums1.length) {
            return nums2[start2 + k - 1];
        }
        
        if (start2 >= nums2.length) {
            return nums1[start1 + k - 1];
        }
        
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        
        int mid1 = start1 + k / 2 - 1;
        int mid2 = start2 + k / 2 - 1;
        int num1 = mid1 < nums1.length ? nums1[mid1] : Integer.MAX_VALUE;
        int num2 = mid2 < nums2.length ? nums2[mid2] : Integer.MAX_VALUE;
        
        if (num1 <= num2) {
            return findKthElement(nums1, mid1 + 1, nums2, start2, k - k / 2);
        } else {
            return findKthElement(nums1, start1, nums2, mid2 + 1, k - k / 2);
        }
    }
}