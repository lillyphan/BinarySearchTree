// Author:           Lilly Phan
// Lab Section:      testDriver
// Description:      testDriver is a Java class containing the main function to test out the classes Node.java and BinarySearchTree.java
// Last Edited:      03/17/2023

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

        //testing get()
        System.out.println("a: " + bst.get(100));
        System.out.println("null: " + bst.get(1000));
        System.out.println("d: " + bst.get(20));
        System.out.println("d: " + bst.get(-20));

        //testing contains()
        System.out.println("true: " + bst.contains(100));
        System.out.println("false: " + bst.contains(1000));
        System.out.println("true: " + bst.contains(20));
        System.out.println("true: " + bst.contains(-20));

        //testing min
        System.out.println("-20: " + bst.min());
        System.out.println("200: " + bst.max());

    }
}
