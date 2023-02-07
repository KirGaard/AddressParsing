package kirgaard.addressparsing.Model.Tree;

public interface SearchTree<T> {
    public void insert(T obj);
    public T[] getLeafsFromNode(T obj, int amount);
}
