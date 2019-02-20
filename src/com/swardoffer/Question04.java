package com.swardoffer;

public class Question04 {
    /**
     * 二位数组中的查找。这个二维数组的每一行都是从左到右递增，每一列都是从上到下递增。
     */
    public boolean Find(int target, int [][] array) {
        boolean ret = false;
        if(array == null)
            return ret;
        int rowNums = array.length;
        int colNums = array[0].length;

        int startRow = 0, startCol = colNums - 1;
        while(startRow < rowNums && startCol >=0){
            int tmp = array[startRow][startCol];
            if(tmp == target){
                ret = true;
                return ret;
            }else if(tmp > target){
                startCol --;
            }else{
                startRow ++;
            }
        }
        return ret;
    }
}
