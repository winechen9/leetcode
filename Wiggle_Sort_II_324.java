import java.util.*;
public class Wiggle_Sort_II_324 {
    /*
    Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

    Example:
    (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
    (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

    Note:
    You may assume all input has valid answer.

    Follow Up:
    Can you do it in O(n) time and/or in-place with O(1) extra space?
     */
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] tmp = new int[nums.length];
        int len = nums.length;
        int index = 0;
        int mid = (len - 1)/2; //to keep the mid in the middle or the former part
        for(int i = 0; i <= mid; i++){
            tmp[index] = nums[mid - i];//奇数位加入中位数及左边的数
            if(index + 1 < len){
                tmp[index + 1] = nums[len - 1 - i]; //偶数位加入最后一位开始的数，这样奇数位从左到右是从大到小的前半部分的数，而偶数位则是从大到小的右半部分的数，可以保证每一个奇数位都是小于偶数位的
                //不能左边右边向中间收拢，因为这样最后两位都是中位数（如果中位数有重复的话），两个都是从大到小就既能保证大小又不会重复
            }
            index += 2;
        }
        System.arraycopy(tmp, 0, nums, 0, len);
    }

    public void wiggleSort2(int[] nums) {
        int len = nums.length;
        int median = quickSelect(nums, len / 2, 0, len - 1);
        int index = 0, left = 0, right = len - 1;
        while (index <= right) {
            if (nums[mapIdx(index, len)] > median) {
                swap(nums, mapIdx(index++, len), mapIdx(left++, len));
            } else if (nums[mapIdx(index, len)] < median) {
                swap(nums, mapIdx(index, len), mapIdx(right--, len));
            } else {
                index++;
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private int mapIdx(int index, int n) {
        return (2 * index + 1) % (n | 1);
    }
    private int quickSelect(int[] nums, int k, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int mid = start + (end - start) / 2;
        int pivot = nums[mid];
        int i = start, j = end;
        while (i <= j) {
            while (i <= j && nums[i] > pivot) {
                i++;
            }
            while (i <= j && nums[j] < pivot) {
                j--;
            }
            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        if (j - start + 1 >= k) {
            return quickSelect(nums, k, start, j);
        } else if (i - start + 1 <= k) {
            return quickSelect(nums, k - (i - start), i, end);
        }
        return pivot;
    }
}
