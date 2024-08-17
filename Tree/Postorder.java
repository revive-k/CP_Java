import java.util.Stack;

class Node {
    Node left, right;
    int data;

    Node(int data) {
        this.data = data;
    }

}

public class Postorder {
    private static void postOrderUsingRecursion(Node root) {
        if (root == null) {
            return;
        }
        postOrderUsingRecursion(root.left);
        postOrderUsingRecursion(root.right);
        System.out.print(root.data + " ");
    }

    private static void iterativePostOrder(Node root) {
        if(root == null) return;
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.empty()) {
            Node node = stack1.pop();
            stack2.push(node);
            if(node.left!=null) stack1.push(node.left);
            if(node.right!=null) stack1.push(node.right);
        }
        while(!stack2.empty()) {
            System.out.print(stack2.pop().data + " ");
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.left.right = new Node(7);
        root.right.left.right.right = new Node(8);

        System.out.println("----Postorder using recursion----");
        postOrderUsingRecursion(root);
        System.out.println("\n----Postorder using iterative----");
        iterativePostOrder(root);
    }
}
