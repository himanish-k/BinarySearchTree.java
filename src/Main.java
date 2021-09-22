public class Main {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.print();
        tree.add(50);
        tree.print();
        tree.add(40);
        tree.print();
        tree.add(60);
        tree.print();
        tree.add(55);
        tree.print();
        tree.add(65);
        tree.print();
        tree.remove(60);
        tree.print();
        tree.remove(65);
        tree.print();
        tree.remove(40);
        tree.print();
        tree.remove(50);
        tree.print();
        tree.remove(55);
        tree.print();
    }
}
