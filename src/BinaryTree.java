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
        Node removeNode = find(value);
        if (removeNode == null)
            return false;

        if (removeNode.getLeftChild() == null) {
            transplant(removeNode, removeNode.getRightChild());
        } else if (removeNode.getRightChild() == null) {
            transplant(removeNode, removeNode.getLeftChild());
        } else {
            Node y = findMinimum(removeNode.getRightChild());
            if (y.getParent() != removeNode) {
                transplant(y, y.getRightChild());
                y.setRightChild(removeNode.getRightChild());
                y.getRightChild().setParent(y);
            }

            transplant(removeNode, y);
            y.setLeftChild(removeNode.getLeftChild());
            y.getLeftChild().setParent(y);
        }

        return true;
    }

    public void print() {
        System.out.println("Tree:");
        if (this.root == null)
            System.out.println("Empty");
        else
            this.root.inOrderPrint();
    }

    private Node find(int value) {
        if (this.root == null)
            return null;

        Node curr = this.root;
        while (curr != null) {
            if (value == curr.getValue())
                return curr;
            else if (value < curr.getValue())
                curr = curr.getLeftChild();
            else
                curr = curr.getRightChild();
        }

        return null;
    }

    private Node findMinimum(Node curr) {
        while (curr.getLeftChild() != null) {
            curr = curr.getLeftChild();
        }

        return curr;
    }

    /*
    All cases are described with respect to z's parent,
    and then a final case if n is null. No method is
    invoked on n because it might be null, until the null
    check is made.
     */
    private void transplant(Node z, Node n) {
        Node zParent = z.getParent();
        if (zParent == null) {
            this.root = n;
        } else if (zParent.getLeftChild() == z) {
            zParent.setLeftChild(n);
        } else {
            zParent.setRightChild(n);
        }
        if (n != null)
            n.setParent(z.getParent());
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
