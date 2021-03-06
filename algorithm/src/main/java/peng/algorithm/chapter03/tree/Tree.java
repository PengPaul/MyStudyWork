package peng.algorithm.chapter03.tree;

import java.util.Arrays;
import java.util.LinkedList;

public class Tree {
    /**
     *
     * 树是有n(n>=0)个节点的有限集
     * n = 0  空树
     * 在任意一个非空树有如下特点：
     *      有且仅有一个特定的称为根的节点
     *      当 n>1 时，其余节点可分为m（m > 0）个互不相交的有限集，每个集合本身又是一个树，并称为根的子树
     *  父节点
     *  孩子节点
     *  叶子节点
     *  子树
     *  深度
     */

    /**
     *  二叉树
     *
     *  每个节点最多有2个孩子节点
     *  左孩子
     *  右孩子
     *
     *  满二叉树
     *        一个二叉树的所有的叶子节点都有左右孩子，并且所有叶子节点都在同一层级上
     *  完全二叉树
     *        对于有n个节点的二叉树，按照层级顺序编号，所有的节点编号为从1到n。
     *        如果这个树所有的节点和相同深度的满二叉树的编号为从1到n的节点位置相同
     *
     *  可以用数组存储也可以用链式存储
     *
     *
     *           3
     *       2       8
     *     9  10  null   4
     */

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(new Integer[]{
                3,2,9,null,null,10,null,null,8,null,4
        }));
        TreeUse.TreeNode node = TreeUse.createBinaryTree(linkedList);
        System.out.println("前序遍历：");
        TreeUse.preOrderTraveral(node);
        System.out.println("");
        System.out.println("中序遍历：");
        TreeUse.midOrderTraveral(node);
        System.out.println("");
        System.out.println("后序遍历：");
        TreeUse.postOrderTraveral(node);

        System.out.println("");
        System.out.println("前序遍历：");
        TreeUse.preOrderTraveralWithStack(node);

        System.out.println("");
        System.out.println("中序遍历：");
        TreeUse.midOrderTraveralWithStack(node);

        System.out.println("");
        System.out.println("后序遍历：");
        TreeUse.postOrderTraveralWithStack(node);

        System.out.println("");
        System.out.println("广度优先：");
        TreeUse.levelOrderTraveralsal(node);
    }
}
