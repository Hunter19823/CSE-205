package projects.week9.part2;

public class DoubleLinkedList<T> {
    public static void main(String[] args)
    {
        DoubleLinkedList<String> linkedList1 = new DoubleLinkedList<>();
    }

    protected Node head, tail;

    private int size;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Returns whether or not the linked list has data stored.
     *
     * @return  boolean
     */
    public boolean isEmpty()
    {
        // return this.tail == null;
        // return this.size == 0;
        return  this.head == null;
    }

    /**
     * Returns the size of the linked list.
     *
     * @return size
     */
    public int getSize()
    {
        return this.size;
    }

    /**
     * Inserts a piece of data into the head of the linked list.
     *
     * Create a new node for the data.
     *
     * if the head does not exist:
     *      make the tail and head equal to the new node.
     * otherwise:
     *      Make the new node connect to head, and head connect to new node.
     *      Make the head equal to the new node.
     * increase size;
     *
     *
     * @param data  The data being Stored
     */
    public void insertAtBeginning(T data)
    {
        Node newNode = new Node(data,null,null);

        if(this.head == null)
        {
            this.head = newNode;
            this.tail = this.head;
        }else{
            this.head.setLinkPrevious(newNode);
            newNode.setLinkNext(this.head);
            this.head = newNode;
        }
        size++;
    }

    /**
     * Inserts a piece of data into the head of the linked list.
     *
     * Create a new node for the data.
     *
     * if the head does not exist:
     *      make the tail and head equal to the new node.
     * otherwise:
     *      Make the new node connect to tail, and tail connect to new node.
     *      Make the tail equal to the new node.
     * increase size;
     *
     *
     * @param data  The data being Stored
     */
    public void insertAtEnd(T data)
    {
        Node newNode = new Node(data,null,null);
        if(head == null)
        {
            head = newNode;
            tail = head;
        }else{
            newNode.setLinkPrevious(tail);
            tail.setLinkNext(newNode);
            tail = newNode;
        }
        size++;
    }





    /**
     * Left/Right connecting Node
     */
    public class Node{
        protected T data;
        protected Node next, previous;

        public Node()
        {
            this(null,null,null);
        }

        /**
         * Creates a node that stores some data
         * and connects to two other nodes.
         *
         * @param data      The data being stored.
         * @param next      The next node in the link.
         * @param previous  The previous node in the link.
         */
        public Node(T data, Node next, Node previous)
        {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }

        public T getData()
        {
            return data;
        }

        public Node getNext()
        {
            return next;
        }

        public Node getPrevious()
        {
            return previous;
        }

        public void setData(T data)
        {
            this.data = data;
        }

        public void setLinkNext(Node next)
        {
            this.next = next;
        }

        public void setLinkPrevious(Node previous)
        {
            this.previous = previous;
        }
    }
}
