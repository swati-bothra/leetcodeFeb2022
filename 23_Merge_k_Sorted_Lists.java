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
        this.lists=lists;
        int n=lists.length;
        if(n==0) return null;    
        return mergeSort(0,n-1);
    }
    ListNode[] lists;
    
    ListNode mergeSort(int l, int r){
        if(l==r){
            return lists[l];
        }
        if(l>r){
            return null;
        }
        int m=(l+r)/2;
        ListNode left=mergeSort(l,m);
        ListNode right=mergeSort(m+1,r);
        return merge(left,right);
    }
    
    ListNode merge(ListNode left,ListNode right){
        if(left==null)return right;
        if(right==null)return left;
        ListNode temp=null;
        if(left.val<=right.val){
            temp=left;left=left.next;   
        }else{
            temp=right;right=right.next;    
        }
        ListNode head=temp;
        while(left!=null&&right!=null){
            if(left.val<=right.val){
                temp.next=left;
                left=left.next;
            }else{
                temp.next=right;
                right=right.next;
            }
            temp=temp.next;
        }
        if(left!=null){
           temp.next=left;
        }
        if(right!=null){
           temp.next=right;
        }
        return head;
    }
}
