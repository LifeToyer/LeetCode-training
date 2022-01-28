//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 6822 👎 0


package leetcode.editor.cn;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        String s = "abcabcbb";
        System.out.println(solution.lengthOfLongestSubstring(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {//双指针解决问题

        public int lengthOfLongestSubstring(String s) {
            HashMap<Object, Integer> map = new HashMap<>();
            int max = 0;
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), 0);
            }
            int j = 0;
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                //如果指针i扫描到重复字符，则将指针j向前移动，收缩窗口
                while (map.get(s.charAt(i)) > 1 && j < i) {
                    map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                    j++;
                }

                max = Math.max(max, i - j + 1);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}