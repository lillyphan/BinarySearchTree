public class testDriver {
    public static void main(String[] args) {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree();

        //testing size()
        System.out.println("0: " + bst.size());

        //testing isEmpty()
        System.out.println("true: " + bst.isEmpty());

        //testing put()
        bst.put(-20, "d");
        bst.put(100, "a");
        bst.put(50, "c");
        bst.put(200, "b");
        bst.put(20, "d");

        System.out.println(bst);

        System.out.println("false: " + bst.isEmpty());

        System.out.println("5: " + bst.size());


    }
}
