////给你一个字符串 s，找到 s 中最长的回文子串。 
////
//// 
////
//// 示例 1： 
////
//// 
////输入：s = "babad"
////输出："bab"
////解释："aba" 同样是符合题意的答案。
//// 
////
//// 示例 2： 
////
//// 
////输入：s = "cbbd"
////输出："bb"
//// 
////
//// 示例 3： 
////
//// 
////输入：s = "a"
////输出："a"
//// 
////
//// 示例 4： 
////
//// 
////输入：s = "ac"
////输出："a"
//// 
////
//// 
////
//// 提示： 
////
//// 
//// 1 <= s.length <= 1000 
//// s 仅由数字和英文字母（大写和/或小写）组成 
//// 
//// Related Topics 字符串 动态规划 👍 4624 👎 0
//


package leetcode.editor.cn;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            String s3 = "";
            String max = "";
            for (int i = 0; i < s.length(); i++) {
                String s1 = getPalindrome(s, i, i);
                String s2 = getPalindrome(s, i, i + 1);
                s3 = s1.length() > s2.length() ? s1 : s2;
                max = s3.length() > max.length() ? s3 : max;
            }
            return max;
        }

        public String getPalindrome(String str, int l, int h) {
            while (l >= 0 && h < str.length() && str.charAt(l) == str.charAt(h)) {
                l--;
                h++;
            }
            return str.substring(l +1, h);//substring的第二个参数为结束位的下一个，例如hello，取substring（1,2）为e   substring(1,3)为el
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}