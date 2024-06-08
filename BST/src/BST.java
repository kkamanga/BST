//Kondwani Kamanga, CSC 2720: Data Structures, HW 6
public class BST {

    private Node root;

    public void insert(Integer key) {
        if (this.root == null)
            this.root = new Node(key);
        else
            insert(this.root, key);
    }

    public void insert(Node curr, int key){
        if (key >= curr.key){
            // our key is GREATER/EQUAL than the current value
            // we want to go right
            if(curr.rightChild == null) {
                Node newNode = new Node(key);
                curr.rightChild = newNode;
            } else {
                insert(curr.rightChild, key);
            }
        } else {
            // our key is LESS than our current value
            // (we're ignore duplicates)
            // we want to go left
            if(curr.leftChild == null) {
                Node newNode = new Node(key);
                curr.leftChild = newNode;
            } else {
                insert(curr.leftChild, key);
            }
        }
    }


    public Node find(Integer key) {
        if (root != null)
            return findHelper(this.root, key);
        return null;
    }

    public Node findHelper(Node curr, Integer key) {
        if (curr.key == key)
            return curr;
        if (key < curr.key && curr.leftChild != null)
            return findHelper(curr.leftChild, key);
        if (curr.rightChild != null)
            return findHelper(curr.rightChild, key);
        return null;
    }


    public void delete(Integer data) {
        Node current = this.root;
        Node parent = this.root;
        boolean isLeftChild = false;

        if (current == null)
            return; // tree is empty

        while (current != null && current.getKey() != data) {
            parent = current;
            if (data < current.getKey()) {
                current = current.getLeftChild();
                isLeftChild = true;
            } else {
                current = current.getRightChild();
                isLeftChild = false;
            }
        }
        if (current == null)
            return; // node to be deleted not found

        // case 1: node to be deleted has no children
        if (current.getLeftChild() == null && current.getRightChild() == null) {
            if (current == root) {
                root = null; // no elements in tree now
            } else {
                if (isLeftChild)
                    parent.setLeftChild(null);
                else
                    parent.setRightChild(null);
            }
        }
        // case 2: node to be deleted has 1 child
        else if (current.getRightChild() == null) {// current has left child
            if (current == root) {
                root = current.getLeftChild();
            } else if (isLeftChild) {
                parent.setLeftChild(current.getLeftChild());
            } else {
                parent.setRightChild(current.getLeftChild());
            }
        } else if (current.getLeftChild() == null) {// current has right child
            if (current == root) {
                root = current.getRightChild();
            } else if (isLeftChild) {
                parent.setLeftChild(current.getRightChild());
            } else {
                parent.setRightChild(current.getRightChild());
            }
        }
        // case 3: node to be deleted has 2 children)
        else {
            Node successor = getSuccessor(current);
            if(current == root) {
                root = successor;
            } else if(isLeftChild) {
                parent.setLeftChild(successor);
            } else {
                parent.setRightChild(successor);
            }
            successor.setLeftChild(current.getLeftChild());
        }
    }

    public Node getSuccessor(Node node) {
        Node current = node.getRightChild();
        Node successorParent = node;
        Node successor = node;

        while(current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if(successor != node.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(node.getRightChild());
        }
        return successor;
    }


    public int height(Node node) {
        int leftHeight = 0;
        int rightHeight = 0;
        if (node.leftChild != null) {
            leftHeight = 1 + height(node.leftChild);
        }
        if (node.rightChild != null) {
            rightHeight = 1 + height(node.rightChild);
        }
        return Math.max(leftHeight, rightHeight);
    }
    public int numOfLeafNodes(Node node) {
        if (node == null) {
            return 0;
        }
        if (isLeaf(node)) {
            return 1;
        }
        return numOfLeafNodes(node.leftChild) + numOfLeafNodes(node.rightChild);
    }

    public void traverseInOrder(){
        // is the tree empty?
        if(this.root == null){
            return;
        }
        inOrderHelper(root);
    }

    public void inOrderHelper(Node curr){
        if(curr == null){
            return;
        }
        inOrderHelper(curr.leftChild);
        System.out.print(curr.key + " ");
        inOrderHelper(curr.rightChild);
    }

    public static Node addSorted(int[] data, int start, int end) {
        if (end >= start) {
            int mid = (start+end)/2;
            Node newNode = new Node(data[mid]);
            newNode.setLeftChild(addSorted(data, start, mid-1));
            newNode.setRightChild(addSorted(data, mid+1, end));
            return newNode;
        }
        return null;
    }

    public static BST createFromSortedArray(int[] data) {
        BST bst = new BST();
        if (data != null && data.length > 0) {
            bst.root = addSorted(data, 0, data.length-1);
        }
        return bst;
    }

    public Node getRoot() { return this.root; };


    public boolean isLeaf(Node node) {
        return node.getLeftChild() == null && node.getRightChild() == null;
    }

}
