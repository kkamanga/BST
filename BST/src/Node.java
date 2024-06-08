public class Node {

    public Integer key;
    //private Integer value;
    public Node leftChild;
    public Node rightChild;

    public Node(Integer key) {
        this.key = key;
    }

    public Integer getKey() { //no setter method for key
        return this.key;
    }

    public Node getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(Node left) {
        this.leftChild = left;
    }

    public Node getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(Node right) {
        this.rightChild = right;
    }


}

