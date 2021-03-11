package projects.week9.part2;

/**
 * A connection of linked nodes
 * that stem from a head node.
 * This head node is linked to a child node.
 * That child node is linked to a child node.
 * etc...
 * Eventually the child node is null.
 * This signifies the end of the linked list.
 *
 */
public class SingleLinkedList<T> {
    public static void main(String[] args)
    {
        SingleLinkedList<String> list = new SingleLinkedList<>();

        list.addNodeToBeginning("Sam");
        list.addNodeToBeginning("Bob");
        list.addNodeToEnd("Tammy");
        list.print();
        list.add(2,"Inserted Into Position 2");
        list.print();

        SingleLinkedList<Integer> list2 = new SingleLinkedList<>();
        list2.addNodeToBeginning(23);
        list2.addNodeToBeginning(13);
        list2.addNodeToBeginning(73);
        list2.print();
    }
    private Node head = null;

    /**
     * Contains the data in which the node is supposed to hold.
     * Contains the next node in the line.
     */
    public class Node {
        private T data;
        private Node next;

        /**
         * Creates a new node that stores the data given.
         * This node currently points to nothing.
         *
         * @param data  The data being stored.
         */
        public Node(T data)
        {
            this(data,null);
        }
        /**
         * Creates a new node that stores the data given.
         * This node will point to the provided next node.
         *
         * @param data  The data being stored.
         * @param next  The connected node.
         */
        public Node(T data, Node  next)
        {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * Adds the data to the front of the linked list.
     *
     * Creates a new node with the given data.
     * if the head node exists, then the new node connects to the head node.
     *
     * Set the head equal to the new node.
     *
     * @param data  The data being stored at the beginning.
     */
    public void addNodeToBeginning(T data)
    {
        Node newNode = new Node(data);

        if (this.head != null) {
            newNode.next = this.head;
        }
        this.head = newNode;
    }

    /**
     * Adds the data to the end of the linked list.
     *
     * Creates a new node with the given data.
     * if the head node does not exist, the head is now the new node.
     * otherwise:
     *      while the current node is connected:
     *          current node = node connected to current node.
     *      connect current node to new node.
     *
     * @param data  The data being stored at the end.
     */
    public void addNodeToEnd(T data)
    {
        Node newNode = new Node(data);

        if(this.head == null){
            this.head = newNode;
        }else{
            Node current = this.head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }

    /**
     * Adds a node at a position within the linked list.
     *
     * Creates a new node with the given data.
     * if the position is 1:
     *      append new node onto head then end.
     *
     * Current and previous node is equal to the head.
     * while the current node connects to something
     *    and the current position is greater than 0:
     *      subtract 1 from current position.
     *
     *      set previous equal to the current node
     *      and set the current node equal to it's connection.
     *
     * Append the new Node onto the previous node.
     * Then connect the new node to the old node (current node).
     *
     *
     * @param position  The position in which to insert the data.
     * @param data      The data being stored at that position.
     */
    public void add(int position, T data)
    {
        Node newNode = new Node(data);

        Node current = this.head, previous = this.head;

        if(position == 1){
            newNode.next = head;
            this.head = newNode;
            return;
        }

        while(current.next != null && --position > 0)
        {
            previous = current;
            current = current.next;
        }

        previous.next = newNode;
        newNode.next = current;
    }

    public void print()
    {
        if(this.head == null){
            System.out.println("Empty List");
        }else{
            System.out.println("Single linked List Contents: ");
            Node current = head;
            while(current != null){
                System.out.print(current.data);
                current = current.next;
                System.out.print(current == null ? "\n" : " -> ");
            }
        }
    }

}
