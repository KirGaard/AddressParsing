package kirgaard.addressparsing.Model.Tree;

import kirgaard.addressparsing.Exceptions.NotImplementedYetException;
import kirgaard.addressparsing.Model.CharToInt;

public class Node<T> {
    private final int MAX_SIZE = 41;
    private Node parent;
    private Node[] children;
    private char value;

    public Node(Node parent, char value){
        this.parent = parent;
        this.value = value;
        children = new Node[MAX_SIZE];
    }
    public Node getFirstChild(){
        for (int i = 0; i < children.length; i++) {
            if (children[i] != null){
                return children[i];
            }
        }

        return null;
    }
    public Node getChild(char chr){
        return children[getIndex(chr)];
    }
    public Node getChild(int i){
        return children[i];
    }
    public void setChild(Node node, char chr){
        children[getIndex(chr)] = node;
    }
    public Node getParent(){
        return parent;
    }

    public boolean hasChild(char chr){
        return children[getIndex(chr)] != null;
    }
    public boolean isRoot(){
        return parent == null;
    }

    public char getValue(){
        return value;
    }

    protected int getIndex(char chr){
        return CharToInt.eval(chr);
    }
}
