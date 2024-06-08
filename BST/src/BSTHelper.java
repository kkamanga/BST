//Kondwani Kamanga, CSC 2720: Data Structures, HW 6
public class BSTHelper {

    public static void main(String[] args) {

        System.out.println("Binary Search Tree");
        int[] dataset = { 43, 58, 54, 3, 67, 53, 82, 55 };
        BST bst = new BST();
        for (int x : dataset) {
            bst.insert(x);
        }

        bst.traverseInOrder();
        System.out.println();

        bst.delete(55); //delete leaf node
        bst.delete(67); //delete node with one child
        bst.delete(58); //delete node with two children


        bst.traverseInOrder();
        System.out.println();

        System.out.println(bst.height(bst.getRoot()));
        System.out.println(bst.numOfLeafNodes(bst.getRoot()));



        //degenerated tree
        int[] dataset2 = { 1,2,3,4,5,6,7,8 };
        BST bst2 = new BST();
        for (int x : dataset2) {
            bst2.insert(x);
        }

        System.out.println(bst2.height(bst2.getRoot()));
        System.out.println(bst2.numOfLeafNodes(bst2.getRoot()));

        //solution - insertion-based
        BST bst3 = BST.createFromSortedArray(dataset2);

        System.out.println(bst3.height(bst3.getRoot()));
        System.out.println(bst3.numOfLeafNodes(bst3.getRoot()));


    } // end main
}

