import java.util.LinkedList;
import java.util.Queue;

class BinaryTreeBL {
    static class Node {
        int data;
        Node left;
        Node right;
    
        public Node(int data) {
            this.data = data;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public Node buildTree(int[] nodes) {
            idx++;
            if(nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode; 
        }

        public void preOrder(Node root) {
            if(root == null) {
                return;
            }
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public void inorder(Node root) {
            if(root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }

        public void postOrder(Node root) {
            if(root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }

        public static void levelOrder(Node root) {
            if(root == null){
                return;
            }

            Queue<Node> nodes = new LinkedList<>();
            nodes.add(root);
            nodes.add(null);

            while(!nodes.isEmpty()) {
                Node currNode = nodes.remove();
                if(currNode == null){
                    System.out.println();
                    if(nodes.isEmpty()) {
                        return;
                    }
                    else {
                        nodes.add(null);
                    }
                }
                else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null){
                        nodes.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        nodes.add(currNode.right);
                    }
                }
            }
        }

        public static int countOfNodes(Node root) {
            if(root == null) {
                return 0;
            }
            int leftCount = countOfNodes(root.left);
            int rightCount = countOfNodes(root.right);
            return leftCount+rightCount+1;
        }

        public static int sumOfNodes(Node root) {
            if(root == null) {
                return 0;
            }
            int leftSum = sumOfNodes(root.left);
            int rightSum = sumOfNodes(root.right);
            return leftSum + rightSum + root.data;
        }

        public static int heightOfTree(Node root) {
            if(root == null ) {
                return 0;
            }
            int leftTreeHeight = heightOfTree(root.left);
            int rightTreeHieght = heightOfTree(root.right);
            int myHeight = Math.max(leftTreeHeight, rightTreeHieght)+1;
            return myHeight;
        }

    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
        tree.preOrder(root);
        System.out.println();
        tree.inorder(root);
        System.out.println();
        tree.postOrder(root);
        System.out.println();
        tree.levelOrder(root);
        System.out.println();
        System.out.println(tree.countOfNodes(root));
        System.out.println(tree.sumOfNodes(root));
        System.out.println(tree.heightOfTree(root));
    }
}