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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        if(l1==null&&l2==null)return null;
        if(l1==null)return l2;
        if(l2==null)return l1;
        ListNode temp=new ListNode();
        ListNode runner=temp;
        while(l1!=null&&l2!=null){
            int sum=l1.val+l2.val+carry;
            runner.next=new ListNode(sum%10);
            carry=sum/10;
            runner=runner.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            int sum=l1.val+carry;
            runner.next=new ListNode(sum%10);
            carry=sum/10;
            runner=runner.next;
            l1=l1.next;
        }
    while (l2 != null) {
        int sum = l2.val + carry;
        runner.next = new ListNode(sum % 10);
        carry = sum / 10;
        runner = runner.next;
        l2 = l2.next;
    }
    if(carry!=0)runner.next=new ListNode(carry);
    return temp.next;

    }
}