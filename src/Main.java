public class Main {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        System.out.println("Tree:");
        tree.print();
        tree.add(1);
        System.out.println("Tree:");
        tree.print();
        tree.add(2);
        System.out.println("Tree:");
        tree.print();
        tree.add(3);
        System.out.println("Tree:");
        tree.print();
        System.out.println("Does 1 exist? " + tree.isExist(1));
        System.out.println("Does 2 exist? " + tree.isExist(2));
        System.out.println("Does 3 exist? " + tree.isExist(3));
        System.out.println("Does 4 exist? " + tree.isExist(4));
    }
}
