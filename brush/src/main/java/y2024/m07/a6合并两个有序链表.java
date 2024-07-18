package y2024.m07;

import base.ListNode;

public class a6合并两个有序链表 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list = mergeTwoLists(list1, list2);
        System.out.println(list);
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        //
        ListNode listNodeSource = new ListNode(0);
        ListNode listNode = listNodeSource;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                listNode.next = list1;
                list1 = list1.next;
            } else {
                listNode.next = list2;
                list2 = list2.next;
            }
            listNode = listNode.next;
        }
        listNode.next = list1 == null ? list2 : list1;
        return listNodeSource.next;


        // 递归实现
//        if (list1.val < list2.val) {
//            list1.next = mergeTwoLists(list1.next, list2);
//            return list1;
//        } else {
//            list2.next = mergeTwoLists(list1, list2.next);
//            return list2;
//        }
    }
}
