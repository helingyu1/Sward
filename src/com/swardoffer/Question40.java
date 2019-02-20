package com.swardoffer;

import java.util.ArrayList;
import java.util.Arrays;

public class Question40 {
    public static void main(String[] args) {
        int[] input = {4,5,1,6,2,7,3,8};
        Question40 q = new Question40();
        ArrayList<Integer> ret = q.GetLeastNumbers_Solution(input, 8);
        System.out.println(ret);

    }

    /**
     * 最小的k个数
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> retList = new ArrayList<Integer>();
        if(input == null || k > input.length || k==0)
            return retList;

        if(k > input.length){
            for(int i : input){
                retList.add(i);
            }
            return retList;
        }

        // 创建大小为k的最大堆
        Heap h = new Heap(k);
        for(int i=0;i < k; i++){
            h.insert(input[i]);
        }
        // 更新堆
        for(int i = k; i < input.length; i++){
            int tmp = input[i];
            int top = h.a[1];
            if(tmp < top){
                h.a[1] = tmp;
                heapify(h.a, k, 1);
            }
        }
        heapSort(h.a,k);
        for(int i = 1; i <= k; i++){
            retList.add(h.a[i]);
        }
        return retList;
    }

    /**
     * a 从1开始存储数据
     * @param a
     */
    public void heapSort(int[] a, int n){
        buildHeap(a, n);
        int k = n;
        while(k > 1){
            swap(a, k, 1);
            --k;
            heapify(a, k, 1);
        }

    }

    public void buildHeap(int[] a, int n){
        for(int i = n / 2; i >= 1 ; --i){
            heapify(a, n, i);
        }
    }

    /**
     * 堆化函数（从上往下,大顶堆）
     * @param a 数组
     * @param n 大小
     * @param i 堆化七点
     */
    public void heapify(int[] a ,int n, int i){
        while(true){
            int maxPos = i;
            if(i*2 <= n && a[i] <= a[2*i]) maxPos = 2*i;
            if(i*2 + 1 <= n && a[maxPos] <= a[2*i + 1]) maxPos = 2*i + 1;
            if(i == maxPos) break;
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    public void swap(int[] a, int x, int y){
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }
}
