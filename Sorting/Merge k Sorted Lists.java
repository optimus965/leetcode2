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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int n = lists.length - 1;
        ListNode node =mergeSort(lists,0,n);
        return node;
    }
    public ListNode mergeSort(ListNode[] lists,int low, int high) {
        if(low == high) {
            return lists[low];
        }
        int mid = (low + high)>>1;
        ListNode node = new ListNode();
        ListNode temp = node;
        ListNode node1 = mergeSort(lists,low,mid);
        ListNode node2 = mergeSort(lists,mid+1,high);
        while(node1 != null &&  node2 != null) {
            int value1 = node1.val;
            int value2 = node2.val;
            if(value1 < value2) {
                temp.next = new ListNode(value1);
                node1 = node1.next;
            }
            else {
                temp.next = new ListNode(value2);
                node2 = node2.next;
            }
            temp = temp.next;
        }
        while(node1 != null) {
            int value1 = node1.val;
            temp.next = new ListNode(value1);
            node1 = node1.next;
            temp = temp.next;
        }
        while(node2 != null) {
            int value1 = node2.val;
            temp.next = new ListNode(value1);
            node2 = node2.next;
            temp = temp.next;
        }
        return node.next;
    }
}
