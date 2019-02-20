package com.swardoffer;

public class Question13 {
    /**
     * 机器人的运动范围
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int movingCount(int threshold, int rows, int cols)
    {
        if(threshold < 0 || rows <= 0 || cols <= 0)
            return 0;
        boolean[] visited = new boolean[rows*cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++)
                visited[i*cols+j] = false;
        }
        int count = movingCountCore(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    public int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited){
        int count = 0;
        if(check(threshold, rows, cols, row, col, visited)){
            visited[row*cols+col] = true;
            count = 1 + movingCountCore(threshold, rows, cols, row + 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row - 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row, col + 1, visited)
                    + movingCountCore(threshold, rows, cols, row, col - 1, visited);
        }
        return count;
    }

    public boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited){
        if(row>=0 && row<rows && col>=0 && col<cols
                && (getSum(row) + getSum(col)) <= threshold
                && !visited[row*cols+col])
            return true;
        return false;
    }

    public int getSum(int n){
        int sum=0;
        while(n>0){
            int tmp = n % 10;
            sum+=tmp;
            n/=10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Question13 q = new Question13();
        System.out.println(q.movingCount(17,4,4));
    }
}
