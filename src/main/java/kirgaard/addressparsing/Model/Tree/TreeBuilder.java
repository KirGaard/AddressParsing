package kirgaard.addressparsing.Model.Tree;

public class TreeBuilder {
    private BKSearchTree tree;

    public TreeBuilder(String[] strings){
        tree = new BKSearchTree(new Node(null, ' '));

        for (String string : strings){
            tree.insert(string);
        }
    }

    public BKSearchTree getTree(){
        return tree;
    }
}
