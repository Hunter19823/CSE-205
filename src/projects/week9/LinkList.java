package projects.week9;



public class LinkList<TYPE> {

    public static void main(String[] args)
    {
        LinkList<String> names = new LinkList<>();
        names.add("Brian");
        names.add("Bob");
        System.out.println(names.toString());
    }

    public class Node {
        public TYPE data;
        public Node next;

        public Node(TYPE data, Node next)
        {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString()
        {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
    public Node headNode;
    public int size;

    public LinkList() {
        headNode = null;
        size = 0;
    }

    public void add(TYPE data)
    {
        if(headNode == null){
            headNode = new Node(data,null);
        }else{
            Node current = headNode;
            for(int i=0;i<size-1;i++){
                current = current.next;
            }
            current.next = new Node(data,null);
        }
        size++;
    }

    @Override
    public String toString()
    {
        return "LinkList{" +
                "headNode=" + headNode +
                ", size=" + size +
                '}';
    }
}
