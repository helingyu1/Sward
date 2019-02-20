package com.swardoffer;

public class Question07 {

    /**
     * 重建二叉树
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return core(pre, in, 0,pre.length - 1, 0, in.length - 1);
    }

    public TreeNode core(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd){
        // 根节点(前序遍历的第一个节点)
        int rootVal = pre[preStart];
        TreeNode root = new TreeNode(rootVal);
        // 找到根节点在中序遍历数组中的位置
        int rootIndexIn = inStart;
        for(;rootIndexIn <= inEnd; rootIndexIn++){
            if(in[rootIndexIn] == rootVal)
                break;
        }
        // 计算左子树的长度
        int leftLen = rootIndexIn - inStart;
        // 计算右子树的长度
        int rightLen = inEnd - rootIndexIn;
        if(leftLen > 0){
            // 存在左子树
            // 找到左子树的中序遍历数组
            int leftInStart = inStart;
            int leftInEnd = leftInStart + leftLen - 1;
            // 找到左子树的前序遍历数组
            int leftPreStart = preStart + 1;
            int leftPreEnd = leftPreStart + leftLen - 1;
            // 构建左子树
            root.left = core(pre,in,leftPreStart, leftPreEnd, leftInStart, leftInEnd);
        }

        if(rightLen > 0){
            // 存在右子树
            // 找到右子树的中序遍历数组
            int rightInStart = rootIndexIn + 1;
            int rightInEnd = rightInStart + rightLen - 1;

            // 找到右子树的前序遍历数组
            int rightPreStart = preEnd - rightLen + 1;
            int rightPreEnd = preEnd;

            // 构建右子树
            root.right = core(pre, in, rightPreStart, rightPreEnd, rightInStart, rightInEnd);
        }

        return root;
    }
}
