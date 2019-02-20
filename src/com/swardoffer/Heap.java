package com.swardoffer;

public class Heap {
    public int[] a;
    private int n;
    private int count;

    public Heap(int capacity){
        this.n = capacity;
        this.count = 0;
        a = new int[capacity + 1];
    }

    public void insert(int data){
        if(count >= n) return; // 堆满了
        ++count;
        a[count] = data;
        int i = count;
        while(i/2 > 0 && a[i] > a[i/2]){
            swap(a, i, i/2);
            i = i/2;
        }
    }

    public void removeMax(){
        if(count == 0) return;
        a[1] = a[count];
        --count;
        heapify(a, count, 1);
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
