package projects.week9.part2;

public class DoubleLinkedList<T> {
    public static void main(String[] args)
    {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();

        list.insertAtBeginning("Sam");
        list.insertAtBeginning("Bob");
        list.insertAtEnd("Tammy");
        //list.print();
        list.insertAtPosition("Inserted Into Position 2",2);
        //list.print();
        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();

        list2.insertAtBeginning(5);
        list2.insertAtBeginning(7);
        list2.insertAtBeginning(10);
        list2.insertAtBeginning(15);
        list2.insertAtEnd(30);
        list2.print();
        list2.insertAtPosition(34,3);
        list2.print();
        list2.deleteAtPosition(4);
        list2.print();
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

        if(isEmpty())
        {
            head = newNode;
            tail = head;
        }else{
            head.setLinkPrevious(newNode);
            newNode.setLinkNext(head);
            head = newNode;
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
        if(isEmpty())
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
     * Inserts a piece of data into a specific position of the linked list.
     *
     * if the position is the head:
     *   insert at the beginning.
     *   End.
     *
     * Create a new node representing the data.
     * Store a current node as current.
     * For each index starting at 2 going to size:
     *      if index equals insertion position:
     *          Insert newNode in-between the previous and next
     *          node.
     *          Increase size by 1.
     *          End.
     *
     * @param data      The data being inserted.
     * @param position  The position the data is being inserted into.
     */
    public void insertAtPosition(T data, int position)
    {
        if(position == 1)
        {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data,null,null);

        Node current = head;
        for(int i=2; i <= size; i++)
        {
            if(i == position) {
                Node temp  = current.getNext();
                current.setLinkNext(newNode);
                newNode.setLinkPrevious(current);
                newNode.setLinkNext(temp);
                temp.setLinkPrevious(newNode);
                size++;
                return;
            }
            current = current.getNext();
        }
    }

    /**
     * Deletes a node at a position.
     *
     * if the deletion position is the head or tail:
     *      if size is 1:
     *          empty list.
     *          End.
     *      otherwise:
     *          replace current head with the node
     *          after the old head.
     *          End.
     * otherwise:
     *      Store a current node as current.
     *      For each index starting at 2 going to size:
     *          if index equals insertion position:
     *              Insert newNode in-between the previous and next
     *              node.
     *              Decrease size by 1.
     *              End.
     *
     * @param position  The position the data is stored in the list.
     */
    public void deleteAtPosition(int position)
    {
        if(position == 1)
        {
            if(size == 1)
            {
                head = null;
                tail = null;
                size = 0;
                return;
            }
            head = head.getNext();
            head.setLinkNext(null);
            size--;
            return;
        }
        if(position == size)
        {
            tail = tail.getPrevious();
            tail.setLinkNext(null);
            size--;
            return;
        }

        Node current = head.getNext();
        for(int i=2; i <= size; i++) {
            if(i == position) {
                Node previous = current.getPrevious();
                Node next = current.getNext();
                previous.setLinkNext(next);
                next.setLinkPrevious(next);

                size--;
                return;
            }
            current = current.getNext();
        }
    }



    public void print()
    {
        if(isEmpty()){
            System.out.println("Empty List");
        }else{
            System.out.println("Double linked List Contents: ");
            Node current = head;
            while(current != null){
                System.out.print(current.data);
                current = current.next;
                System.out.print(current == null ? "\n" : " <-> ");
            }
        }
    }


    /**
     * Left/Right connecting Node
     *
     * Keep track of where this node is, what is before this node,
     * and what is after this node.
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
