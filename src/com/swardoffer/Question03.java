package com.swardoffer;

public class Question03 {

    /**
     * 第一题：长度为n的数字中，存放着0-n-1范围的数字，如果有重复数字，任意找出一个即可。
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        boolean ret = false;
        if(numbers == null)
            return ret;
        if(length == 0)
            return ret;
        int i = 0;
        while(i < numbers.length){
            int target = numbers[i];
            if(i == target){
                i++;
            }else{
                if(numbers[target] == target){
                    ret = true;
                    duplication[0] = target;
                    return ret;
                }else{
                    int tmp = numbers[target];
                    numbers[target] = target;
                    numbers[i] = tmp;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {

    }

}
