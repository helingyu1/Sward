package com.swardoffer;

import java.util.ArrayList;

public class Question12 {
    /**
     * 矩阵中的路径
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix == null || str == null || rows<1 || cols<1)
            return false;
        boolean[] visited = new boolean[rows*cols];

        ArrayList<Character> list = new ArrayList<Character>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++)
                visited[i*cols + j] = false;
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(hasPathCore(matrix,rows,cols,i,j,visited,str,list))
                    return true;
            }
        }
        return false;
    }

    public boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, boolean[] visited, char[] str, ArrayList<Character> list){
        if(list.size() == str.length)
            return true;
        boolean hasPath=false;
        if(row>=0 && row<rows && col>=0 && col<cols && matrix[row*cols+col]==str[list.size()] && !visited[row*cols+col]){
            // 如果矩阵当前访问位置等于字符串的的当前位置，并且该位置之间未被置过位置
            // 将找到的字符加入list中
            list.add(str[list.size()]);
            // 设置此位置已经被访问过
            visited[row*cols+col]=true;
            // 在上下左右位置中查找下一个字符
            hasPath = hasPathCore(matrix, rows, cols, row+1, col,visited, str, list)
                    || hasPathCore(matrix, rows, cols, row-1, col, visited, str, list)
                    || hasPathCore(matrix, rows, cols, row, col+1, visited, str, list)
                    || hasPathCore(matrix, rows, cols, row, col-1, visited, str, list);

            // 如果在上下左右中没有查找到下一个字符，需要重置本轮设置过得值
            if(!hasPath){
                list.remove(list.size()-1);
                visited[row*cols+col] = false;
            }
        }
        return hasPath;
    }

    public static void main(String[] args) {
        Question12 q= new Question12();
        System.out.println(q.hasPath("ABCESFCSADEE".toCharArray(),3,4,"ABCCED".toCharArray()));

    }
}
