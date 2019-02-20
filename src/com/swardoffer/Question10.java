package com.swardoffer;

public class Question10 {
    /**
     * 斐波那契数列（使用循环的方式解题，递归固然简单，但是重复计算太多，效率较低）
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        int[] result = {0,1};
        if(n < 2)
            return result[n];
        int fibNMinusTwo = 0;
        int fibNMinusOne = 1;
        int fibN = 0;
        for(int i = 2; i <= n; i++){
            fibN = fibNMinusTwo + fibNMinusOne;
            fibNMinusTwo = fibNMinusOne;
            fibNMinusOne = fibN;
        }
        return fibN;
    }

}
