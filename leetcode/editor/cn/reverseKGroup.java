package leetcode.editor.cn;

import leetcode.editor.cn.util.ListNode;

public class reverseKGroup {
    public static void main(String[] args) {
        reverseKGroup.Solution solution = new reverseKGroup().new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode = solution.reverseKGroup(head, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode preNode = new ListNode(0, head);
            reverseSingle(preNode, head, k);
            return preNode.next;
        }

        public void reverseSingle(ListNode headPre, ListNode head, int k) {
            int tempK = k;
            ListNode tempHeadPre = new ListNode();
            ListNode tempHead = head;
            while (tempHead != null && tempK > 0) {
                tempHead = tempHead.next;
                tempK--;
            }
            if (tempK == 0) {
                ListNode newHead = new ListNode();
                ListNode newLast = new ListNode();
                newLast.next = tempHead;
                newHead.next = newLast.next;
                int tempK2 = k;
                while (head != null && tempK2 > 0) {
                    ListNode oldHeadNext = head.next;
                    head.next = newHead.next;
                    newHead.next = head;
                    head = oldHeadNext;
                    tempK2--;
                }
                headPre.next = newHead.next;

                tempHeadPre = newHead.next;
                int tempK3 = k - 1;
                while (tempHeadPre != null && tempK3 > 0) {
                    tempHeadPre = tempHeadPre.next;
                    tempK3--;
                }

                reverseSingle(tempHeadPre, tempHead, k);
            }
        }
    }
}
