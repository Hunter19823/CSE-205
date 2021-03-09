package projects.week9;

/* ------------------------
 * public class Node<TYPE>
 * ------------------------
 * Ignore, I was just making this for no reason.
 *
 */
public class Node<TYPE> {
    private TYPE data;
    private Node<TYPE> previous;
    private Node<TYPE> next;

    public Node(TYPE data)
    {
        this(data,null,null);
    }
    public Node(TYPE data, Node<TYPE> previous)
    {
        this(data,previous,null);
    }
    public Node(TYPE data, Node<TYPE> previous, Node<TYPE> next)
    {
        this.data = data;
        this.previous = previous;
        this.next = next;
    }

    public TYPE getData()
    {
        return data;
    }

    public Node<TYPE> getNext()
    {
        return next;
    }

    public Node<TYPE> getPrevious()
    {
        return previous;
    }

    public boolean isHead()
    {
        return this.previous == null;
    }

    public boolean isTail()
    {
        return this.next == null;
    }

    public Node<TYPE> getTail()
    {
        if(this.isTail())
            return this;
        return this.next.getTail();
    }

    public Node<TYPE> getHead()
    {
        if(this.isHead())
            return this;
        return this.previous.getHead();
    }
}
