package com.swardoffer;

import java.util.ArrayList;
import java.util.List;

public class Question06 {
    /**
     * 倒序打印链表
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        func(ret, listNode);
        return ret;

    }
    public void func(ArrayList<Integer> list, ListNode node){
        if(node == null)
            return ;
        func(list, node.next);
        list.add(node.val);
    }


}
