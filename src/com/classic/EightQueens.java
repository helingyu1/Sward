package com.classic;

public class EightQueens {
    static int count = 0;
    int[] result = new int[8];

    public void core(int row){
        if(row == 8){
            print(result);
            count++;
            return ;
        }
        for(int col=0; col <8; col++){
            if(isOk(row, col)){
                result[row] = col;
                core(row+1);
            }
        }

    }

    public boolean isOk(int row, int col){
        int leftup = col - 1, rightup = col + 1;
        for(int i = row - 1; i >= 0; i--){//从下往上
            if(result[i] == col) return false; // 如果上面的行，在此列已经有值，返回false
            if(leftup >= 0 && result[i] ==  leftup) return false; // 左上对角线
            if(rightup < 8 && result[i] == rightup) return false; // 右上对角线
            leftup--;rightup++;
        }
        return true;
    }

    public void print(int[] result){
        for(int row=0;row < 8; row++){
            for(int col=0;col < 8; col++){
                if(result[row] == col){
                    System.out.print("Q ");
                }else{
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        EightQueens e = new EightQueens();
        e.core(0);
        System.out.println(count);
    }
}
