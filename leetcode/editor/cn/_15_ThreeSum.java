/**
 * 题目Id：15
 * 题目：三数之和
 * 日期：2023-08-14 16:27:21
 */
//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != 
//k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请 
//
// 你返回所有和为 0 且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics数组 | 双指针 | 排序 
//
// 👍 6238, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _15_ThreeSum {
    public static void main(String[] args) {
        Solution solution = new _15_ThreeSum().new Solution();
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = solution.threeSum(nums);
        System.out.println(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            LinkedList<List<Integer>> lists = new LinkedList<>();
            dp(nums, 3, 0, 0, new ArrayList<>(), lists);
            return lists;
        }

        public void dp(int[] nums, int k, int sum, int acc, List<Integer> arrays, LinkedList<List<Integer>> lists) {
            sum += nums[acc];
            arrays.add(nums[acc]);
            if (k == 1) {
                if (sum == 0) {
                    //输出数组
                    ArrayList<Integer> arraysClone = new ArrayList<>(arrays);
                    lists.add(arraysClone);
                } else {
                    return;
                }
            } else {
                while (acc < nums.length - 1) {
                    dp(nums, --k, sum, acc + 1, arrays, lists);
                    k++;
                    acc++;
                    arrays.remove(arrays.size() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

} 