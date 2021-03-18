package projects.week10;

import java.util.Arrays;

public class Stack <T>{
    public static void main( String[] args )
    {
        Stack<Integer> stack = new Stack<>(4);
        System.out.println(stack.pop());
        stack.push(34);
        System.out.println(stack);
        stack.push(2);
        System.out.println(stack);
        stack.push(13);
        System.out.println(stack);
        stack.push(23);
        System.out.println(stack);
        stack.push(44);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
    }
    private int maxSize;
    private int top;
    private T array[];

    public Stack(int maxSize)
    {
        this.maxSize = maxSize;
        this.top = -1;
        this.array = (T[]) new Object[maxSize];
    }

    public int getMaxSize()
    {
        return this.maxSize;
    }

    public boolean isEmpty()
    {
        return top == -1;
    }

    public boolean isFull()
    {
        return top == maxSize-1;
    }

    public T top()
    {
        if(isEmpty())
            return null;
        return array[top];
    }

    public void push(T data)
    {
        if(isFull()){
            System.err.println("Stack is already full!");
            return;
        }
        array[++top] = data;
    }

    public T pop()
    {
        if(isEmpty()) {
            System.err.println("Stack is already empty!");
            return null;
        }
        return array[top--];
    }

    @Override
    public String toString()
    {
        return Arrays.toString(array);
    }
}
