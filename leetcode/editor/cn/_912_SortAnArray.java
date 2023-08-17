/**
  * 题目Id：912
  * 题目：排序数组
  * 日期：2023-08-16 09:52:27
*/
//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
//
// Related Topics数组 | 分治 | 桶排序 | 计数排序 | 基数排序 | 排序 | 堆（优先队列） | 归并排序 
//
// 👍 885, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode.editor.cn;

import java.util.Arrays;

public class _912_SortAnArray{
    public static void main(String[] args) {
        Solution solution = new _912_SortAnArray().new Solution();
        int[] nums = {5,2,3,1};
        int[] ints = solution.sortArray(nums);
        System.out.println(Arrays.toString(ints));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArray(int[] nums) {

        sort(nums, 0, nums.length - 1);
        return nums;
    }
    public void sort(int[] nums,int left, int right){
        int p = partition(nums, left, right);
        if (p+1 < right){
            sort(nums,p+1, right);
        }
        if (left < p-1){
            sort(nums,left,p-1);
        }

    }
    public int partition(int[] nums,int left, int right){
        int tempP = left;
        int numP = nums[tempP];
        left++;
        while (left<right){
            while (left < right && nums[left] < numP){
                //执行完后正好nums[left] >= numP
                left++;
            }
            while (left < right && nums[right] >= numP){
                //执行完后正好nums[right] < numP
                right--;
            }
            if (left >= right){
                break;
            }
            swap(nums,left,right);
        }
        swap(nums,right,right+1);
        return left;
    }

    public void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 