public class BinaryTree {

    private Node root;

    public void add(int value) {
        // Find what will be the parent of the added node
        Node currParent = null;
        Node curr = this.root;
        while (curr != null) {
            currParent = curr;
            if (value <= curr.getValue()) {
                curr = curr.getLeftChild();
            } else {
                curr = curr.getRightChild();
            }
        }

        // Add need in the appropriate part of the tree
        if (currParent == null)
            this.root = new Node(value);
        else if (value <= currParent.getValue())
            currParent.setLeftChild(new Node(value, currParent));
        else
            currParent.setRightChild(new Node(value, currParent));
    }

    public boolean isExist(int value) {
        if (root == null)
            return false;

        Node curr = root;
        while (curr != null) {
            if (curr.getValue() == value) {
                return true;
            } else if (value < curr.getValue()) {
                curr = curr.getLeftChild();
            } else {
                curr = curr.getRightChild();
            }
        }

        return false;
    }

    public boolean remove(int value) {
        return false;
    }

    public void print() {
        if (this.root == null)
            System.out.println("Empty tree.");
        else
            this.root.inOrderPrint();
    }

    class Node {
        private int value;
        private Node parent, leftChild, rightChild;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node parent) {
            this(value);
            this.parent = parent;
        }

        public int getValue() {
            return value;
        }

        public Node getParent() {
            return this.parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
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

        public Node minimumValue() {
            Node curr = this;
            while (curr.getLeftChild() != null)
                curr = this.getLeftChild();

            return curr;
        }
    }
}
