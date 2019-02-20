package com.swardoffer;

public class Question08 {
    /**
     * 中序遍历中的下一个节点
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        TreeLinkNode retNode =  null;
        // 如果此节点有右子树，那么下一个节点就是右子树的最左边节点
        if(pNode.right != null){
            TreeLinkNode tmpNode = pNode.right;
            while(tmpNode.left != null){
                tmpNode = tmpNode.left;
            }
            return tmpNode;
        }
        // 如果此节点没有右子树，且是其父节点的左子节点，那么下一个节点就是其父节点
        if(pNode.next != null && pNode == pNode.next.left)
            return pNode.next;
        // 如果此节点没有右子树，且是其父节点的右子节点，那么一直向上寻找，找到一个节点是其父节点的左子节点，那么这个节点的父节点就是下一个节点
        if(pNode.next != null && pNode == pNode.next.right){
            TreeLinkNode tmpNode = pNode.next;
            while(tmpNode.next != null &&  tmpNode == tmpNode.next.right) {
                tmpNode = tmpNode.next;
            }
            return tmpNode.next;
        }
        return retNode;
    }
}
