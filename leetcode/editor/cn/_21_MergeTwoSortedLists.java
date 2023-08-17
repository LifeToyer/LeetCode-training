/**
 * 题目Id：21
 * 题目：合并两个有序链表
 * 日期：2023-08-16 14:52:15
 */
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
//
// Related Topics递归 | 链表 
//
// 👍 3241, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

package leetcode.editor.cn;

import leetcode.editor.cn.util.ListNode;

public class _21_MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new _21_MergeTwoSortedLists().new Solution();
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode listNode = solution.mergeTwoLists(list1, list2);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode newHead = new ListNode();
            ListNode newHeadHead = new ListNode();
            newHeadHead.next = newHead;
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    newHead.next = list1;
                    list1 = list1.next;
                } else {
                    newHead.next = list2;
                    list2 = list2.next;
                }
                newHead = newHead.next;
            }
            if (list1 == null && list2 != null) {
                newHead.next = list2;
            } else if (list2 == null && list1 != null) {
                newHead.next = list1;
            }
            return newHeadHead.next.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

} 