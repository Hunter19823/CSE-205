package projects.week12;

public class Node {
    private int key, height;
    private Node left, right;
    public Node(int data){
        key = data;
        height = 1;
    }

    public int getKey()
    {
        return key;
    }

    public void setKey( int key )
    {
        this.key = key;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight( int height )
    {
        this.height = height;
    }

    public Node getLeft()
    {
        return left;
    }

    public void setLeft( Node left )
    {
        this.left = left;
    }

    public Node getRight()
    {
        return right;
    }

    public void setRight( Node right )
    {
        this.right = right;
    }
}
