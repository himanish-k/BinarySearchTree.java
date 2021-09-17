public class BinaryTree {

    Node root;

    public void add(int value) {
        if (root == null)
            root = new Node(value);
        else
            root.insert(value);
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

        public void insert(int value) {
            if (value <= this.value) {
                if (this.leftChild == null) {
                    this.leftChild = new Node(value, this);
                } else {
                    this.leftChild.insert(value);
                }
            } else {
                if (this.rightChild == null) {
                    this.rightChild = new Node(value, this);
                } else {
                    this.rightChild.insert(value);
                }
            }
        }

        public void inOrderPrint() {
            if (this.leftChild != null)
                this.leftChild.inOrderPrint();
            System.out.println("-" + this.value + "-");
            if (this.rightChild != null)
                this.rightChild.inOrderPrint();
        }

        public void successorPrint() {
            System.out.println("node: " + this.value);

        }

        public Node minimumValue() {
            Node curr = this;
            while (curr.getLeftChild() != null)
                curr = this.getLeftChild();

            return curr;
        }
    }
}
