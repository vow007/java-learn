package datastructure.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class TreeTravelsal {
    //后续遍历 左-->右-->根
    //1、递归
    public static void postOrderRe(TreeNode biTree) {//后序遍历递归实现
        if (biTree == null)
            return;
        else {
            postOrderRe(biTree.leftNode);
            postOrderRe(biTree.rightNode);
            System.out.println(biTree.data);
        }
    }
        /*
        https://blog.csdn.net/coder__666/article/details/80349039
        */

    //2、非递归
    public static void postOrder(TreeNode biTree) {//后序遍历非递归实现
        int left = 1;//在辅助栈里表示左节点
        int right = 2;//在辅助栈里表示右节点
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> stack2 = new Stack<Integer>();//辅助栈，用来判断子节点返回父节点时处于左节点还是右节点。

        while (biTree != null || !stack.empty()) {
            while (biTree != null) {//将节点压入栈1，并在栈2将节点标记为左节点
                stack.push(biTree);
                stack2.push(left);
                biTree = biTree.leftNode;
            }

            while (!stack.empty() && stack2.peek() == right) {//如果是从右子节点返回父节点，则任务完成，将两个栈的栈顶弹出
                stack2.pop();
                System.out.println(stack.pop().data);
            }

            if (!stack.empty() && stack2.peek() == left) {//如果是从左子节点返回父节点，则将标记改为右子节点
                stack2.pop();
                stack2.push(right);
                biTree = stack.peek().rightNode;
            }

        }
    }

    public static void postOrderT(TreeNode biTree) {//后序遍历非递归实现
        int left = 1;//在辅助栈里表示左节点
        int right = 2;//在辅助栈里表示右节点

        Deque deque=new LinkedList();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> stack2 = new Stack<Integer>();//辅助栈，用来判断子节点返回父节点时处于左节点还是右节点。

        while (biTree != null || !stack.empty()) {
            while (biTree != null) {//将节点压入栈1，并在栈2将节点标记为左节点
                stack.push(biTree);
                stack2.push(left);
                biTree = biTree.leftNode;
            }

            while (!stack.empty() && stack2.peek() == right) {//如果是从右子节点返回父节点，则任务完成，将两个栈的栈顶弹出
                stack2.pop();
                System.out.println(stack.pop().data);
            }

            if (!stack.empty() && stack2.peek() == left) {//如果是从左子节点返回父节点，则将标记改为右子节点
                stack2.pop();
                stack2.push(right);
                biTree = stack.peek().rightNode;
            }

        }
    }

}
