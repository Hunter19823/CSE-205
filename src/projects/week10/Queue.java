package projects.week10;

public class Queue <T>{
    public static void main( String[] args )
    {
        Queue<Integer> queue = new Queue<>(5);
        queue.enqueue(2);
        System.out.println(queue);
        queue.enqueue(4);
        System.out.println(queue);
        queue.enqueue(6);
        System.out.println(queue);
        queue.enqueue(8);
        System.out.println(queue);
        queue.enqueue(10);
        System.out.println(queue);

        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);

        queue.enqueue(12);
        System.out.println(queue);
        queue.enqueue(14);
        System.out.println(queue);
    }
    private int maxSize;
    private int front;
    private int back;
    private int currentSize;
    private T[] array;
    public Queue(int maxSize)
    {
        this.maxSize = maxSize;
        this.front = 0;
        this.back = -1;
        this.currentSize = 0;
        this.array = (T[]) new Object[maxSize];
    }

    public int getMaxSize()
    {
        return maxSize;
    }

    public int getCurrentSize()
    {
        return currentSize;
    }

    public boolean isEmpty()
    {
        return this.currentSize == 0;
    }

    public boolean isFull()
    {
        return this.currentSize == this.maxSize;
    }

    public T top()
    {
        return array[front];
    }

    public void enqueue(T data)
    {
        if(isFull())
            return;
        this.back = (this.back+1) % this.maxSize;
        this.array[this.back] = data;
        this.currentSize++;
    }
    public T dequeue()
    {
        if(isEmpty())
            return null;
        T temp = top();
        this.front = (this.front+1) % this.maxSize;
        this.currentSize--;

        return temp;
    }

    @Override
    public String toString()
    {
        if(isEmpty()){
            return "Empty Queue";
        }else{
            String out = "";
            for(int i=this.front; i != this.back;){
                out+=array[i];
                i=(i+1)%this.maxSize;
                if(i != this.back){
                    out+=" <- ";
                }
            }
            return out;
        }
    }
}
