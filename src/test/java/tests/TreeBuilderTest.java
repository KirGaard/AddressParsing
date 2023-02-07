package tests;

import kirgaard.addressparsing.Model.Tree.SearchTree;
import kirgaard.addressparsing.Model.Tree.TreeBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeBuilderTest {

    @Test
    public void test(){
        String[] strings = new String[]{
                "Aabakken",
               "Aabenraa Landevej",
                "Aabenraavej",
                "Aabergs Vej",
                "Aaboulevarden"
        };

        TreeBuilder builder = new TreeBuilder(strings);
        SearchTree<String> tree = builder.getTree();
        String[] leafs = tree.getLeafsFromNode("a", 1);

        Assertions.assertNotEquals(0, strings.length);
    }

}