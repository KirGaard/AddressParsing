package kirgaard.addressparsing.Model.Tree;

public class BKSearchTree implements SearchTree<String>{
    private Node root;

    public BKSearchTree(Node root){
        this.root = root;
    }

    @Override
    public void insert(String obj) {
        obj = obj.toLowerCase();
        char[] chars = obj.toCharArray();
        Node parent = root;

        for (int i = 0; i < chars.length; i++) {
            Node child = parent.getChild(chars[i]);
            if (child == null){
                Node newNode = new Node(parent, chars[i]);
                parent.setChild(newNode, chars[i]);
                parent = newNode;
            }else{
                parent = child;
            }
        }
    }

    @Override
    public String[] getLeafsFromNode(String obj, int amount) {
        String[] leafs = new String[amount];
        Node leafParent = null;
        Node curNode = root;

        char[] charObj = obj.toCharArray();
        StringBuilder path = new StringBuilder();
        int i = 0;

        while(curNode != null){
            char curChar;
            if (i >= charObj.length){
                Node first = curNode.getFirstChild();

                if (first == null) break;

                curChar = first.getValue();
            }else{
                curChar = charObj[i];
            }

            curNode = curNode.getChild(curChar);

            if (curNode != null){
                leafParent = curNode.getParent();
            }

            path.append(curChar);
            i++;
        }

        int count = 0;
        for (int j = 0; j < 40; j++) {

            if (count == amount) break;

            Node leaf = leafParent.getChild(j);
            if (leaf != null){
                leafs[count] = path.toString();
                count++;
            }

        }

        return leafs;
    }


}
