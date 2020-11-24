package com.cvccy.array;

/**
 * @time 20201124
 * @author hfxie
 * @section 给定两个大小为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的中位数。
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 */
public class MedianOfTwoSortedArrays {

    public Solution solution;

    public MedianOfTwoSortedArrays(Solution solution) {
        this.solution = solution;
    }

    public static void main(String[] args) {

        int[] nums1 = new int[]{1,3,4,5};
        int[] nums2 = new int[]{2,3,6,7};
        MedianOfTwoSortedArrays median = new MedianOfTwoSortedArrays(new MergeBeforMedian());
        System.out.println(median.solution.findMedianSortedArrays(nums1, nums2));

    }
}


interface Solution {
    double findMedianSortedArrays(int[] nums1, int[] nums2);
}

/**
 * 将两个数组合并后取中值
 */
class MergeBeforMedian implements Solution {

    @Override
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        int len = nums1Length + nums2Length;
        int[] merge = new int[len];
        int i = 0, j = 0,k = 0;
        if (nums1Length == 0) {
            if ((len & 1) == 0) {
                return (nums2[len >> 1] + nums2[(len >> 1) + 1]) / 2.0;
            } else {
                return nums2[(len >> 1) + 1];
            }
        }
        if (nums2Length == 0) {
            if ((len & 1) == 0) {
                return (nums1[len >> 1] + nums1[(len >> 1) + 1]) / 2.0;
            } else {
                return nums1[(len >> 1) + 1];
            }
        }
        while (k != len) {
            if (i == nums1Length) {
                while (j != nums2Length) {
                    merge[k++] = nums2[j++];
                }
                break;
            }
            if (j == nums2Length) {
                while (i != nums1Length) {
                    merge[k++] = nums1[i++];
                }
                break;
            }
            if (nums1[i] > nums2[j]) {
                merge[k++] = nums2[j++];
            } else {
                merge[k++] = nums1[i++];
            }

        }
        if ((len & 1) == 0) {
            return (merge[len >> 1] + merge[(len >> 1) + 1]) / 2.0;
        } else {
            return merge[(len >> 1) + 1];
        }
    }
}