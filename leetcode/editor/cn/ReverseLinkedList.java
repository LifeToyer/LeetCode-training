//////////给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
////////// 
////////// 
////////// 
//////////
////////// 示例 1： 
//////////
////////// 
//////////输入：head = [1,2,3,4,5]
//////////输出：[5,4,3,2,1]
////////// 
//////////
////////// 示例 2： 
//////////
////////// 
//////////输入：head = [1,2]
//////////输出：[2,1]
////////// 
//////////
////////// 示例 3： 
//////////
////////// 
//////////输入：head = []
//////////输出：[]
////////// 
//////////
////////// 
//////////
////////// 提示： 
//////////
////////// 
////////// 链表中节点的数目范围是 [0, 5000] 
////////// -5000 <= Node.val <= 5000 
////////// 
//////////
////////// 
//////////
////////// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
////////// 
////////// 
////////// Related Topics 递归 链表 👍 2455 👎 0
////////
//////
////
//

  
package leetcode.editor.cn;

import leetcode.editor.cn.util.ListNode;

public class ReverseLinkedList{
      public static void main(String[] args) {
           Solution solution = new ReverseLinkedList().new Solution();
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
    /**
     * 此题给出的head为链表的第一个节点，而非头结点
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode headHead = new ListNode();//定义headHead为原链表的头结点
        headHead.next = head;
        ListNode headN = headHead.next;//定义headN为原链表的第一个数据节点（即头结点的下一个节点）
        ListNode newHead = new ListNode();//新链表
        while (headHead.next!=null){
            headHead.next = headN.next;
            headN.next = newHead.next;
            newHead.next = headN;
            headN = headHead.next;
        }
        return newHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }