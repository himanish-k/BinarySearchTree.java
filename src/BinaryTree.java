public class BinaryTree {

    Node root;

    public void add(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }

        Node curr = root;
        Node newNode = new Node(value);
        while (curr != null) {
            if (value <= curr.getValue()) {
                if (curr.getLeftChild() == null) {
                    curr.setLeftChild(newNode);
                    return;
                } else {
                    curr = curr.getLeftChild();
                }
            } else {
                if (curr.getRightChild() == null) {
                    curr.setRightChild(newNode);
                    return;
                } else {
                    curr = curr.getRightChild();
                }
            }
        }
    }

    public boolean isExist(int value) {
        if (root == null)
            return false;

        Node curr = root;
        while (curr != null) {
            if (curr.getValue() == value) {
                return true;
            } else if (value < curr.getValue()) {
                if (curr.getLeftChild() == null) {
                    return false;
                } else {
                    curr = curr.getLeftChild();
                }
            } else {
                if (curr.getRightChild() == null) {
                    return false;
                } else {
                    curr = curr.getRightChild();
                }
            }
        }

        return false;
    }

    public boolean remove(int value) {
        return true;
    }

    public void print() {
        if (this.root == null)
            System.out.println("Empty tree.");
        else
            this.root.inOrderPrint();
    }

    class Node {
        private int value;
        private Node leftChild, rightChild;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getLeftChild() {
            return this.leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return this.rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        public void inOrderPrint() {
            if (this.leftChild != null)
                this.leftChild.inOrderPrint();
            System.out.println("-" + this.value + "-");
            if (this.rightChild != null)
                this.rightChild.inOrderPrint();
        }
    }
}
