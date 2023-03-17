public class testDriver {
    public static void main(String[] args) {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree();

        //testing size()
        System.out.println(bst.size());

        bst.put(-20, "d");
        bst.put(100, "a");
        bst.put(50, "c");
        bst.put(200, "b");
        bst.put(20, "d");

        System.out.println(bst);


    }
}
