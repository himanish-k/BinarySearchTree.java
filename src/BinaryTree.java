public class BinaryTree {

    Node root;

    public void add(int value) {
        return;
    }

    public boolean remove(int value) {
        return true;
    }

    class Node {
        int value;
        Node leftChild, rightChild;

        public Node(int value) {
            this.value = value;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }
    }
}
