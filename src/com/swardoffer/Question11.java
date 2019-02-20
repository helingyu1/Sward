package com.swardoffer;

public class Question11 {
    /**
     * 旋转数组的最小数字
     */
    public int minNumberInRotateArray(int [] array) {
        if(array == null || array.length == 0)
            return -1;
        int index1 = 0;
        int index2 = array.length - 1;
        int indexMid = index1;
        while(array[index1] >= array[index2]){
            if(index2 - index1 == 1){
                indexMid = index2;
                break;
            }
            indexMid = (index1 + index2) / 2;
            if(array[index1] == array[indexMid] && array[indexMid] == array[index2]){
                return findMin(array, index1, index2);
            }
            if(array[index1] <= array[indexMid])
                index1 = indexMid;
            else if(array[index2] >= array[indexMid])
                index2 = indexMid;
        }
        return array[indexMid];

    }

    public int findMin(int[] arr, int start, int end){
        int min = arr[start];
        for(int i = start; i <= end; i++){
            if(arr[i] < min)
                min = arr[i];
        }
        return min;
    }
}
