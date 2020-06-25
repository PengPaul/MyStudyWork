package peng.algorithm.chapter03.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeUse {
    /***
     *  二叉树的应用
     *      查找操作/维持相对顺序
     *        二叉查找树（binary search tree）
     *        如果左子树不为空，则左子树上所有的节点都小于根节点的值
     *        如果右子树不为空，则右子树上所有的节点都大于根节点的值
     *        左右子树也都是二叉查找树
     *
     *  二叉树的遍历
     *    深度优先遍历
     *      前序遍历  根节点 左子树 右子树
     *      中序遍历  左子树 根节点 右子树
     *      后序遍历  左子树 右子树 根节点
     *     广度优先遍历
     *      层序遍历
     *
     */

    public static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data) {
            this.data = data;
        }
    }

    /**
     * 构建二叉树
     *
     * @param linkedList
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> linkedList) {
        TreeNode node = null;
        if (linkedList == null || linkedList.isEmpty()) {
            return null;
        }
        Integer data = linkedList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(linkedList);
            node.rightChild = createBinaryTree(linkedList);
        }
        return node;
    }

    /**
     * 递归
     * 前序遍历
     *
     * @param node
     */
    public static void preOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(" " + node.data);
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    /**
     * 非递归  栈的实现
     * 前序遍历
     *
     * @param root
     */
    public static void preOrderTraveralWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            //左孩子进入栈
            while (treeNode != null) {
                System.out.print(" " + treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            //如果没有左孩子了则弹出栈顶的节点，访问该节点的右孩子
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    public static void midOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        midOrderTraveral(node.leftChild);
        System.out.print(" " + node.data);
        midOrderTraveral(node.rightChild);
    }

    /**
     * 非递归  栈的实现
     * 中序遍历
     *
     * @param root
     */
    public static void midOrderTraveralWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            //如果没有左孩子了则弹出栈顶的节点，访问该节点的右孩子
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                System.out.print(" " + treeNode.data);
                treeNode = treeNode.rightChild;
            }
        }
    }


    /**
     * 后序遍历
     *
     * @param node
     */
    public static void postOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraveral(node.leftChild);
        postOrderTraveral(node.rightChild);
        System.out.print(" " + node.data);
    }

    /**
     * 非递归  栈的实现
     * 后序遍历  这里稍微有点绕
     *
     * @param root
     */
    public static void postOrderTraveralWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        TreeNode lastNode = root;
        //先找到最左
        while (treeNode != null) {
            stack.push(treeNode);
            treeNode = treeNode.leftChild;
        }

        while (!stack.isEmpty()) {
            treeNode = stack.pop();
            if (treeNode.rightChild != null && treeNode.rightChild != lastNode) {
                stack.push(treeNode);
                treeNode = treeNode.rightChild;
                while (treeNode != null) {
                    stack.push(treeNode);
                    treeNode = treeNode.leftChild;
                }
            } else {
                System.out.print(" " + treeNode.data);
                lastNode = treeNode;
            }
        }
    }

    /**
     * 广度优先遍历
     * @param root
     */
    public static void levelOrderTraveralsal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(" "+node.data);
            if (node.leftChild != null){
                queue.offer(node.leftChild);
            }
            if (node.rightChild !=null){
                queue.offer(node.rightChild);
            }

        }
    }
}

