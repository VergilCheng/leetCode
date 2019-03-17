
/*
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 */
public class addTwoNums {
    /**
     * 分情况讨论
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head =new ListNode(-1);
        ListNode guard = head;
        int count = 0;
        while(l1.next!=null&&l2.next!=null){
            if(count==0){
                int numTemp = l1.val+l2.val;
                if(numTemp>=10){
                    count = 1;
                    ListNode temp = new ListNode(numTemp-10);
                    head.next = temp;
                    head = temp;
                    l1 = l1.next;
                    l2 = l2.next;
                }else{
                    count = 0;
                    ListNode temp = new ListNode(numTemp);
                    head.next = temp;
                    head = temp;
                    l1 = l1.next;
                    l2 = l2.next;
                }

            }else{
                int numTemp = l1.val+l2.val+count;
                if(numTemp>=10){
                    count = 1;
                    ListNode temp = new ListNode(numTemp-10);
                    head.next = temp;
                    head = temp;
                    l1 = l1.next;
                    l2 = l2.next;
                }else{
                    count = 0;
                    ListNode temp = new ListNode(numTemp);
                    head.next = temp;
                    head = temp;
                    l1 = l1.next;
                    l2 = l2.next;
                }
            }
        }

        if(l1.next==null&&l2.next==null){
            int numTemp = l1.val+l2.val+count;
            if(numTemp>=10){
                count = 1;
                ListNode temp = new ListNode(numTemp-10);
                head.next = temp;
                head = temp;
                ListNode temp2 = new ListNode(1);
                head.next = temp2;
                return guard.next;
            }else{
                count = 0;
                ListNode temp = new ListNode(numTemp);
                head.next = temp;
                return guard.next;
            }
        }else if(l1.next==null&&l2.next!=null){
            int numTemp = l1.val+l2.val+count;
            if(numTemp>=10){
                count = 1;
                l2.val = numTemp-10;
                head.next = l2;
                l2 = l2.next;
                while(l2.next!=null){
                    int l2numTemp = count+l2.val;
                    if(l2numTemp==10){
                        count=1;
                        l2.val=0;
                        l2 = l2.next;
                    }else{
                        count=0;
                        l2.val=l2numTemp;
                        return guard.next;
                    }
                }
                if(count==1){
                    l2.val = l2.val+1;
                    if(l2.val<10){
                        return guard.next;
                    }else{
                        l2.val = 0;
                        ListNode last = new ListNode(1);
                        l2.next = last;
                        return guard.next;
                    }
                }else{
                    return guard.next;
                }
            }else{
                l2.val = numTemp;
                head.next=l2;
                return guard.next;
            }

        }else{
            int numTemp = l1.val+l2.val+count;
            if(numTemp>=10){
                count = 1;
                l1.val = numTemp-10;
                head.next = l1;
                l1 = l1.next;
                while(l1.next!=null){
                    int l1numTemp = count+l1.val;
                    if(l1numTemp==10){
                        count=1;
                        l1.val=0;
                        l1 = l1.next;
                    }else{
                        count=0;
                        l1.val=l1numTemp;
                        return guard.next;
                    }
                }
                if(count==1){
                    l1.val = l1.val+1;
                    if(l1.val<10){
                        return guard.next;
                    }else{
                        l1.val = 0;
                        ListNode last = new ListNode(1);
                        l1.next = last;
                        return guard.next;
                    }
                }else{
                    return guard.next;
                }
            }else{
                count = 0;
                l1.val = numTemp;
                head.next = l1;
                return guard.next;
            }
        }

    }

    public static void main(String[] args) {

    }

}




class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
